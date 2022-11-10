/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import de.ithock.idea.fishlang.FishFileType

object FishElementFactory {
    @JvmStatic
    fun createProperty(
            project: Project?,
            name: String?
    ): FishProperty {
        val file = createFile(
                project,
                name
        )
        return file.firstChild as FishProperty
    }

    @JvmStatic
    fun createFile(
            project: Project?,
            text: String?
    ): FishFile {
        val name = "dummy.simple"
        return PsiFileFactory.getInstance(project)
                .createFileFromText(
                        name,
                        FishFileType.INSTANCE,
                        text!!
                ) as FishFile
    }

    @JvmStatic
    fun createProperty(
            project: Project?,
            name: String,
            value: String
    ): FishProperty {
        val file = createFile(
                project,
                "$name = $value"
        )
        return file.firstChild as FishProperty
    }

    @JvmStatic
    fun createCRLF(project: Project?): PsiElement {
        val file = createFile(
                project,
                "\n"
        )
        return file.firstChild
    }
}