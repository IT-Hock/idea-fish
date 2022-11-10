/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import de.ithock.idea.fishlang.parser.FishParser
import de.ithock.idea.fishlang.psi.FishFile
import de.ithock.idea.fishlang.psi.FishTokenSets
import de.ithock.idea.fishlang.psi.FishTypes

class FishParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return FishLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return FishTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return FishParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return FishFile(viewProvider)
    }

    override fun createElement(node: ASTNode): PsiElement {
        return FishTypes.Factory.createElement(node)
    }

    companion object {
        val FILE = IFileElementType(FishLanguage.INSTANCE)
    }
}