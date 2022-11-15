/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.lang

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext


class FishCompletionContributor : CompletionContributor() {
    init {
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement(),
                object : CompletionProvider<CompletionParameters>() {
                    override fun addCompletions(
                            parameters: CompletionParameters,
                            context: ProcessingContext,
                            resultSet: CompletionResultSet
                    ) {
                        resultSet.addElement(LookupElementBuilder.create("simple:"));
                    }
                })
    }
}