/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralValue
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext
import de.ithock.idea.fishlang.FishAnnotator.Companion.SIMPLE_PREFIX_STR
import de.ithock.idea.fishlang.FishAnnotator.Companion.SIMPLE_SEPARATOR_STR

class FishReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(PsiLiteralValue::class.java),
                object : PsiReferenceProvider() {
                    override fun getReferencesByElement(
                            element: PsiElement,
                            context: ProcessingContext
                    ): Array<PsiReference> {
                        val literalExpression: PsiLiteralValue = element as PsiLiteralValue
                        val value = if (literalExpression.getValue() is String) literalExpression.getValue() as String else null
                        if (value != null && value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR)) {
                            val property = TextRange(
                                    SIMPLE_PREFIX_STR.length + SIMPLE_SEPARATOR_STR.length + 1,
                                    value.length + 1
                            )
                            return arrayOf(
                                    FishReference(
                                            element,
                                            property
                                    )
                            )
                        }
                        return PsiReference.EMPTY_ARRAY
                    }
                })
    }
}