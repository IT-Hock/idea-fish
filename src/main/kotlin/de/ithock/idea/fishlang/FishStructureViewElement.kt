/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import de.ithock.idea.fishlang.psi.FishFile
import de.ithock.idea.fishlang.psi.FishProperty
import de.ithock.idea.fishlang.psi.impl.FishPropertyImpl

class FishStructureViewElement(private val myElement: NavigatablePsiElement) : StructureViewTreeElement,
        SortableTreeElement {

    override fun getValue(): Any {
        return myElement
    }

    override fun navigate(requestFocus: Boolean) {
        myElement.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return myElement.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return myElement.canNavigateToSource()
    }

    override fun getAlphaSortKey(): String {
        return myElement.name ?: ""
    }

    override fun getPresentation(): ItemPresentation {
        return myElement.presentation ?: PresentationData()
    }

    override fun getChildren(): Array<TreeElement> {
        if (myElement is FishFile) {
            val properties: List<FishProperty> = PsiTreeUtil.getChildrenOfTypeAsList(
                    myElement,
                    FishProperty::class.java
            )
            val treeElements: MutableList<TreeElement> = ArrayList(properties.size)
            for (property in properties) {
                treeElements.add(FishStructureViewElement(property as FishPropertyImpl))
            }
            return treeElements.toTypedArray()
        }
        return StructureViewTreeElement.EMPTY_ARRAY.map { it }
                .toTypedArray()
    }
}