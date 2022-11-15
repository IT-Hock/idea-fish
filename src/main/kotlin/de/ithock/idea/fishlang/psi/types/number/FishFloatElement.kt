/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types.number

import com.intellij.lang.ASTNode
import de.ithock.idea.fishlang.lang.attributes.NumberTextAttributes

class FishFloatElement : FishBaseNumberElement {
    private var floatValue: Float? = null
    private val replaceRegex = Regex("[^0-9.]")
    private val verifyRegex = Regex("[0-9]+.[0-9]+")

    constructor(node: ASTNode) : super(node, NumberTextAttributes.FLOAT) {
        val cleanedText = node.text.replace(replaceRegex, "")
        when {
            cleanedText.matches(verifyRegex) -> {
                floatValue = cleanedText.toFloat()
            }

            else                             -> {
                floatValue = null
            }
        }
    }

    override fun toString(): String {
        return "Float ${floatValue}"
    }

    override fun getAnnotationTitle(): String {
        return "Float"
    }

    override fun getValue(): Int? {
        return floatValue?.toInt()
    }

    override fun getErrorTooltip(): String {
        return "Float number has the wrong format"
    }

    override fun getTooltip(): String? {
        if (floatValue === null) {
            return null
        }
        return """
<b>Float</b> <code>${floatValue.toString()}</code>
${super.getTooltip()}
"""
    }

    companion object {
        private const val serialVersionUID: Long = 3535841585157634617L
    }
}