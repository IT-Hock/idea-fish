// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FishCommandIdentifier extends PsiElement {

  @Nullable
  FishEndOfLine getEndOfLine();

  @Nullable
  FishArguments getArguments();

  @Nullable
  FishArrayAccess getArrayAccess();

  @Nullable
  FishAssignment getAssignment();

  @Nullable
  FishBuiltinFunctions getBuiltinFunctions();

  @Nullable
  FishCodeBlock getCodeBlock();

  @Nullable
  FishCommand getCommand();

  @Nullable
  FishEnvIdentifier getEnvIdentifier();

  @Nullable
  FishForStatement getForStatement();

  @Nullable
  FishFunctionDefinition getFunctionDefinition();

  @Nullable
  FishIfStatement getIfStatement();

  @Nullable
  FishSemicolon getSemicolon();

  @Nullable
  FishStatement getStatement();

  @Nullable
  FishSwitchStatement getSwitchStatement();

  @Nullable
  FishWhileStatement getWhileStatement();

  @Nullable
  PsiElement getHpath();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getLineComment();

  @Nullable
  PsiElement getPath();

  @Nullable
  PsiElement getSpath();

  @Nullable
  PsiElement getUri();

}
