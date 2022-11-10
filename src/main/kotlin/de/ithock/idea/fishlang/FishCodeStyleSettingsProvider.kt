/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleConfigurable
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class FishCodeStyleSettingsProvider : CodeStyleSettingsProvider() {
    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings? {
        return FishCodeStyleSettings(settings)
    }

    override fun getConfigurableDisplayName(): String? {
        return "Fish"
    }

    override fun createConfigurable(
            settings: CodeStyleSettings,
            modelSettings: CodeStyleSettings
    ): CodeStyleConfigurable {
        return object : CodeStyleAbstractConfigurable(
                settings,
                modelSettings,
                this.configurableDisplayName
        ) {
            override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel {
                return FishCodeStyleMainPanel(
                        currentSettings,
                        settings
                )
            }
        }
    }

    private class FishCodeStyleMainPanel(
            currentSettings: CodeStyleSettings?,
            settings: CodeStyleSettings?
    ) : TabbedLanguageCodeStylePanel(
            FishLanguage.INSTANCE,
            currentSettings,
            settings
    )
}