/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types.number

import com.intellij.lang.ASTNode
import de.ithock.idea.fishlang.lang.attributes.NumberTextAttributes

open class FishUnicodeCharElement : FishBaseNumberElement {
    private var integerValue: Int?
    private val replaceRegex = Regex("[^0-9a-fA-F]")
    private val verifyRegex = Regex("[0-9a-fA-F]{1,4}")

    private val unicodeChar: Char?

    constructor(node: ASTNode) : super(node, NumberTextAttributes.UNICODE_CHAR) {
        val cleanedText = node.text.replace(replaceRegex, "")
        when {
            verifyRegex.matches(cleanedText) -> {
                integerValue = cleanedText.toInt(16)
                unicodeChar = integerValue!!.toChar()
            }

            else                             -> {
                integerValue = null
                unicodeChar = null
            }
        }
    }

    override fun getValue(): Int? {
        return integerValue
    }

    override fun getErrorTooltip(): String {
        return "The unicode character can only contain hexadecimal digits (0-9, a-f, A-F)\n" +
                "and must be between 1 and 4 digits long."
    }

    override fun toString(): String {
        return "UnicodeChar (0x${integerValue?.toString(16)})"
    }

    override fun getAnnotationTitle(): String {
        return "Unicode Char"
    }

    companion object {
        private const val serialVersionUID: Long = 3535841585157634617L
    }
}