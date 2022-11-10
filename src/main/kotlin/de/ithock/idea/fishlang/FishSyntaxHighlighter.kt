/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import de.ithock.idea.fishlang.psi.FishTypes

class FishSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return FishLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        if (tokenType == FishTypes.SEPARATOR) {
            return SEPARATOR_KEYS
        }
        if (tokenType == FishTypes.KEY) {
            return KEY_KEYS
        }
        if (tokenType == FishTypes.VALUE) {
            return VALUE_KEYS
        }
        if (tokenType == FishTypes.COMMENT) {
            return COMMENT_KEYS
        }
        return if (tokenType == TokenType.BAD_CHARACTER) {
            BAD_CHAR_KEYS
        } else EMPTY_KEYS
    }

    companion object {
        val SEPARATOR: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
                "SIMPLE_SEPARATOR",
                DefaultLanguageHighlighterColors.OPERATION_SIGN
        )
        val KEY: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
                "SIMPLE_KEY",
                DefaultLanguageHighlighterColors.KEYWORD
        )
        val VALUE: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
                "SIMPLE_VALUE",
                DefaultLanguageHighlighterColors.STRING
        )
        val COMMENT: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
                "SIMPLE_COMMENT",
                DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        val BAD_CHARACTER: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
                "SIMPLE_BAD_CHARACTER",
                HighlighterColors.BAD_CHARACTER
        )
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEY_KEYS = arrayOf(KEY)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}