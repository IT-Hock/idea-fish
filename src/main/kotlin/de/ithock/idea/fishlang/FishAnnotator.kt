/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralValue
import de.ithock.idea.fishlang.psi.FishProperty

class FishAnnotator : Annotator {
    override fun annotate(
            element: PsiElement,
            holder: AnnotationHolder
    ) {
        // Ensure the Psi Element is an expression
        if (element !is PsiLiteralValue) {
            return
        }

        // Ensure the Psi element contains a string that starts with the prefix and separator
        val literalExpression: PsiLiteralValue = element as PsiLiteralValue
        val value = if (literalExpression.getValue() is String) literalExpression.getValue() as String else null
        if (value == null || !value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR)) {
            return
        }

        // Define the text ranges (start is inclusive, end is exclusive)
        // "fish:key"
        //  01234567890
        val prefixRange = TextRange.from(
                element.textRange.startOffset,
                SIMPLE_PREFIX_STR.length + 1
        )
        val separatorRange = TextRange.from(
                prefixRange.endOffset,
                SIMPLE_SEPARATOR_STR.length
        )
        val keyRange = TextRange(
                separatorRange.endOffset,
                element.textRange.endOffset - 1
        )

        // highlight "fish" prefix and ":" separator
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(prefixRange)
                .textAttributes(DefaultLanguageHighlighterColors.KEYWORD)
                .create()
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(separatorRange)
                .textAttributes(FishSyntaxHighlighter.SEPARATOR)
                .create()


        // Get the list of properties for given key
        val key = value.substring(SIMPLE_PREFIX_STR.length + SIMPLE_SEPARATOR_STR.length)
        val properties: List<FishProperty?>? = FishUtil.findProperties(
                element.project,
                key
        )
        if (properties!!.isEmpty()) {
            holder.newAnnotation(
                    HighlightSeverity.ERROR,
                    "Unresolved property"
            )
                    .range(keyRange)
                    .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL) // ** Tutorial step 18.3 - Add a quick fix for the string containing possible properties
                    .withFix(FishCreatePropertyQuickFix(key))
                    .create()
        } else {
            // Found at least one property, force the text attributes to Fish syntax value character
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(keyRange)
                    .textAttributes(FishSyntaxHighlighter.VALUE)
                    .create()
        }
    }

    companion object {
        // Define strings for the Fish language prefix - used for annotations, line markers, etc.
        const val SIMPLE_PREFIX_STR = "fish"
        const val SIMPLE_SEPARATOR_STR = ":"
    }
}