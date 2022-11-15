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

public class FishAssignmentImpl extends ASTWrapperPsiElement implements FishAssignment {

  public FishAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FishVisitor visitor) {
    visitor.visitAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FishVisitor) accept((FishVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FishEnvIdentifier> getEnvIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishEnvIdentifier.class);
  }

  @Override
  @Nullable
  public FishIntegerType getIntegerType() {
    return findChildByClass(FishIntegerType.class);
  }

  @Override
  @Nullable
  public FishPrimitiveTypes getPrimitiveTypes() {
    return findChildByClass(FishPrimitiveTypes.class);
  }

  @Override
  @Nullable
  public FishStringLiteral getStringLiteral() {
    return findChildByClass(FishStringLiteral.class);
  }

}
