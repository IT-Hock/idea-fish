// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FishArgument extends PsiElement {

  @Nullable
  FishArrayAccess getArrayAccess();

  @Nullable
  FishBuiltinFunctions getBuiltinFunctions();

  @Nullable
  FishCommand getCommand();

  @Nullable
  FishCommandEscape getCommandEscape();

  @Nullable
  FishCommandPipe getCommandPipe();

  @Nullable
  FishCommandWildcard getCommandWildcard();

  @Nullable
  FishEnvIdentifier getEnvIdentifier();

  @Nullable
  FishInnerCommand getInnerCommand();

  @Nullable
  FishIntegerType getIntegerType();

  @Nullable
  FishPathStatement getPathStatement();

  @Nullable
  FishPrimitiveTypes getPrimitiveTypes();

  @Nullable
  FishSemicolon getSemicolon();

  @Nullable
  FishStringLiteral getStringLiteral();

  @Nullable
  PsiElement getArg();

  @Nullable
  PsiElement getBinaryNumber();

  @Nullable
  PsiElement getChar();

  @Nullable
  PsiElement getHexNumber();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getUnicodeChar();

}
