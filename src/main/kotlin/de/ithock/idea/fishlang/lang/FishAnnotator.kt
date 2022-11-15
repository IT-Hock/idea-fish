/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.lang

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import de.ithock.idea.fishlang.FishSyntaxHighlighter
import de.ithock.idea.fishlang.psi.FishElementTypes
import de.ithock.idea.fishlang.psi.types.FishEnvVariableElement
import de.ithock.idea.fishlang.psi.types.FishStringElement
import de.ithock.idea.fishlang.psi.types.number.FishBaseNumberElement
import de.ithock.idea.fishlang.psi.types.number.FishIntegerElement


class FishAnnotator : Annotator {
    override fun annotate(
        element: PsiElement, holder: AnnotationHolder
    ) {
        // Marks / Environment variables as such.
        if (/*element.elementType == FishElementTypes.ENV_IDENTIFIER ||*/
            element.parent is FishEnvVariableElement
        ) {
            (element.parent as FishEnvVariableElement).addAnnotation(holder)
        }

        // Marks / Annotates environment variables in strings.
        if (element.parent is FishStringElement/* ||
            element.elementType == FishElementTypes.SINGLE_QUOTED_STRING ||
            element.elementType == FishElementTypes.DOUBLE_QUOTED_STRING*/
        ) {
            (element.parent as FishStringElement).addAnnotation(holder)
        }

        if (/*element.elementType == FishElementTypes.HEX_NUMBER ||
            element.elementType == FishElementTypes.BINARY_NUMBER ||
            element.elementType == FishElementTypes.UNICODE_CHAR ||*/
            element.parent is FishBaseNumberElement
        ) {
            val fishNumberElement = element.parent as FishBaseNumberElement
            fishNumberElement.addAnnotation(holder)
        }
    }
}