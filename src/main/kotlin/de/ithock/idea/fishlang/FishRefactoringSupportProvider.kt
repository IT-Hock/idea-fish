/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import de.ithock.idea.fishlang.psi.FishProperty

class FishRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(
            elementToRename: PsiElement,
            context: PsiElement?
    ): Boolean {
        return elementToRename is FishProperty
    }
}