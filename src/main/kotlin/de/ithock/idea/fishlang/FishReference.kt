/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult
import de.ithock.idea.fishlang.psi.FishProperty

class FishReference(
        element: PsiElement,
        textRange: TextRange
) : PsiReferenceBase<PsiElement?>(
        element,
        textRange
),
        PsiPolyVariantReference {
    private val key: String

    init {
        key = element.text.substring(
                textRange.startOffset,
                textRange.endOffset
        )
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement!!.project
        val properties: List<FishProperty> = FishUtil.findProperties(
                project,
                key
        )
        val results: MutableList<ResolveResult> = ArrayList()
        for (property in properties) {
            results.add(PsiElementResolveResult(property))
        }
        return results.toTypedArray()
    }

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }

    override fun getVariants(): Array<Any> {
        val project = myElement!!.project
        val properties: List<FishProperty> = FishUtil.findProperties(project)
        val variants: MutableList<LookupElement> = ArrayList<LookupElement>()
        for (property in properties) {
            if (property.key === null)
                continue
            if (property.getKey()!!
                            .isNotEmpty()
            ) {
                variants.add(
                        LookupElementBuilder
                                .create(property)
                                .withIcon(FishIcons.FILE)
                                .withTypeText(
                                        property.getContainingFile()
                                                .getName()
                                )
                )
            }
        }
        return variants.toTypedArray()
    }
}