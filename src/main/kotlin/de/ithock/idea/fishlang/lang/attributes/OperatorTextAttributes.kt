/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.lang.attributes

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object OperatorTextAttributes {
    val GT = TextAttributesKey.createTextAttributesKey(
        "GT",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val LT = TextAttributesKey.createTextAttributesKey(
        "LT",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val LEQ = TextAttributesKey.createTextAttributesKey(
        "LEQ",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val GEQ = TextAttributesKey.createTextAttributesKey(
        "GEQ",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val NEQ = TextAttributesKey.createTextAttributesKey(
        "NEQ",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val EQ = TextAttributesKey.createTextAttributesKey(
        "EQ",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val PLUS = TextAttributesKey.createTextAttributesKey(
        "PLUS",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val MINUS = TextAttributesKey.createTextAttributesKey(
        "MINUS",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val DIVIDE = TextAttributesKey.createTextAttributesKey(
        "DIVIDE",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val TIMES = TextAttributesKey.createTextAttributesKey(
        "TIMES",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )

    val NOT = TextAttributesKey.createTextAttributesKey(
        "NOT",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val AND = TextAttributesKey.createTextAttributesKey(
        "AND",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val OR = TextAttributesKey.createTextAttributesKey(
        "OR",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )
    val COLON = TextAttributesKey.createTextAttributesKey(
        "COLON",
        DefaultLanguageHighlighterColors.OPERATION_SIGN
    )

    val COLON_KEYS = arrayOf(COLON)

    val OPERATOR_KEYS = arrayOf(
        GT,
        LT,
        LEQ,
        GEQ,
        NEQ,
        EQ,
        PLUS,
        MINUS,
        DIVIDE,
        TIMES,
        NOT,
        AND,
        OR,
    )
}