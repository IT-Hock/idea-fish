/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi

import com.intellij.psi.tree.TokenSet

class FishTypeUtil {
    companion object{

        /** All token types which represent a keyword.  */
        val KEYWORDS: TokenSet = TokenSet.create(
                FishTypes.IF,
                FishTypes.THEN,
                FishTypes.ELSE,
                FishTypes.LET,
                FishTypes.IN,
                FishTypes.REC,
                FishTypes.INHERIT,
                FishTypes.OR_KW
        )

        /** Tokens would collapse if they were not separated by whitespace.  */
        val MIGHT_COLLAPSE_WITH_ID: TokenSet = TokenSet.orSet(
                KEYWORDS,
                TokenSet.create(
                        FishTypes.ID,
                        FishTypes.INT,
                        FishTypes.FLOAT,
                        FishTypes.PATH,
                        FishTypes.HPATH,
                        FishTypes.SPATH,
                        FishTypes.URI
                )
        )
    }
}