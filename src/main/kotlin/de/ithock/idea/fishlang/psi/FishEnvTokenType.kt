/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi

import com.intellij.psi.tree.IElementType
import de.ithock.idea.fishlang.FishLanguage
import org.jetbrains.annotations.NonNls

class FishEnvTokenType(
        @NonNls
        debugName: String
) : IElementType(
        debugName,
        FishLanguage.INSTANCE
) {
    override fun toString(): String {
        return "FishEnvTokenType.${super.toString()}"
    }
}