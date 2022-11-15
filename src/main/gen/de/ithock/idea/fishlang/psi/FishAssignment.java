// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FishAssignment extends PsiElement {

  @NotNull
  List<FishEnvIdentifier> getEnvIdentifierList();

  @Nullable
  FishIntegerType getIntegerType();

  @Nullable
  FishPrimitiveTypes getPrimitiveTypes();

  @Nullable
  FishStringLiteral getStringLiteral();

}
