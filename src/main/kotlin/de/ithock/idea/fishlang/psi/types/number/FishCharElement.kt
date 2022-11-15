/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types.number

import com.intellij.lang.ASTNode
import de.ithock.idea.fishlang.lang.attributes.NumberTextAttributes

open class FishCharElement : FishBaseNumberElement {
    private val character: Char?

    private val replaceRegex = Regex("[^A-Fa-f]")
    private val verifyRegex = Regex("[A-Fa-f]")

    constructor(node: ASTNode) : super(node, NumberTextAttributes.CHAR) {
        val cleanedText = node.text.replace("\\c", "").replace(replaceRegex, "")

        when {
            cleanedText.length == 1 -> character = cleanedText.toInt(16).toChar()
            else                    -> character = null
        };
    }

    override fun toString(): String {
        return "Char 0x${character?.code?.toString(16)}"
    }

    override fun getValue(): Int? {
        return character?.code
    }

    override fun getErrorTooltip(): String {
        return "The char contains invalid characters"
    }

    override fun getAnnotationTitle(): String {
        return "Char"
    }

    companion object {
        private const val serialVersionUID: Long = 3535841585157634617L
    }
}