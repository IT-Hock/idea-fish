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

public class FishFunctionDefinitionImpl extends ASTWrapperPsiElement implements FishFunctionDefinition {

  public FishFunctionDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FishVisitor visitor) {
    visitor.visitFunctionDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FishVisitor) accept((FishVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FishEndOfLine> getEndOfLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishEndOfLine.class);
  }

  @Override
  @NotNull
  public List<FishArguments> getArgumentsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishArguments.class);
  }

  @Override
  @NotNull
  public List<FishAssignment> getAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishAssignment.class);
  }

  @Override
  @NotNull
  public List<FishBuiltinFunctions> getBuiltinFunctionsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishBuiltinFunctions.class);
  }

  @Override
  @NotNull
  public List<FishCodeBlock> getCodeBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishCodeBlock.class);
  }

  @Override
  @NotNull
  public List<FishCommand> getCommandList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishCommand.class);
  }

  @Override
  @NotNull
  public List<FishForStatement> getForStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishForStatement.class);
  }

  @Override
  @NotNull
  public List<FishFunctionDefinition> getFunctionDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishFunctionDefinition.class);
  }

  @Override
  @NotNull
  public FishFunctionName getFunctionName() {
    return findNotNullChildByClass(FishFunctionName.class);
  }

  @Override
  @NotNull
  public List<FishIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishIfStatement.class);
  }

  @Override
  @NotNull
  public List<FishSemicolon> getSemicolonList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishSemicolon.class);
  }

  @Override
  @NotNull
  public List<FishStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishStatement.class);
  }

  @Override
  @NotNull
  public List<FishSwitchStatement> getSwitchStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishSwitchStatement.class);
  }

  @Override
  @NotNull
  public List<FishWhileStatement> getWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FishWhileStatement.class);
  }

}
