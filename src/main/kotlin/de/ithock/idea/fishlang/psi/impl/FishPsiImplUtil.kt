/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang.psi.impl

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import de.ithock.idea.fishlang.FishIcons
import de.ithock.idea.fishlang.psi.FishElementFactory
import de.ithock.idea.fishlang.psi.FishProperty
import de.ithock.idea.fishlang.psi.FishTypes
import javax.swing.Icon

object FishPsiImplUtil {

    @JvmStatic
    fun getKey(element: FishProperty): String? {
        val keyNode = element.node.findChildByType(FishTypes.KEY)
        return keyNode?.text?.replace(
                "\\\\ ".toRegex(),
                " "
        )
    }

    @JvmStatic
    fun getValue(element: FishProperty): String? {
        val valueNode = element.node.findChildByType(FishTypes.VALUE)
        return valueNode?.text
    }

    @JvmStatic
    fun getName(element: FishProperty): String? {
        return getKey(element)
    }

    @JvmStatic
    fun setName(
            element: FishProperty,
            newName: String?
    ): PsiElement {
        val keyNode = element.node.findChildByType(FishTypes.KEY)
        if (keyNode != null) {
            val property = FishElementFactory.createProperty(
                    element.project,
                    newName
            )
            val newKeyNode = property.firstChild.node
            element.node.replaceChild(
                    keyNode,
                    newKeyNode
            )
        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: FishProperty): PsiElement? {
        val keyNode = element.node.findChildByType(FishTypes.KEY)
        return keyNode?.psi
    }

    @JvmStatic
    fun getPresentation(element: FishProperty): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return element.key
            }

            override fun getLocationString(): String? {
                val containingFile = element.containingFile
                return containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon? {
                return FishIcons.FILE
            }
        }
    }
}