/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import de.ithock.idea.fishlang.parser.FishParser
import de.ithock.idea.fishlang.parser._FishLexer
import de.ithock.idea.fishlang.psi.FishFile
import de.ithock.idea.fishlang.psi.FishTokenType
import de.ithock.idea.fishlang.psi.FishTypeUtil
import de.ithock.idea.fishlang.psi.FishTypes

class FishParserDefinition : ParserDefinition {
    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
    val COMMENTS = TokenSet.create(
            FishTypes.SCOMMENT
    )
    val STRING_LITERALS = TokenSet.create(
            FishTypes.STD_STRING,
            FishTypes.IND_STRING
    )

    val FILE = IFileElementType(Language.findInstance(FishLanguage::class.java))

    override fun createLexer(project: Project?): Lexer {
        return FishLexerAdapter()
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return STRING_LITERALS
    }

    override fun createParser(project: Project?): PsiParser {
        return FishParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return FishFile(viewProvider)
    }

    override fun spaceExistenceTypeBetweenTokens(
            left: ASTNode,
            right: ASTNode
    ): ParserDefinition.SpaceRequirements {
        val leftType: FishTokenType? = asFishTokenType(left.elementType)
        val rightType: FishTokenType? = asFishTokenType(right.elementType)
        if (leftType === FishTypes.SCOMMENT) {
            return ParserDefinition.SpaceRequirements.MUST_LINE_BREAK
        }
        return if (leftType === FishTypes.DOLLAR && rightType === FishTypes.LCURLY) {
            ParserDefinition.SpaceRequirements.MUST_NOT
        } else if (FishTypeUtil.MIGHT_COLLAPSE_WITH_ID.contains(leftType) &&
                FishTypeUtil.MIGHT_COLLAPSE_WITH_ID.contains(rightType)
        ) {
            ParserDefinition.SpaceRequirements.MUST
        } else {
            ParserDefinition.SpaceRequirements.MAY
        }
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return FishTypes.Factory.createElement(node)
    }

    private fun asFishTokenType(elementType: IElementType): FishTokenType? {
        return if (elementType is FishTokenType) elementType as FishTokenType else null
    }
}