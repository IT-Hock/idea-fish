/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.lang.attributes

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object BracketTextAttributes {

    val LPAREN: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "LPAREN",
        DefaultLanguageHighlighterColors.PARENTHESES
    )
    val RPAREN: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "RPAREN",
        DefaultLanguageHighlighterColors.PARENTHESES
    )

    val LCURLY: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "LCURLY",
        DefaultLanguageHighlighterColors.BRACES
    )
    val RCURLY: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "RCURLY",
        DefaultLanguageHighlighterColors.BRACES
    )

    val LBRAC: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "LBRAC",
        DefaultLanguageHighlighterColors.BRACKETS
    )
    val RBRAC: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
        "RBRAC",
        DefaultLanguageHighlighterColors.BRACKETS
    )

    val PAREN_KEYS = arrayOf<TextAttributesKey>(
        LPAREN,
        RPAREN,
        LCURLY,
        RCURLY,
        LBRAC,
        RBRAC
    )
}