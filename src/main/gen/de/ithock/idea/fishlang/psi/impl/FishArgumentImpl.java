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

public class FishArgumentImpl extends ASTWrapperPsiElement implements FishArgument {

  public FishArgumentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FishVisitor visitor) {
    visitor.visitArgument(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FishVisitor) accept((FishVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FishArrayAccess getArrayAccess() {
    return findChildByClass(FishArrayAccess.class);
  }

  @Override
  @Nullable
  public FishBuiltinFunctions getBuiltinFunctions() {
    return findChildByClass(FishBuiltinFunctions.class);
  }

  @Override
  @Nullable
  public FishCommand getCommand() {
    return findChildByClass(FishCommand.class);
  }

  @Override
  @Nullable
  public FishCommandEscape getCommandEscape() {
    return findChildByClass(FishCommandEscape.class);
  }

  @Override
  @Nullable
  public FishCommandPipe getCommandPipe() {
    return findChildByClass(FishCommandPipe.class);
  }

  @Override
  @Nullable
  public FishCommandWildcard getCommandWildcard() {
    return findChildByClass(FishCommandWildcard.class);
  }

  @Override
  @Nullable
  public FishEnvIdentifier getEnvIdentifier() {
    return findChildByClass(FishEnvIdentifier.class);
  }

  @Override
  @Nullable
  public FishInnerCommand getInnerCommand() {
    return findChildByClass(FishInnerCommand.class);
  }

  @Override
  @Nullable
  public FishIntegerType getIntegerType() {
    return findChildByClass(FishIntegerType.class);
  }

  @Override
  @Nullable
  public FishPathStatement getPathStatement() {
    return findChildByClass(FishPathStatement.class);
  }

  @Override
  @Nullable
  public FishPrimitiveTypes getPrimitiveTypes() {
    return findChildByClass(FishPrimitiveTypes.class);
  }

  @Override
  @Nullable
  public FishSemicolon getSemicolon() {
    return findChildByClass(FishSemicolon.class);
  }

  @Override
  @Nullable
  public FishStringLiteral getStringLiteral() {
    return findChildByClass(FishStringLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getArg() {
    return findChildByType(ARG);
  }

  @Override
  @Nullable
  public PsiElement getBinaryNumber() {
    return findChildByType(BINARY_NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getChar() {
    return findChildByType(CHAR);
  }

  @Override
  @Nullable
  public PsiElement getHexNumber() {
    return findChildByType(HEX_NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getUnicodeChar() {
    return findChildByType(UNICODE_CHAR);
  }

}
