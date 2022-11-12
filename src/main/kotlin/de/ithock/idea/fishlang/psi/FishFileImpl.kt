/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import de.ithock.idea.fishlang.FishFileType
import de.ithock.idea.fishlang.FishLanguage

class FishFileImpl(viewProvider: FileViewProvider) : PsiFileBase(
        viewProvider,
        FishLanguage.INSTANCE
) {
    override fun getFileType(): FileType {
        return FishFileType.INSTANCE
    }

    override fun toString(): String {
        return "Fish File"
    }
}