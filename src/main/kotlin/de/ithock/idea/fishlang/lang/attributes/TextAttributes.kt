/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.lang.attributes

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object TextAttributes {

    val ENV_VARIABLE = createTextAttributesKey(
        "ENV_VARIABLE",
        DefaultLanguageHighlighterColors.INSTANCE_FIELD
    )

    val PATH = createTextAttributesKey(
        "PATH",
        DefaultLanguageHighlighterColors.LABEL
    )
    val SPATH = createTextAttributesKey(
        "SPATH",
        DefaultLanguageHighlighterColors.LABEL
    )
    val HPATH = createTextAttributesKey(
        "HPATH",
        DefaultLanguageHighlighterColors.LABEL
    )
    val SEMI = createTextAttributesKey(
        "SEMI",
        DefaultLanguageHighlighterColors.SEMICOLON
    )
    val COMMA = createTextAttributesKey(
        "COMMA",
        DefaultLanguageHighlighterColors.COMMA
    )
    val ID = createTextAttributesKey(
        "ID",
        DefaultLanguageHighlighterColors.IDENTIFIER
    )

    val DOUBLE_QUOTED_STRING = createTextAttributesKey(
        "DOUBLE_QUOTED_STRING",
        DefaultLanguageHighlighterColors.STRING
    )
    val SINGLE_QUOTED_STRING = createTextAttributesKey(
        "SINGLE_QUOTED_STRING",
        DefaultLanguageHighlighterColors.STRING
    )

    val SEMI_KEYS = arrayOf(SEMI)
    val COMMA_KEYS = arrayOf(COMMA)
    val ID_KEYS = arrayOf(ID)
    val STRING_KEYS = arrayOf(
        DOUBLE_QUOTED_STRING,
        SINGLE_QUOTED_STRING
    )
    val PATH_KEYS = arrayOf(
        PATH,
        SPATH,
        HPATH
    )
}