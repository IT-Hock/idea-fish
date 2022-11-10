/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.icons.AllIcons
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension
import com.intellij.lang.Language
import de.ithock.idea.fishlang.psi.FishFile
import de.ithock.idea.fishlang.psi.FishProperty
import javax.swing.Icon

class FishStructureAwareNavbar : StructureAwareNavBarModelExtension() {
    protected override val language: Language
        get() = FishLanguage.INSTANCE


    override fun getPresentableText(`object`: Any): String? {
        if (`object` is FishFile) {
            return `object`.getName()
        }
        return if (`object` is FishProperty) {
            `object`.getName()
        } else null
    }

    override fun getIcon(`object`: Any): Icon? {
        return if (`object` is FishProperty) {
            AllIcons.Nodes.Property
        } else null
    }
}