/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types

import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.TextRange
import de.ithock.idea.fishlang.lang.attributes.TextAttributes

open class FishEnvVariableElement : FishPsiElement {

    constructor(node: ASTNode) : super(node) {
    }

    override fun addAnnotation(holder: AnnotationHolder) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            //.range(this)
            .textAttributes(textAttribute)
            .create()
    }

    companion object {
        private val textAttribute: TextAttributesKey = TextAttributes.ENV_VARIABLE
        private const val serialVersionUID: Long = -6935414909589173748L

        public fun addAnnotation(holder: AnnotationHolder, textRange: TextRange) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(textRange)
                .textAttributes(textAttribute)
                .create()
        }
    }
}