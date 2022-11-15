// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FishExpression extends PsiElement {

  @Nullable
  FishEndOfLine getEndOfLine();

  @Nullable
  FishArguments getArguments();

  @Nullable
  FishAssignment getAssignment();

  @Nullable
  FishBuiltinFunctions getBuiltinFunctions();

  @Nullable
  FishCodeBlock getCodeBlock();

  @Nullable
  FishCommand getCommand();

  @Nullable
  FishForStatement getForStatement();

  @Nullable
  FishFunctionDefinition getFunctionDefinition();

  @Nullable
  FishIfStatement getIfStatement();

  @Nullable
  FishStatement getStatement();

  @Nullable
  FishSwitchStatement getSwitchStatement();

  @Nullable
  FishWhileStatement getWhileStatement();

}
