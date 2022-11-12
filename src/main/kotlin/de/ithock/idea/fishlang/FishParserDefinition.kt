/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.json.JsonElementTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import de.ithock.idea.fishlang.parser.FishParser
import de.ithock.idea.fishlang.psi.FishElementTypes
import de.ithock.idea.fishlang.psi.FishFileImpl
import de.ithock.idea.fishlang.psi.FishTokenType

class FishParserDefinition : ParserDefinition {
    val WHITE_SPACES = TokenSet.WHITE_SPACE
    val STRING_LITERALS = TokenSet.create(
            FishElementTypes.SINGLE_QUOTED_STRING,
            FishElementTypes.DOUBLE_QUOTED_STRING
    )
    val COMMENTS = TokenSet.create(FishElementTypes.LINE_COMMENT)
    val FILE = IFileElementType(Language.findInstance(FishLanguage::class.java))
    val BOOLEANS = TokenSet.create(
            FishElementTypes.TRUE,
            FishElementTypes.FALSE
    )
    val KEYWORDS = TokenSet.create(
            FishElementTypes.TRUE,
            FishElementTypes.FALSE,
            FishElementTypes.IF,
            FishElementTypes.ELSE,
            FishElementTypes.ELSEIF,
            FishElementTypes.IN,
            FishElementTypes.FOR,
            FishElementTypes.RETURN,
            FishElementTypes.CONTINUE,
            FishElementTypes.BREAK,
    )
    val FISH_LITERALS = TokenSet.create(
            FishElementTypes.STRING_LITERAL,
            FishElementTypes.NUMBER_LITERAL,
            FishElementTypes.TRUE,
            FishElementTypes.FALSE
    )

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
        return FishFileImpl(viewProvider)
    }

    override fun spaceExistenceTypeBetweenTokens(
            left: ASTNode,
            right: ASTNode
    ): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return FishElementTypes.Factory.createElement(node)
    }

    private fun asFishTokenType(elementType: IElementType): FishTokenType? {
        return if (elementType is FishTokenType) elementType else null
    }
}