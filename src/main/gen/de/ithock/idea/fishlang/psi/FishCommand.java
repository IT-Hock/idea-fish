// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FishCommand extends PsiElement {

  @NotNull
  FishEndOfLine getEndOfLine();

  @Nullable
  FishArguments getArguments();

  @NotNull
  FishCommandIdentifier getCommandIdentifier();

}
