/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.google.common.collect.Lists
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import de.ithock.idea.fishlang.psi.FishFile
import de.ithock.idea.fishlang.psi.FishProperty
import java.util.Collections
import java.util.LinkedList

object FishUtil {
    /**
     * Searches the entire project for Fish language files with instances of the Fish property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    fun findProperties(
            project: Project?,
            key: String
    ): List<FishProperty> {
        val result: MutableList<FishProperty> = ArrayList<FishProperty>()
        val virtualFiles: Collection<VirtualFile> = FileTypeIndex.getFiles(
                FishFileType.INSTANCE,
                GlobalSearchScope.allScope(project!!)
        )
        for (virtualFile in virtualFiles) {
            val fishFile: FishFile? = PsiManager.getInstance(project)
                    .findFile(virtualFile) as FishFile?
            if (fishFile != null) {
                val properties: Array<FishProperty>? = PsiTreeUtil.getChildrenOfType(
                        fishFile,
                        FishProperty::class.java
                )
                if (properties != null) {
                    for (property in properties) {
                        if (key == property.getKey()) {
                            result.add(property)
                        }
                    }
                }
            }
        }
        return result
    }

    fun findProperties(project: Project?): List<FishProperty> {
        val result: ArrayList<FishProperty> = ArrayList<FishProperty>()
        val virtualFiles: Collection<VirtualFile> = FileTypeIndex.getFiles(
                FishFileType.INSTANCE,
                GlobalSearchScope.allScope(project!!)
        )
        for (virtualFile in virtualFiles) {
            val fishFile: FishFile? = PsiManager.getInstance(project)
                    .findFile(virtualFile) as FishFile?
            if (fishFile != null) {
                val properties: Array<FishProperty>? = PsiTreeUtil.getChildrenOfType(
                        fishFile,
                        FishProperty::class.java
                )
                if (properties != null) {
                    Collections.addAll(
                            result,
                            *properties
                    )
                }
            }
        }
        return result
    }

    /**
     * Attempts to collect any comment elements above the Fish key/value pair.
     */
    fun findDocumentationComment(property: FishProperty): String {
        val result: MutableList<String> = LinkedList<String>()
        var element: PsiElement = property.getPrevSibling()
        while (element is PsiComment || element is PsiWhiteSpace) {
            if (element is PsiComment) {
                val commentText = element.getText()
                        .replaceFirst(
                                "[!# ]+".toRegex(),
                                ""
                        )
                result.add(commentText)
            }
            element = element.prevSibling
        }
        return StringUtil.join(
                Lists.reverse(result),
                "\n "
        )
    }
}