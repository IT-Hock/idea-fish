/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang.psi.impl

import com.intellij.lang.PsiBuilder
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.openapi.util.Key

class FishParserUtil : GeneratedParserUtilBase() {
    companion object {
        private val IS_IN_BINDING: Key<Boolean> = Key.create("IS_IN_BINDING")

        @JvmStatic
        fun parseBindValue(
                builder: PsiBuilder,
                level: Int,
                expr: Parser
        ): Boolean {
            val oldValue: Boolean? = builder.getUserData(IS_IN_BINDING)
            return try {
                builder.putUserData(
                        IS_IN_BINDING,
                        true
                )
                expr.parse(
                        builder,
                        level
                )
            } finally {
                builder.putUserData(
                        IS_IN_BINDING,
                        oldValue
                )
            }
        }

        @JvmStatic
        fun parseNonBindValue(
                builder: PsiBuilder,
                level: Int,
                expr: Parser
        ): Boolean {
            val oldValue: Boolean? = builder.getUserData(IS_IN_BINDING)
            return try {
                builder.putUserData(
                        IS_IN_BINDING,
                        null
                )
                expr.parse(
                        builder,
                        level
                )
            } finally {
                builder.putUserData(
                        IS_IN_BINDING,
                        oldValue
                )
            }
        }

        @JvmStatic
        fun parseIsBindValue(
                builder: PsiBuilder,
                level: Int
        ): Boolean {
            val isInBinding: Boolean? = builder.getUserData(IS_IN_BINDING)
            return isInBinding != null && isInBinding
        }
    }
}