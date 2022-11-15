/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.lang.attributes

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object NumberTextAttributes {
    val HEX_NUMBER = TextAttributesKey.createTextAttributesKey(
        "HEX_NUMBER", DefaultLanguageHighlighterColors.NUMBER
    )
    val UNICODE_CHAR = TextAttributesKey.createTextAttributesKey(
        "UNICODE", DefaultLanguageHighlighterColors.NUMBER
    )
    val BINARY_NUMBER = TextAttributesKey.createTextAttributesKey(
        "BINARY_NUMBER", DefaultLanguageHighlighterColors.NUMBER
    )
    val CHAR = TextAttributesKey.createTextAttributesKey(
        "CHAR", DefaultLanguageHighlighterColors.NUMBER
    )
    val INT = TextAttributesKey.createTextAttributesKey(
        "INT", DefaultLanguageHighlighterColors.NUMBER
    )
    val FLOAT = TextAttributesKey.createTextAttributesKey(
        "FLOAT", DefaultLanguageHighlighterColors.NUMBER
    )


    val NUMBER_KEYS = arrayOf(
        INT, FLOAT, HEX_NUMBER, UNICODE_CHAR, CHAR
    )

    val INT_KEYS = arrayOf(INT)
    val FLOAT_KEYS = arrayOf(FLOAT)
    val HEX_NUMBER_KEYS = arrayOf(HEX_NUMBER)
    val UNICODE_KEYS = arrayOf(UNICODE_CHAR)
    val CHAR_KEYS = arrayOf(CHAR)
}