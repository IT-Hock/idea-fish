/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */

package de.ithock.idea.fishlang.psi.types

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder

open class FishPsiElement : ASTWrapperPsiElement {
    constructor(node: ASTNode) : super(node) {
    }


    public open fun addAnnotation(holder: AnnotationHolder) {

    }
}