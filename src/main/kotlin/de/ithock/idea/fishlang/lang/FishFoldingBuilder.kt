/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.lang


import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import de.ithock.idea.fishlang.psi.FishCodeBlock
import de.ithock.idea.fishlang.psi.FishElementTypes
import de.ithock.idea.fishlang.psi.FishFunctionDefinition
import de.ithock.idea.fishlang.psi.FishIfStatement


class FishFoldingBuilder : FoldingBuilderEx(),
    DumbAware {
    override fun buildFoldRegions(
        root: PsiElement,
        document: Document,
        quick: Boolean
    ): Array<FoldingDescriptor> {
        // Initialize the list of folding regions
        val descriptors: MutableList<FoldingDescriptor> = ArrayList()
        val functionDefinitions = PsiTreeUtil.findChildrenOfType(
            root,
            FishFunctionDefinition::class.java
        )

        descriptors.addAll(functionDefinitions.map {
            var textRange = getLineCommentTextRange(it)
            FoldingDescriptor(
                it.node,
                textRange,
                FoldingGroup.newGroup(
                    it.functionName.text
                )
            )
        })

        val regionBlockDefinitions = PsiTreeUtil.findChildrenOfType(
            root,
            FishCodeBlock::class.java
        )

        descriptors.addAll(regionBlockDefinitions.map {
            var textRange = getLineCommentTextRange(it)
            FoldingDescriptor(
                it.node,
                textRange,
                FoldingGroup.newGroup(
                    it.text
                )
            )
        })

        val ifDefinitions = PsiTreeUtil.findChildrenOfType(
            root,
            FishIfStatement::class.java
        )

        descriptors.addAll(ifDefinitions.map {
            // This is basically an ugly hack because we include a trailing newline in the if definition
            var textRange = getLineCommentTextRange(it)
            FoldingDescriptor(
                it.node,
                textRange,
                FoldingGroup.newGroup(
                    it.text
                )
            )
        })

        return descriptors.toTypedArray()
    }

    private fun getLineCommentTextRange(psiElement: PsiElement): TextRange {
        // This is basically an ugly hack because we include a trailing newline in the definition
        var textRange = psiElement.textRange
        var text = psiElement.text
        if (text[text.length - 1] == '\n') {
            textRange = psiElement.textRange.grown(-1)
            text = text.substring(
                0,
                text.length - 1
            )
        }
        if (text[text.length - 1] == '\r') {
            textRange = psiElement.textRange.grown(-1)
            text = text.substring(
                0,
                text.length - 1
            )
        }

        if (text[text.length - 1] == ' ') {
            textRange = psiElement.textRange.grown(-1)
        }
        // If we have a comment before the statement, include it in the folding.

        // Go up the tree until we find a comment. But only if the elements are newlines, space or blank.
        goUpUntilComment(psiElement)?.let {
            textRange = TextRange(
                it.textRange.startOffset,
                textRange.endOffset
            )
        }
        return textRange
    }

    private fun goUpUntilComment(psiElement: PsiElement): PsiElement? {
        if (psiElement.prevSibling !== null) {
            var prevSibling = psiElement.prevSibling
            while (prevSibling.elementType === FishElementTypes.END_OF_LINE || TokenSet.WHITE_SPACE.contains(
                    prevSibling.elementType
                )
            ) {
                prevSibling = prevSibling.prevSibling
            }
            if (prevSibling.elementType === FishElementTypes.LINE_COMMENT) {
                return prevSibling
            }
        }
        return null
    }

    override fun getPlaceholderText(node: ASTNode): String {
        val clarifyingComment: PsiElement? = goUpUntilComment(node.psi)
        var clarifyingCommentText: String? = null
        if (clarifyingComment !== null) {
            clarifyingCommentText = clarifyingComment.text.replace(
                "#",
                ""
            )
                .trim()
        }

        if (node.elementType == FishElementTypes.FUNCTION_DEFINITION && node.psi is FishFunctionDefinition) {
            val fishFunctionDefinition = node.psi as FishFunctionDefinition
            when {
                clarifyingCommentText !== null -> {
                    return clarifyingCommentText
                }

                else                           -> return "function " + fishFunctionDefinition.functionName.text
            }
        } else if (node.elementType == FishElementTypes.CODE_BLOCK && node.psi is FishCodeBlock) {
            when {
                clarifyingCommentText !== null -> {
                    return clarifyingCommentText
                }

                else                           -> return "code block"
            }
        } else if (node.elementType == FishElementTypes.IF_STATEMENT && node.psi is FishIfStatement) {
            val fishIfStatement = node.psi as FishIfStatement
            when {
                clarifyingCommentText !== null -> {
                    return clarifyingCommentText
                }

                else                           -> return "if " + fishIfStatement.expression.text
            }
        }

        return "..."
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }
}