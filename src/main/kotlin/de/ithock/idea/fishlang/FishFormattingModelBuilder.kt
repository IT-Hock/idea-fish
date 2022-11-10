/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.formatting.Alignment
import com.intellij.formatting.FormattingContext
import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider
import com.intellij.formatting.SpacingBuilder
import com.intellij.formatting.Wrap
import com.intellij.formatting.WrapType
import com.intellij.psi.codeStyle.CodeStyleSettings
import de.ithock.idea.fishlang.psi.FishTypes

class FishFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val codeStyleSettings: CodeStyleSettings = formattingContext.getCodeStyleSettings()
        return FormattingModelProvider
                .createFormattingModelForPsiFile(
                        formattingContext.getContainingFile(),
                        FishBlock(
                                formattingContext.getNode(),
                                Wrap.createWrap(
                                        WrapType.NONE,
                                        false
                                ),
                                Alignment.createAlignment(),
                                createSpaceBuilder(codeStyleSettings)
                        ),
                        codeStyleSettings
                )
    }

    companion object {
        private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(
                    settings,
                    FishLanguage.INSTANCE
            )
                    .around(FishTypes.SEPARATOR)
                    .spaceIf(settings.getCommonSettings(FishLanguage.INSTANCE.id).SPACE_AROUND_ASSIGNMENT_OPERATORS)
                    .before(FishTypes.PROPERTY)
                    .none()
        }
    }
}