/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types.number

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import de.ithock.idea.fishlang.intentions.RemoveElement
import de.ithock.idea.fishlang.lang.attributes.NumberTextAttributes
import de.ithock.idea.fishlang.psi.types.FishPsiElement

open class FishBaseNumberElement : FishPsiElement {
    private val textAttributes: TextAttributesKey

    constructor(node: ASTNode) : this(node, NumberTextAttributes.INT)

    constructor(node: ASTNode, textAttributesKey: TextAttributesKey) : super(node) {
        textAttributes = textAttributesKey
    }

    override fun toString(): String {
        return "Base Number Element"
    }

    public open fun getAnnotationTitle(): String {
        return "Number"
    }

    public open fun getValue(): Int? {
        return null
    }

    // TODO: Localization?
    public open fun getErrorTooltip(): String {
        return "Invalid number"
    }

    public open fun getTooltip(): String? {
        val integerValue = getValue();
        if (integerValue == null) {
            return null
        }

        return """
<b>Hex:</b> <code>${integerValue.toString(16)}</code>
<b>Dec:</b> <code>${integerValue.toString()}</code>
<b>Oct:</b> <code>${integerValue.toString(8)}</code>
<b>Bin:</b> <code>${integerValue.toString(2)}</code>
<b>Char:</b> '<code>${integerValue.toChar()}</code>'
        """.trimIndent()
    }

    public override fun addAnnotation(holder: AnnotationHolder) {
        val tooltip = this.getTooltip()
        if (tooltip === null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Invalid " + this.getAnnotationTitle())
                .textAttributes(textAttributes)
                .highlightType(ProblemHighlightType.ERROR)
                .withFix(RemoveElement(this))
                .tooltip(getErrorTooltip())
                .create()
            return
        }

        holder.newAnnotation(
            HighlightSeverity.INFORMATION,
            getAnnotationTitle()
        )
            .tooltip(tooltip)
            .textAttributes(textAttributes)
            .create()
    }

    companion object {
        private const val serialVersionUID: Long = 8402923620518474138L
    }
}