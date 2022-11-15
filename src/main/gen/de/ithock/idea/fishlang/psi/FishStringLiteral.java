// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FishStringLiteral extends PsiElement {

  @Nullable
  FishEnvIdentifier getEnvIdentifier();

  @Nullable
  PsiElement getDoubleQuotedString();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getSingleQuotedString();

}
