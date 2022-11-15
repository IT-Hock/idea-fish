/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.lang

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import de.ithock.idea.fishlang.FishIcons
import de.ithock.idea.fishlang.FishSyntaxHighlighter
import de.ithock.idea.fishlang.lang.attributes.KeywordTextAttributes
import de.ithock.idea.fishlang.lang.attributes.NumberTextAttributes
import de.ithock.idea.fishlang.lang.attributes.TextAttributes
import javax.swing.Icon


class FishColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon {
        return FishIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return FishSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        // Get file content from jar resources
        javaClass.getResourceAsStream("/demo.fish").use { stream ->
            if (stream != null) {
                return stream.bufferedReader().readText()
            }
            return "Could not load demo file"
        }
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Fish"
    }

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor(
                "Function", KeywordTextAttributes.FUNCTION
            ), AttributesDescriptor(
                "If", KeywordTextAttributes.IF
            ), AttributesDescriptor(
                "Else", KeywordTextAttributes.ELSE
            ), AttributesDescriptor(
                "Begin", KeywordTextAttributes.BEGIN
            ), AttributesDescriptor(
                "End", KeywordTextAttributes.END
            ), AttributesDescriptor(
                "For", KeywordTextAttributes.FOR
            ), AttributesDescriptor(
                "While", KeywordTextAttributes.WHILE
            ), AttributesDescriptor(
                "Switch", KeywordTextAttributes.SWITCH
            ), AttributesDescriptor(
                "Case", KeywordTextAttributes.CASE
            ), AttributesDescriptor(
                "Default", KeywordTextAttributes.DEFAULT
            ), AttributesDescriptor(
                "In", KeywordTextAttributes.IN
            ), AttributesDescriptor(
                "Comment", FishSyntaxHighlighter.LINE_COMMENT
            ), AttributesDescriptor(
                "Double quoted string", TextAttributes.DOUBLE_QUOTED_STRING
            ), AttributesDescriptor(
                "Single quoted string", TextAttributes.DOUBLE_QUOTED_STRING
            ), AttributesDescriptor(
                "Path", TextAttributes.PATH
            ), AttributesDescriptor(
                "SPath", TextAttributes.SPATH
            ), AttributesDescriptor(
                "HPath", TextAttributes.HPATH
            ), AttributesDescriptor(
                "Number", NumberTextAttributes.INT
            ), AttributesDescriptor(
                "Float", NumberTextAttributes.FLOAT
            ), AttributesDescriptor(
                "Hex number", NumberTextAttributes.HEX_NUMBER
            ), AttributesDescriptor(
                "Unicode", NumberTextAttributes.UNICODE_CHAR
            ), AttributesDescriptor(
                "Char", NumberTextAttributes.CHAR
            ), AttributesDescriptor(
                "Bad", FishSyntaxHighlighter.BAD_CHARACTER
            )
        )
    }
}