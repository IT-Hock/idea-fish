/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.navigation.ChooseByNameContributor
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project
import de.ithock.idea.fishlang.psi.FishProperty

class FishChooseByNameContributor : ChooseByNameContributor {
    override fun getNames(
            project: Project,
            includeNonProjectItems: Boolean
    ): Array<String> {
        val properties: List<FishProperty> = FishUtil.findProperties(project)
        val names: MutableList<String> = ArrayList(properties.size)
        for (property: FishProperty in properties) {
            if (property.key.isNullOrEmpty()) continue
            if (property.key!!.length > 0) {
                names.add(property.key!!)
            }
        }
        return names.toTypedArray()
    }

    override fun getItemsByName(
            name: String,
            pattern: String,
            project: Project,
            includeNonProjectItems: Boolean
    ): Array<NavigationItem> {
        // TODO: include non project items
        val properties: List<FishProperty> = FishUtil.findProperties(
                project,
                name
        )
        return properties.map { it as NavigationItem }
                .toTypedArray()
    }
}