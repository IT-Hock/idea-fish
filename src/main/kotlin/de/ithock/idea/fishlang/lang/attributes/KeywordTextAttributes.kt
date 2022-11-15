/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.lang.attributes

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object KeywordTextAttributes {

    val IN = TextAttributesKey.createTextAttributesKey(
        "IN",
        DefaultLanguageHighlighterColors.KEYWORD
    )
    val ELSE = TextAttributesKey.createTextAttributesKey(
        "ELSE",
        DefaultLanguageHighlighterColors.KEYWORD
    )
    val IF = TextAttributesKey.createTextAttributesKey(
        "IF",
        DefaultLanguageHighlighterColors.KEYWORD
    );

    val FOR = TextAttributesKey.createTextAttributesKey(
        "FOR",
        DefaultLanguageHighlighterColors.KEYWORD
    )

    val WHILE = TextAttributesKey.createTextAttributesKey(
        "WHILE",
        DefaultLanguageHighlighterColors.KEYWORD
    )

    val FUNCTION = TextAttributesKey.createTextAttributesKey(
        "FUNCTION",
        DefaultLanguageHighlighterColors.KEYWORD
    )

    val BEGIN = TextAttributesKey.createTextAttributesKey(
        "BEGIN",
        DefaultLanguageHighlighterColors.KEYWORD
    )

    val END = TextAttributesKey.createTextAttributesKey(
        "END",
        DefaultLanguageHighlighterColors.KEYWORD
    )

    val SWITCH = TextAttributesKey.createTextAttributesKey(
        "SWITCH",
        DefaultLanguageHighlighterColors.KEYWORD
    )

    val CASE = TextAttributesKey.createTextAttributesKey(
        "CASE",
        DefaultLanguageHighlighterColors.KEYWORD
    )

    val DEFAULT = TextAttributesKey.createTextAttributesKey(
        "DEFAULT",
        DefaultLanguageHighlighterColors.KEYWORD
    )

    val BREAK = TextAttributesKey.createTextAttributesKey(
        "BREAK",
        DefaultLanguageHighlighterColors.KEYWORD
    )

    val KEYWORD_KEYS = arrayOf(
        IN,
        IF,
        ELSE,
        IN,
        FOR,
        WHILE,
        FUNCTION,
        BEGIN,
        END,
        SWITCH,
        CASE,
        DEFAULT,
        BREAK
    )
}