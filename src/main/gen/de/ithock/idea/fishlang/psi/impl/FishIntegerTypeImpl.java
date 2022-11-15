// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.ithock.idea.fishlang.psi.FishElementTypes.*;
import de.ithock.idea.fishlang.psi.types.number.FishIntegerElement;
import de.ithock.idea.fishlang.psi.*;

public class FishIntegerTypeImpl extends FishIntegerElement implements FishIntegerType {

  public FishIntegerTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FishVisitor visitor) {
    visitor.visitIntegerType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FishVisitor) accept((FishVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FishIntegerType getIntegerType() {
    return findChildByClass(FishIntegerType.class);
  }

  @Override
  @NotNull
  public PsiElement getInt() {
    return findNotNullChildByType(INT);
  }

}
