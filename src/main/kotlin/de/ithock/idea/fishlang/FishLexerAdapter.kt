/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.FlexLexer
import de.ithock.idea.fishlang.parser._FishLexer
import java.io.IOException




class FishLexerAdapter : FlexAdapter(_FishLexer(null))
{
}