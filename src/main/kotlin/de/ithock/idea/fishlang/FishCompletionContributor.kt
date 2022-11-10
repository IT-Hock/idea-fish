/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import de.ithock.idea.fishlang.psi.FishTypes
class FishCompletionContributor : CompletionContributor() {
    init {
        extend(com.intellij.codeInsight.completion.CompletionType.BASIC,
               com.intellij.patterns.PlatformPatterns.psiElement(FishTypes.VALUE),
               object : com.intellij.codeInsight.completion.CompletionProvider<CompletionParameters>() {
                   public override fun addCompletions(
                           parameters: CompletionParameters,
                           context: com.intellij.util.ProcessingContext,
                           resultSet: CompletionResultSet
                   ) {
                       resultSet.addElement(LookupElementBuilder.create("Hello"))
                   }
               }
        )
    }
}