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

public class FishExpressionImpl extends ASTWrapperPsiElement implements FishExpression {

  public FishExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FishVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FishVisitor) accept((FishVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FishEndOfLine getEndOfLine() {
    return findChildByClass(FishEndOfLine.class);
  }

  @Override
  @Nullable
  public FishArguments getArguments() {
    return findChildByClass(FishArguments.class);
  }

  @Override
  @Nullable
  public FishAssignment getAssignment() {
    return findChildByClass(FishAssignment.class);
  }

  @Override
  @Nullable
  public FishBuiltinFunctions getBuiltinFunctions() {
    return findChildByClass(FishBuiltinFunctions.class);
  }

  @Override
  @Nullable
  public FishCodeBlock getCodeBlock() {
    return findChildByClass(FishCodeBlock.class);
  }

  @Override
  @Nullable
  public FishCommand getCommand() {
    return findChildByClass(FishCommand.class);
  }

  @Override
  @Nullable
  public FishForStatement getForStatement() {
    return findChildByClass(FishForStatement.class);
  }

  @Override
  @Nullable
  public FishFunctionDefinition getFunctionDefinition() {
    return findChildByClass(FishFunctionDefinition.class);
  }

  @Override
  @Nullable
  public FishIfStatement getIfStatement() {
    return findChildByClass(FishIfStatement.class);
  }

  @Override
  @Nullable
  public FishStatement getStatement() {
    return findChildByClass(FishStatement.class);
  }

  @Override
  @Nullable
  public FishSwitchStatement getSwitchStatement() {
    return findChildByClass(FishSwitchStatement.class);
  }

  @Override
  @Nullable
  public FishWhileStatement getWhileStatement() {
    return findChildByClass(FishWhileStatement.class);
  }

}
