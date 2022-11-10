/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.spellchecker.inspections.CommentSplitter
import com.intellij.spellchecker.inspections.IdentifierSplitter
import com.intellij.spellchecker.inspections.PlainTextSplitter
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy
import com.intellij.spellchecker.tokenizer.TokenConsumer
import com.intellij.spellchecker.tokenizer.Tokenizer
import de.ithock.idea.fishlang.psi.FishProperty
import de.ithock.idea.fishlang.psi.FishTypes

class FishSpellcheckingStrategy : SpellcheckingStrategy() {
    override fun getTokenizer(element: PsiElement): Tokenizer<*> {
        if (element is PsiComment) {
            return FishCommentTokenizer()
        }
        return if (element is FishProperty) {
            FishPropertyTokenizer()
        } else SpellcheckingStrategy.EMPTY_TOKENIZER
    }

    private class FishCommentTokenizer : Tokenizer<PsiComment>() {
        override fun tokenize(
                element: PsiComment,
                consumer: TokenConsumer
        ) {
            // Exclude the start of the comment with its # characters from spell checking
            var startIndex = 0
            for (c in element.textToCharArray()) {
                if (c == '#' || Character.isWhitespace(c)) {
                    startIndex++
                } else {
                    break
                }
            }
            consumer.consumeToken(
                    element,
                    element.text,
                    false,
                    0,
                    TextRange.create(
                            startIndex,
                            element.textLength
                    ),
                    CommentSplitter.getInstance()
            )
        }
    }

    private class FishPropertyTokenizer : Tokenizer<FishProperty>() {
        override fun tokenize(
                element: FishProperty,
                consumer: TokenConsumer
        ) {
            //Spell check the keys and values of properties with different splitters
            val key: ASTNode? = element.getNode()
                    .findChildByType(FishTypes.KEY)
            if (key != null && key.textLength > 0) {
                val keyPsi = key.psi
                val text = key.text
                //For keys, use a splitter for identifiers
                //Note we set "useRename" to true so that keys will be properly refactored (renamed)
                consumer.consumeToken(
                        keyPsi,
                        text,
                        true,
                        0,
                        TextRange.allOf(text),
                        IdentifierSplitter.getInstance()
                )
            }
            val value: ASTNode? = element.getNode()
                    .findChildByType(FishTypes.VALUE)
            if (value != null && value.textLength > 0) {
                val valuePsi = value.psi
                val text = valuePsi.text
                //For values, use a splitter for plain text
                consumer.consumeToken(
                        valuePsi,
                        text,
                        false,
                        0,
                        TextRange.allOf(text),
                        PlainTextSplitter.getInstance()
                )
            }
        }
    }
}