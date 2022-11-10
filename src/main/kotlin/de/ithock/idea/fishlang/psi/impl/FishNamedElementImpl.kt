/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import de.ithock.idea.fishlang.psi.FishNamedElement

abstract class FishNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node),
        FishNamedElement