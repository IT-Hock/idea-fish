/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types.number

import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.colors.TextAttributesKey
import de.ithock.idea.fishlang.lang.attributes.NumberTextAttributes

open class FishIntegerElement : FishBaseNumberElement {
    protected var integerValue: Int?

    private val textAttributes: TextAttributesKey

    private val replaceRegex = Regex("[^0-9]")
    private val verifyRegex = Regex("[0-9]+")

    constructor(node: ASTNode) : super(node) {
        textAttributes = NumberTextAttributes.INT
        val cleanedText = node.text.replace(replaceRegex, "")
        when {
            cleanedText.matches(verifyRegex) -> {
                integerValue = cleanedText.toInt()
            }

            else                             -> {
                integerValue = null
            }
        }
    }

    override fun toString(): String {
        return "Integer ${integerValue.toString()} (0x${integerValue?.toString(16)})"
    }

    override fun getErrorTooltip(): String {
        return "The number is not a valid integer"
    }

    override fun getValue(): Int? {
        return integerValue
    }

    override fun getAnnotationTitle(): String {
        return "Integer"
    }

    companion object {
        private const val serialVersionUID: Long = 8402923620518474138L
    }
}