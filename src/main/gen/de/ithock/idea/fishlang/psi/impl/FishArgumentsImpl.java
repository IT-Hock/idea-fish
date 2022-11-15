// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.ithock.idea.fishlang.psi.FishElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import de.ithock.idea.fishlang.psi.*;

public class FishArgumentsImpl extends ASTWrapperPsiElement implements FishArguments {

  public FishArgumentsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FishVisitor visitor) {
    visitor.visitArguments(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FishVisitor) accept((FishVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FishArgument getArgument() {
    return findNotNullChildByClass(FishArgument.class);
  }

  @Override
  @Nullable
  public FishArguments getArguments() {
    return findChildByClass(FishArguments.class);
  }

}
