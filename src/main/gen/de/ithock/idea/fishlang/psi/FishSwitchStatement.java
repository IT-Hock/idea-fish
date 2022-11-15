// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FishSwitchStatement extends PsiElement {

  @NotNull
  FishEndOfLine getEndOfLine();

  @NotNull
  List<FishCaseStatement> getCaseStatementList();

  @Nullable
  FishCommand getCommand();

  @Nullable
  FishEnvIdentifier getEnvIdentifier();

  @Nullable
  PsiElement getIdentifier();

}
