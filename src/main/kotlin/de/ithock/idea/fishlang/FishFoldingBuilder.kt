/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralValue
import com.intellij.psi.util.PsiTreeUtil
import de.ithock.idea.fishlang.psi.FishProperty

class FishFoldingBuilder : FoldingBuilderEx(),
        DumbAware {
    override fun buildFoldRegions(
            root: PsiElement,
            document: Document,
            quick: Boolean
    ): Array<FoldingDescriptor> {
        // Initialize the group of folding regions that will expand/collapse together.
        val group: FoldingGroup = FoldingGroup.newGroup(FishAnnotator.SIMPLE_PREFIX_STR)
        // Initialize the list of folding regions
        val descriptors: MutableList<FoldingDescriptor> = ArrayList<FoldingDescriptor>()
        // Get a collection of the literal expressions in the document below root
        val literalExpressions: Collection<PsiLiteralValue> = PsiTreeUtil.findChildrenOfType(
                root,
                PsiLiteralValue::class.java
        )
        // Evaluate the collection
        for (literalExpression in literalExpressions) {
            val value = if (literalExpression.getValue() is String) literalExpression.getValue() as String else null
            if (value != null && value.startsWith(FishAnnotator.SIMPLE_PREFIX_STR + FishAnnotator.SIMPLE_SEPARATOR_STR)) {
                val project: Project = literalExpression.getProject()
                val key: String = value.substring(
                        FishAnnotator.SIMPLE_PREFIX_STR.length + FishAnnotator.SIMPLE_SEPARATOR_STR.length
                )
                // Get a list of all properties for a given key in the project
                val properties: List<FishProperty?>? = FishUtil.findProperties(
                        project,
                        key
                )
                if (properties!!.size == 1) {
                    // Add a folding descriptor for the literal expression at this node.
                    descriptors.add(
                            FoldingDescriptor(
                                    literalExpression.getNode(),
                                    TextRange(
                                            literalExpression.getTextRange()
                                                    .getStartOffset() + 1,
                                            literalExpression.getTextRange()
                                                    .getEndOffset() - 1
                                    ),
                                    group
                            )
                    )
                }
            }
        }
        return descriptors.toTypedArray<FoldingDescriptor>()
    }

    /**
     * Gets the Fish Language 'value' string corresponding to the 'key'
     *
     * @param node Node corresponding to PsiLiteralExpression containing a string in the format
     * SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR + Key, where Key is
     * defined by the Fish language file.
     */
    override fun getPlaceholderText(node: ASTNode): String {
        val retTxt = "..."
        if (node.psi is PsiLiteralValue) {
            val nodeElement: PsiLiteralValue = node.psi as PsiLiteralValue
            val key: String = (nodeElement.getValue() as String).substring(
                    FishAnnotator.SIMPLE_PREFIX_STR.length + FishAnnotator.SIMPLE_SEPARATOR_STR.length
            )
            val properties: List<FishProperty> = FishUtil.findProperties(
                    nodeElement.getProject(),
                    key
            )
            val place: String? = properties[0].getValue()
            // IMPORTANT: keys can come with no values, so a test for null is needed
            // IMPORTANT: Convert embedded \n to backslash n, so that the string will look
            // like it has LF embedded in it and embedded " to escaped "
            return place?.replace(
                    "\n".toRegex(),
                    "\\n"
            )
                    ?.replace(
                            "\"".toRegex(),
                            "\\\\\""
                    ) ?: retTxt
        }
        return retTxt
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return true
    }
}