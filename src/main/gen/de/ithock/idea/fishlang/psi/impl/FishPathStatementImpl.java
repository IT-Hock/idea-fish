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

public class FishPathStatementImpl extends ASTWrapperPsiElement implements FishPathStatement {

  public FishPathStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FishVisitor visitor) {
    visitor.visitPathStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FishVisitor) accept((FishVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getHpath() {
    return findChildByType(HPATH);
  }

  @Override
  @Nullable
  public PsiElement getPath() {
    return findChildByType(PATH);
  }

  @Override
  @Nullable
  public PsiElement getSpath() {
    return findChildByType(SPATH);
  }

  @Override
  @Nullable
  public PsiElement getUri() {
    return findChildByType(URI);
  }

}
