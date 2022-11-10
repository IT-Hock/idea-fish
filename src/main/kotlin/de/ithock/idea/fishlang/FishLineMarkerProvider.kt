/*
 * Copyright (c) 2021 - 2022 IT-Hock. All rights reserved
 */
package de.ithock.idea.fishlang

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralValue
import de.ithock.idea.fishlang.psi.FishProperty

class FishLineMarkerProvider : RelatedItemLineMarkerProvider() {
    protected override fun collectNavigationMarkers(
            element: PsiElement,
            result: MutableCollection<in RelatedItemLineMarkerInfo<*>?>
    ) {
        // This must be an element with a literal expression as a parent
        if (element.parent !is PsiLiteralValue) {
            return
        }

        // The literal expression must start with the Fish language literal expression
        val literalExpression: PsiLiteralValue = element.parent as PsiLiteralValue
        val value = if (literalExpression.getValue() is String) literalExpression.getValue() as String else null
        if (value == null ||
                !value.startsWith(FishAnnotator.SIMPLE_PREFIX_STR + FishAnnotator.SIMPLE_SEPARATOR_STR)
        ) {
            return
        }

        // Get the Fish language property usage
        val project = element.project
        val possibleProperties: String = value.substring(
                FishAnnotator.SIMPLE_PREFIX_STR.length + FishAnnotator.SIMPLE_SEPARATOR_STR.length
        )
        val properties: List<FishProperty> = FishUtil.findProperties(
                project,
                possibleProperties
        )
        if (properties.size > 0) {
            // Add the property to a collection of line marker info
            val builder: NavigationGutterIconBuilder<PsiElement> = NavigationGutterIconBuilder.create(FishIcons.FILE)
                    .setTargets(properties)
                    .setTooltipText("Navigate to Fish language property")
            result.add(builder.createLineMarkerInfo(element))
        }
    }
}