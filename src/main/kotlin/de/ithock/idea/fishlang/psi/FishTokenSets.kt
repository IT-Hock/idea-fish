/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang.psi

import com.intellij.psi.tree.TokenSet

interface FishTokenSets {
    companion object {
        val IDENTIFIERS = TokenSet.create(FishTypes.KEY)
        val COMMENTS = TokenSet.create(FishTypes.COMMENT)
    }
}