/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.intentions

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import de.ithock.idea.fishlang.FishLanguage
import de.ithock.idea.fishlang.psi.types.number.FishBaseNumberElement

class RemoveElement(val fishBaseNumberElement: FishBaseNumberElement) : IntentionAction {
    /**
     * Indicate whether this action should be invoked inside write action.
     * Should return {@code false} if, e.g., a modal dialog is shown inside the action.
     * If false is returned the action itself is responsible for starting write action
     * when needed, by calling {@link Application#runWriteAction(Runnable)}.
     *
     * @return {@code true} if the intention requires a write action, {@code false} otherwise.
     */
    override fun startInWriteAction(): Boolean {
        return true
    }

    /**
     * Returns text to be shown in the list of available actions, if this action
     * is available.
     *
     * @return the text to show in the intention popup.
     * @see #isAvailable(Project, Editor, PsiFile)
     */
    override fun getText(): String {
        return "Remove"
    }

    /**
     * Returns the name of the family of intentions. It is used to externalize
     * "auto-show" state of intentions. When the user clicks on a light bulb in intention list,
     * all intentions with the same family name get enabled/disabled.
     * The name is also shown in settings tree.
     *
     * @return the intention family name.
     */
    override fun getFamilyName(): String {
        return "Test"
    }

    /**
     * Checks whether this intention is available at a caret offset in the file.
     * If this method returns true, a light bulb for this intention is shown.
     *
     * It is supposed to be fast enough to be run on EDT thread as well.
     *
     * @param project the project in which the availability is checked.
     * @param editor  the editor in which the intention will be invoked.
     * @param file    the file open in the editor.
     * @return {@code true} if the intention is available, {@code false} otherwise.
     */
    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        if (file?.language !== FishLanguage.INSTANCE) {
            return false
        }

        return true
    }

    /**
     * Called when user invokes intention. This method is called inside command.
     * If {@link #startInWriteAction()} returns {@code true}, this method is also called
     * inside write action.
     *
     * @param project the project in which the intention is invoked.
     * @param editor  the editor in which the intention is invoked.
     * @param file    the file open in the editor.
     */
    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        fishBaseNumberElement.delete()
    }

}
