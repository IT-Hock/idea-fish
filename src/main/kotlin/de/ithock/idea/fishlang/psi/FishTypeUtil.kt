/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi

import com.intellij.psi.tree.TokenSet

class FishTypeUtil {
    /** All token types which represent a keyword.  */
    val KEYWORDS = TokenSet.create(
            FishElementTypes.IF,
            FishElementTypes.ELSE,
            FishElementTypes.IN,
    )

    /** Tokens would collapse if they were not separated by whitespace.  */
    val MIGHT_COLLAPSE_WITH_ID = TokenSet.orSet(
            KEYWORDS,
            TokenSet.create(
                    FishElementTypes.IDENTIFIER,
                    FishElementTypes.INT,
                    FishElementTypes.FLOAT,
                    FishElementTypes.PATH,
            )
    )
}