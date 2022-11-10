/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.psi.PsiElement
import com.intellij.psi.presentation.java.SymbolPresentationUtil
import de.ithock.idea.fishlang.psi.FishProperty

class FishDocumentationProvider : AbstractDocumentationProvider() {
    /**
     * For the Fish Language, we don't have online documentation. However, if your language provides
     * references pages online, URLs for the element can be returned here.
     */
    override fun getUrlFor(
            element: PsiElement,
            originalElement: PsiElement
    ): List<String>? {
        return null
    }

    /**
     * Extracts the key, value, file and documentation comment of a Fish key/value entry and returns
     * a formatted representation of the information.
     */
    override fun generateDoc(
            element: PsiElement,
            originalElement: PsiElement?
    ): String? {
        if (element is FishProperty) {
            val key: String = element.getKey() ?: return "Missing"
            val value: String = element.getValue() ?: return "Missing"
            val file: String = SymbolPresentationUtil.getFilePathPresentation(element.containingFile)
            val docComment = FishUtil.findDocumentationComment(element)
            return renderFullDoc(
                    key,
                    value,
                    file,
                    docComment
            )
        }
        return null
    }

    /**
     * Provides the information in which file the Fish language key/value is defined.
     */
    override fun getQuickNavigateInfo(
            element: PsiElement,
            originalElement: PsiElement
    ): String? {
        if (element is FishProperty) {
            val key: String = element.getKey() ?: return "Missing"
            val file: String = SymbolPresentationUtil.getFilePathPresentation(element.containingFile)
            return "\"$key\" in $file"
        }
        return null
    }

    /**
     * Provides documentation when a Fish Language element is hovered with the mouse.
     */
    override fun generateHoverDoc(
            element: PsiElement,
            originalElement: PsiElement?
    ): String? {
        return generateDoc(
                element,
                originalElement
        )
    }

    /**
     * Creates a key/value row for the rendered documentation.
     */
    private fun addKeyValueSection(
            key: String,
            value: String,
            sb: StringBuilder
    ) {
        sb.append(DocumentationMarkup.SECTION_HEADER_START)
        sb.append(key)
        sb.append(DocumentationMarkup.SECTION_SEPARATOR)
        sb.append("<p>")
        sb.append(value)
        sb.append(DocumentationMarkup.SECTION_END)
    }

    /**
     * Creates the formatted documentation using [DocumentationMarkup]. See the Java doc of
     * [com.intellij.lang.documentation.DocumentationProvider.generateDoc] for more
     * information about building the layout.
     */
    private fun renderFullDoc(
            key: String,
            value: String,
            file: String,
            docComment: String
    ): String {
        val sb = StringBuilder()
        sb.append(DocumentationMarkup.DEFINITION_START)
        sb.append("Fish Property")
        sb.append(DocumentationMarkup.DEFINITION_END)
        sb.append(DocumentationMarkup.CONTENT_START)
        sb.append(value)
        sb.append(DocumentationMarkup.CONTENT_END)
        sb.append(DocumentationMarkup.SECTIONS_START)
        addKeyValueSection(
                "Key:",
                key,
                sb
        )
        addKeyValueSection(
                "Value:",
                value,
                sb
        )
        addKeyValueSection(
                "File:",
                file,
                sb
        )
        addKeyValueSection(
                "Comment:",
                docComment,
                sb
        )
        sb.append(DocumentationMarkup.SECTIONS_END)
        return sb.toString()
    }
}