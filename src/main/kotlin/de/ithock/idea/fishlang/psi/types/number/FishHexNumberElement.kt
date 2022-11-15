/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types.number

import com.intellij.lang.ASTNode
import de.ithock.idea.fishlang.lang.attributes.NumberTextAttributes
import java.util.Locale

open class FishHexNumberElement : FishBaseNumberElement {
    private val replaceRegex = Regex("[^0-9A-Fa-f]")
    private val verifyRegex = Regex("([0-7][0-9A-Fa-f])|[0-9]")

    private val integerValue: Int?

    constructor(node: ASTNode) : super(node, NumberTextAttributes.HEX_NUMBER) {
        // BUG: Weirdly enough \X is not the same as \x. \X can do \X00 to \XFF but \x can only do \x00 to \x7F or \x9
        val cleanedText = node.text.lowercase(Locale.getDefault()).replace(replaceRegex, "")
        when {
            verifyRegex.matches(cleanedText) -> {
                integerValue = cleanedText.toInt(16)
            }

            else                             -> {
                integerValue = null
            }
        }
    }

    override fun toString(): String {
        return "HexNumber 0x${integerValue?.toString(16)}"
    }

    override fun getErrorTooltip(): String {
        return "The number is not a valid hex number"
    }

    override fun getValue(): Int? {
        return integerValue
    }

    override fun getAnnotationTitle(): String {
        return "Hex Number"
    }

    companion object {
        private const val serialVersionUID: Long = 3535841585157634617L
    }
}