/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class FishFileType private constructor() : LanguageFileType(FishLanguage.INSTANCE) {
    override fun getName(): String {
        return "Fish File"
    }

    override fun getDescription(): String {
        return "Fish language file"
    }

    override fun getDefaultExtension(): String {
        return "fish"
    }

    override fun getIcon(): Icon {
        return FishIcons.FILE
    }

    companion object {
        val INSTANCE = FishFileType()
    }
}