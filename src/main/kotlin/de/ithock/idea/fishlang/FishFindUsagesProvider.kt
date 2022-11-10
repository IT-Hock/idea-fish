/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet
import de.ithock.idea.fishlang.psi.FishProperty
import de.ithock.idea.fishlang.psi.FishTokenSets

class FishFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(
                FishLexerAdapter(),
                FishTokenSets.IDENTIFIERS,
                FishTokenSets.COMMENTS,
                TokenSet.EMPTY
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is PsiNamedElement
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }

    override fun getType(element: PsiElement): String {
        return when (element) {
            is FishProperty -> {
                "fish property"
            }

            else            -> ""
        }
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return when (element) {
            is FishProperty -> {
                element.getKey() ?: ""
            }

            else            -> ""
        }
    }

    override fun getNodeText(
            element: PsiElement,
            useFullName: Boolean
    ): String {
        return when (element) {
            is FishProperty -> {
                element.getKey() + FishAnnotator.SIMPLE_SEPARATOR_STR + element.getValue()
            }

            else            -> ""
        }
    }
}