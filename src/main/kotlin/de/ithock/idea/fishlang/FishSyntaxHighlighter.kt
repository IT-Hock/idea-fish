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
import de.ithock.idea.fishlang.lang.attributes.BracketTextAttributes
import de.ithock.idea.fishlang.lang.attributes.KeywordTextAttributes
import de.ithock.idea.fishlang.lang.attributes.OperatorTextAttributes
import de.ithock.idea.fishlang.psi.FishElementTypes
import de.ithock.idea.fishlang.psi.FishEnvTokenType


class FishSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return FishLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        if (
            tokenType == FishElementTypes.WILDCARD ||
            tokenType == FishElementTypes.NOT ||
            tokenType == FishElementTypes.AND ||
            tokenType == FishElementTypes.OR
        ) {
            return OperatorTextAttributes.OPERATOR_KEYS
        } else if (
            tokenType == FishElementTypes.RBRAC ||
            tokenType == FishElementTypes.LBRAC ||
            tokenType == FishElementTypes.RPAREN ||
            tokenType == FishElementTypes.LPAREN ||
            tokenType == FishElementTypes.RCURLY ||
            tokenType == FishElementTypes.LCURLY
        ) {
            return BracketTextAttributes.PAREN_KEYS;
        } else if (
            tokenType == FishElementTypes.IF ||
            tokenType == FishElementTypes.FOR ||
            tokenType == FishElementTypes.ELSE ||
            tokenType == FishElementTypes.IN
        ) {
            return KeywordTextAttributes.KEYWORD_KEYS;
        }

        if (FishParserDefinition.COMMENTS.contains(tokenType)) {
            return COMMENT_KEYS
        } else if (FishParserDefinition.KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS
        } else if (tokenType == FishElementTypes.BUILTIN_FUNCTION ||
            tokenType == FishElementTypes.BUILTIN_FUNCTIONS ||
            tokenType == FishElementTypes.ECHO || tokenType == FishElementTypes.SET ||
            tokenType == FishElementTypes.SOURCE || tokenType == FishElementTypes.ABBR
        ) {
            return PREDEFINED_SYMBOL_KEYS
        } else if (
            tokenType == FishElementTypes.ENV_IDENTIFIER || tokenType == FishElementTypes.ENV_VAR ||
            tokenType == FishEnvTokenType("ENV_VAR")
        ) {
            return ENV_VAR_KEYS
        } else if (tokenType == FishElementTypes.SINGLE_QUOTED_STRING ||
            tokenType == FishElementTypes.DOUBLE_QUOTED_STRING ||
            tokenType == FishElementTypes.STRING_LITERAL ||
            tokenType == FishElementTypes.ARGUMENT
        ) {
            return STRING_KEYS
        } else if (
            tokenType == FishElementTypes.ARGUMENT ||
            tokenType == FishElementTypes.ARGUMENTS ||
            tokenType == FishElementTypes.ARG
        ) {
            return ARGUMENT_KEYS
        } else if (FishParserDefinition.BOOLEANS.contains(tokenType)) {
            return BOOLEAN_KEYS
        } else if (tokenType == FishElementTypes.FUNCTION_DEFINITION) {
            return FUNCTION_KEYS
        } else if (tokenType == FishElementTypes.COMMAND || tokenType == FishElementTypes.COMMAND_IDENTIFIER) {
            return FUNCTION_CALL_KEYS
        } else if (tokenType == FishElementTypes.INTEGER_TYPE ||
            tokenType == FishElementTypes.FLOAT ||
            tokenType == FishElementTypes.FLOAT_TYPE ||
            tokenType == FishElementTypes.INT ||
            tokenType == FishElementTypes.HEX_NUMBER ||
            tokenType == FishElementTypes.BINARY_NUMBER ||
            tokenType == FishElementTypes.UNICODE_CHAR
        ) {
            return NUMBER_KEYS
        } else if (tokenType == FishElementTypes.SEMICOLON) {
            return SEMICOLON_KEYS
        } else if (tokenType == TokenType.BAD_CHARACTER) {
            return BAD_CHAR_KEYS
        } else if (FishParserDefinition.WHITE_SPACES.contains(tokenType)) {
            return EMPTY_KEYS
        }
        return EMPTY_KEYS
    }

    companion object {
        @Deprecated("Use Attributes.")
        val ENV_VARIABLE: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "FISH_ENV_VARIABLE",
            DefaultLanguageHighlighterColors.CONSTANT
        )

        @Deprecated("Use Attributes.")
        val LINE_COMMENT = TextAttributesKey.createTextAttributesKey(
            "LINE_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
        )

        @Deprecated("Use Attributes.")
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey(
            "FISH_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
        )

        @Deprecated("Use Attributes.")
        val KEYWORDS = TextAttributesKey.createTextAttributesKey(
            "FISH_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
        )

        @Deprecated("Use Attributes.")
        val BOOLEANS = TextAttributesKey.createTextAttributesKey(
            "FISH_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
        )

        @Deprecated("Use Attributes.")
        val FUNCTION = TextAttributesKey.createTextAttributesKey(
            "FISH_FUNCTION",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        )

        @Deprecated("Use Attributes.")
        val FUNCTION_CALL = TextAttributesKey.createTextAttributesKey(
            "FISH_FUNCTION_CALL",
            DefaultLanguageHighlighterColors.FUNCTION_CALL
        )

        @Deprecated("Use Attributes.")
        val STRING_LITERAL = TextAttributesKey.createTextAttributesKey(
            "FISH_STRING_LITERAL",
            DefaultLanguageHighlighterColors.STRING
        )

        @Deprecated("Use Attributes.")
        val PREDEFINED_SYMBOL = TextAttributesKey.createTextAttributesKey(
            "FISH_PREDEFINED_SYMBOLS",
            DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL
        )

        @Deprecated("Use Attributes.")
        val NUMBER = TextAttributesKey.createTextAttributesKey(
            "FISH_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER
        )

        @Deprecated("Use Attributes.")
        val SEMICOLON = TextAttributesKey.createTextAttributesKey(
            "FISH_SEMICOLON",
            DefaultLanguageHighlighterColors.SEMICOLON
        )

        @Deprecated("Use Attributes.")
        val CONSTANT = TextAttributesKey.createTextAttributesKey(
            "FISH_CONSTANT",
            DefaultLanguageHighlighterColors.CONSTANT
        )

        @Deprecated("Use Attributes.")
        val PARAMETER = TextAttributesKey.createTextAttributesKey(
            "FISH_PARAMETER",
            DefaultLanguageHighlighterColors.PARAMETER
        )

        @Deprecated("Use Attributes.")
        private val ENV_VAR_KEYS = arrayOf(
            CONSTANT,
            PREDEFINED_SYMBOL
        )

        @Deprecated("Use Attributes.")
        private val ARGUMENT_KEYS = arrayOf(PARAMETER)

        @Deprecated("Use Attributes.")
        private val SEMICOLON_KEYS = arrayOf(SEMICOLON)

        @Deprecated("Use Attributes.")
        private val PREDEFINED_SYMBOL_KEYS = arrayOf(PREDEFINED_SYMBOL)

        @Deprecated("Use Attributes.")
        private val NUMBER_KEYS = arrayOf(NUMBER)

        @Deprecated("Use Attributes.")
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)

        @Deprecated("Use Attributes.")
        private val STRING_KEYS = arrayOf(STRING_LITERAL)

        @Deprecated("Use Attributes.")
        private val KEYWORD_KEYS = arrayOf(KEYWORDS)

        @Deprecated("Use Attributes.")
        private val BOOLEAN_KEYS = arrayOf(BOOLEANS)

        @Deprecated("Use Attributes.")
        private val COMMENT_KEYS = arrayOf(LINE_COMMENT)

        @Deprecated("Use Attributes.")
        private val FUNCTION_KEYS = arrayOf(FUNCTION)

        @Deprecated("Use Attributes.")
        private val FUNCTION_CALL_KEYS = arrayOf(FUNCTION_CALL)

        @Deprecated("Use Attributes.")
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()

    }
}