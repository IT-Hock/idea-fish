/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.lexer.FlexAdapter
import de.ithock.idea.fishlang.parser._FishLexer

class FishLexerAdapter : FlexAdapter(_FishLexer(null))