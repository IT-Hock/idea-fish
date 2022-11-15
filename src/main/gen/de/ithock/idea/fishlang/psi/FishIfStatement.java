// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FishIfStatement extends PsiElement {

  @NotNull
  List<FishEndOfLine> getEndOfLineList();

  @NotNull
  List<FishArguments> getArgumentsList();

  @NotNull
  List<FishAssignment> getAssignmentList();

  @NotNull
  List<FishBuiltinFunctions> getBuiltinFunctionsList();

  @NotNull
  List<FishCodeBlock> getCodeBlockList();

  @NotNull
  List<FishCommand> getCommandList();

  @NotNull
  FishExpression getExpression();

  @NotNull
  List<FishForStatement> getForStatementList();

  @NotNull
  List<FishFunctionDefinition> getFunctionDefinitionList();

  @NotNull
  List<FishIfStatement> getIfStatementList();

  @NotNull
  List<FishSemicolon> getSemicolonList();

  @NotNull
  List<FishStatement> getStatementList();

  @NotNull
  List<FishSwitchStatement> getSwitchStatementList();

  @NotNull
  List<FishWhileStatement> getWhileStatementList();

}
