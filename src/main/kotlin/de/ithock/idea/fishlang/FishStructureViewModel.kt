/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import de.ithock.idea.fishlang.psi.FishProperty

class FishStructureViewModel(
        editor: Editor?,
        psiFile: PsiFile
) : StructureViewModelBase(
        psiFile,
        editor,
        FishStructureViewElement(psiFile)
),
        StructureViewModel.ElementInfoProvider {

    override fun getSorters(): Array<Sorter> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }

    override fun getSuitableClasses(): Array<Class<Any>> {
        val suitableClasses = arrayOf<Class<Any>>(
                FishProperty::class.java as Class<Any>
        )
        return suitableClasses
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return element.getValue() is FishProperty
    }
}