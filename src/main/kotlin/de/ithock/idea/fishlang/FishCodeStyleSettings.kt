/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class FishCodeStyleSettings(settings: CodeStyleSettings?) : CustomCodeStyleSettings(
        "FishCodeStyleSettings",
        settings
)