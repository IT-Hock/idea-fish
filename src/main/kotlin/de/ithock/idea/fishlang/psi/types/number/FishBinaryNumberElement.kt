/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types.number

import com.intellij.lang.ASTNode
import de.ithock.idea.fishlang.lang.attributes.NumberTextAttributes

open class FishBinaryNumberElement : FishBaseNumberElement {
    private val replaceRegex = Regex("[^0-1]")
    private val verifyRegex = Regex("[01]{1,3}")

    private val integerValue: Int?

    constructor(node: ASTNode) : super(node, NumberTextAttributes.BINARY_NUMBER) {
        val cleanedText = node.text.replace(replaceRegex, "")
        when {
            verifyRegex.matches(cleanedText) -> {
                integerValue = cleanedText.toIntOrNull(2)
            }

            else                             -> integerValue = null
        }
    }

    override fun toString(): String {
        return "BinaryNumber" + super.toString()
    }

    override fun getValue(): Int? {
        return integerValue
    }

    override fun getErrorTooltip(): String {
        return "The binary number contains invalid characters"
    }

    override fun getAnnotationTitle(): String {
        return "Binary Number"
    }

    companion object {
        private const val serialVersionUID: Long = 3535841585157634617L
    }
}