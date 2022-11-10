/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lang.Language

class FishLanguage : Language("Fish") {
    companion object {
        val INSTANCE: FishLanguage = FishLanguage()
    }
}