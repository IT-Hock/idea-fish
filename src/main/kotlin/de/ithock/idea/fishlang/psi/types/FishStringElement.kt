/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types

import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.openapi.util.TextRange

open class FishStringElement : FishPsiElement {
    constructor(node: ASTNode) : super(node) {
    }

    override fun addAnnotation(holder: AnnotationHolder) {
        text.split(" ").forEach {
            // Contains " and ' so must be removed.
            val cleanedText = it.replace(
                "\"", ""
            ).replace(
                "'", ""
            )
            if (cleanedText.startsWith("$")) {
                FishEnvVariableElement.addAnnotation(
                    holder, TextRange(
                        textRange.startOffset + text.indexOf(cleanedText),
                        textRange.startOffset + text.indexOf(cleanedText) + cleanedText.length
                    )
                )
            }
        }
    }

    companion object {
        private const val serialVersionUID: Long = -6935414909589173748L
    }
}