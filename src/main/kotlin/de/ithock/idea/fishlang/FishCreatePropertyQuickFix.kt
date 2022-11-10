/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.lang.ASTNode
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.IncorrectOperationException
import com.intellij.util.ThrowableRunnable
import de.ithock.idea.fishlang.psi.FishElementFactory
import de.ithock.idea.fishlang.psi.FishFile
import de.ithock.idea.fishlang.psi.FishProperty

internal class FishCreatePropertyQuickFix(private val key: String) : BaseIntentionAction() {
    override fun getText(): String {
        return "Create property '$key'"
    }

    override fun getFamilyName(): String {
        return "Create property"
    }

    override fun isAvailable(
            project: Project,
            editor: Editor,
            file: PsiFile
    ): Boolean {
        return true
    }

    @Throws(IncorrectOperationException::class)
    override operator fun invoke(
            project: Project,
            editor: Editor,
            file: PsiFile
    ) {
        ApplicationManager.getApplication()
                .invokeLater {
                    val virtualFiles: Collection<VirtualFile> = FileTypeIndex.getFiles(
                            FishFileType.Companion.INSTANCE,
                            GlobalSearchScope.allScope(project)
                    )
                    if (virtualFiles.size == 1) {
                        createProperty(
                                project,
                                virtualFiles.iterator()
                                        .next()
                        )
                    } else {
                        val descriptor: FileChooserDescriptor =
                            FileChooserDescriptorFactory.createSingleFileDescriptor(FishFileType.Companion.INSTANCE)
                        descriptor.setRoots(project.guessProjectDir())
                        val file1: VirtualFile? = FileChooser.chooseFile(
                                descriptor,
                                project,
                                null
                        )
                        if (file1 != null) {
                            createProperty(
                                    project,
                                    file1
                            )
                        }
                    }
                }
    }

    private fun createProperty(
            project: Project,
            file: VirtualFile
    ) {
        WriteCommandAction.writeCommandAction(project)
                .run<RuntimeException>(ThrowableRunnable<RuntimeException> {
                    val fishFile: FishFile? = PsiManager.getInstance(project)
                            .findFile(file) as FishFile?
                    val lastChildNode: ASTNode? = fishFile?.getNode()
                            ?.getLastChildNode()
                    // TODO: Add another check for CRLF
                    if (lastChildNode != null /* && !lastChildNode.getElementType().equals(FishTypes.CRLF)*/) {
                        fishFile.getNode()
                                .addChild(
                                        FishElementFactory.createCRLF(project)
                                                .getNode()
                                )
                    }
                    // IMPORTANT: change spaces to escaped spaces or the new node will only have the first word for the key
                    val property: FishProperty = FishElementFactory.createProperty(
                            project,
                            key.replace(
                                    " ".toRegex(),
                                    "\\\\ "
                            ),
                            ""
                    )
                    fishFile?.getNode()
                            ?.addChild(property.getNode())
                    (property.getLastChild()
                            .getNavigationElement() as Navigatable).navigate(true)
                    FileEditorManager.getInstance(project)
                            .getSelectedTextEditor()
                            ?.getCaretModel()
                            ?.moveCaretRelatively(
                                    2,
                                    0,
                                    false,
                                    false,
                                    false
                            )
                })
    }
}