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

public class FishPrimitiveTypesImpl extends ASTWrapperPsiElement implements FishPrimitiveTypes {

  public FishPrimitiveTypesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FishVisitor visitor) {
    visitor.visitPrimitiveTypes(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FishVisitor) accept((FishVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FishBinaryNumberType getBinaryNumberType() {
    return findChildByClass(FishBinaryNumberType.class);
  }

  @Override
  @Nullable
  public FishCharType getCharType() {
    return findChildByClass(FishCharType.class);
  }

  @Override
  @Nullable
  public FishFloatType getFloatType() {
    return findChildByClass(FishFloatType.class);
  }

  @Override
  @Nullable
  public FishHexNumberType getHexNumberType() {
    return findChildByClass(FishHexNumberType.class);
  }

  @Override
  @Nullable
  public FishIntegerType getIntegerType() {
    return findChildByClass(FishIntegerType.class);
  }

  @Override
  @Nullable
  public FishUnicodeCharType getUnicodeCharType() {
    return findChildByClass(FishUnicodeCharType.class);
  }

}
