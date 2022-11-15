// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.ithock.idea.fishlang.psi.impl.*;

public interface FishElementTypes {

  IElementType ARGUMENT = new FishElementType("ARGUMENT");
  IElementType ARGUMENTS = new FishElementType("ARGUMENTS");
  IElementType ARRAY_ACCESS = new FishElementType("ARRAY_ACCESS");
  IElementType ARRAY_ACCESS_QUANIFIER = new FishElementType("ARRAY_ACCESS_QUANIFIER");
  IElementType ASSIGNMENT = new FishElementType("ASSIGNMENT");
  IElementType BINARY_NUMBER_TYPE = new FishElementType("BINARY_NUMBER_TYPE");
  IElementType BUILTIN_FUNCTIONS = new FishElementType("BUILTIN_FUNCTIONS");
  IElementType CASE_STATEMENT = new FishElementType("CASE_STATEMENT");
  IElementType CHAR_TYPE = new FishElementType("CHAR_TYPE");
  IElementType CODE_BLOCK = new FishElementType("CODE_BLOCK");
  IElementType COMMAND = new FishElementType("COMMAND");
  IElementType COMMAND_ESCAPE = new FishElementType("COMMAND_ESCAPE");
  IElementType COMMAND_IDENTIFIER = new FishElementType("COMMAND_IDENTIFIER");
  IElementType COMMAND_PIPE = new FishElementType("COMMAND_PIPE");
  IElementType COMMAND_WILDCARD = new FishElementType("COMMAND_WILDCARD");
  IElementType END_OF_LINE = new FishElementType("END_OF_LINE");
  IElementType ENV_IDENTIFIER = new FishElementType("ENV_IDENTIFIER");
  IElementType EXIT_FUNCTION = new FishElementType("EXIT_FUNCTION");
  IElementType EXPRESSION = new FishElementType("EXPRESSION");
  IElementType FLOAT_TYPE = new FishElementType("FLOAT_TYPE");
  IElementType FOR_STATEMENT = new FishElementType("FOR_STATEMENT");
  IElementType FUNCTION_DEFINITION = new FishElementType("FUNCTION_DEFINITION");
  IElementType FUNCTION_NAME = new FishElementType("FUNCTION_NAME");
  IElementType HEX_NUMBER_TYPE = new FishElementType("HEX_NUMBER_TYPE");
  IElementType IF_STATEMENT = new FishElementType("IF_STATEMENT");
  IElementType INNER_COMMAND = new FishElementType("INNER_COMMAND");
  IElementType INTEGER_TYPE = new FishElementType("INTEGER_TYPE");
  IElementType PATH_STATEMENT = new FishElementType("PATH_STATEMENT");
  IElementType PRIMITIVE_TYPES = new FishElementType("PRIMITIVE_TYPES");
  IElementType SEMICOLON = new FishElementType("SEMICOLON");
  IElementType STATEMENT = new FishElementType("STATEMENT");
  IElementType STRING_LITERAL = new FishElementType("STRING_LITERAL");
  IElementType SWITCH_STATEMENT = new FishElementType("SWITCH_STATEMENT");
  IElementType UNICODE_CHAR_TYPE = new FishElementType("UNICODE_CHAR_TYPE");
  IElementType WHILE_STATEMENT = new FishElementType("WHILE_STATEMENT");

  IElementType ABBR = new FishTokenType("abbr");
  IElementType AND = new FishTokenType("and");
  IElementType ARG = new FishTokenType("ARG");
  IElementType BEGIN = new FishTokenType("begin");
  IElementType BINARY_NUMBER = new FishTokenType("BINARY_NUMBER");
  IElementType BREAK = new FishTokenType("break");
  IElementType BUILTIN_FUNCTION = new FishTokenType("BUILTIN_FUNCTION");
  IElementType CASE = new FishTokenType("case");
  IElementType CAT = new FishTokenType("cat");
  IElementType CD = new FishTokenType("cd");
  IElementType CHAR = new FishTokenType("CHAR");
  IElementType COLON = new FishTokenType(":");
  IElementType COMMA = new FishTokenType(",");
  IElementType CONTINUE = new FishTokenType("continue");
  IElementType CP = new FishTokenType("cp");
  IElementType DEFAULT = new FishTokenType("default");
  IElementType DOUBLE_QUOTED_STRING = new FishTokenType("DOUBLE_QUOTED_STRING");
  IElementType ECHO = new FishTokenType("echo");
  IElementType ELSE = new FishTokenType("else");
  IElementType END = new FishTokenType("end");
  IElementType ENV_VAR = new FishTokenType("$");
  IElementType ESCAPED_VALUE = new FishTokenType("ESCAPED_VALUE");
  IElementType EXIT = new FishTokenType("exit");
  IElementType FALSE = new FishTokenType("false");
  IElementType FIND = new FishTokenType("FIND");
  IElementType FLOAT = new FishTokenType("FLOAT");
  IElementType FOR = new FishTokenType("for");
  IElementType FUNCTION = new FishTokenType("function");
  IElementType HEX_NUMBER = new FishTokenType("HEX_NUMBER");
  IElementType HPATH = new FishTokenType("HPATH");
  IElementType IDENTIFIER = new FishTokenType("IDENTIFIER");
  IElementType IF = new FishTokenType("if");
  IElementType IN = new FishTokenType("in");
  IElementType INT = new FishTokenType("INT");
  IElementType LBRAC = new FishTokenType("[");
  IElementType LCURLY = new FishTokenType("{");
  IElementType LESS = new FishTokenType("less");
  IElementType LINE_COMMENT = new FishTokenType("LINE_COMMENT");
  IElementType LPAREN = new FishTokenType("(");
  IElementType LS = new FishTokenType("ls");
  IElementType MAN = new FishTokenType("man");
  IElementType MV = new FishTokenType("mv");
  IElementType NEWLINE = new FishTokenType("NEWLINE");
  IElementType NOT = new FishTokenType("not");
  IElementType OPEN = new FishTokenType("open");
  IElementType OR = new FishTokenType("or");
  IElementType PATH = new FishTokenType("PATH");
  IElementType PIPE = new FishTokenType("|");
  IElementType RBRAC = new FishTokenType("]");
  IElementType RCURLY = new FishTokenType("}");
  IElementType RETURN = new FishTokenType("return");
  IElementType RM = new FishTokenType("rm");
  IElementType RPAREN = new FishTokenType(")");
  IElementType SEMI = new FishTokenType(";");
  IElementType SET = new FishTokenType("set");
  IElementType SINGLE_QUOTED_STRING = new FishTokenType("SINGLE_QUOTED_STRING");
  IElementType SOURCE = new FishTokenType("source");
  IElementType SPATH = new FishTokenType("SPATH");
  IElementType SWITCH = new FishTokenType("switch");
  IElementType TB = new FishTokenType("TB");
  IElementType TOUCH = new FishTokenType("TOUCH");
  IElementType TRUE = new FishTokenType("true");
  IElementType UNICODE_CHAR = new FishTokenType("UNICODE_CHAR");
  IElementType URI = new FishTokenType("URI");
  IElementType WHICH = new FishTokenType("WHICH");
  IElementType WHILE = new FishTokenType("while");
  IElementType WILDCARD = new FishTokenType("*");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT) {
        return new FishArgumentImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new FishArgumentsImpl(node);
      }
      else if (type == ARRAY_ACCESS) {
        return new FishArrayAccessImpl(node);
      }
      else if (type == ARRAY_ACCESS_QUANIFIER) {
        return new FishArrayAccessQuanifierImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new FishAssignmentImpl(node);
      }
      else if (type == BINARY_NUMBER_TYPE) {
        return new FishBinaryNumberTypeImpl(node);
      }
      else if (type == BUILTIN_FUNCTIONS) {
        return new FishBuiltinFunctionsImpl(node);
      }
      else if (type == CASE_STATEMENT) {
        return new FishCaseStatementImpl(node);
      }
      else if (type == CHAR_TYPE) {
        return new FishCharTypeImpl(node);
      }
      else if (type == CODE_BLOCK) {
        return new FishCodeBlockImpl(node);
      }
      else if (type == COMMAND) {
        return new FishCommandImpl(node);
      }
      else if (type == COMMAND_ESCAPE) {
        return new FishCommandEscapeImpl(node);
      }
      else if (type == COMMAND_IDENTIFIER) {
        return new FishCommandIdentifierImpl(node);
      }
      else if (type == COMMAND_PIPE) {
        return new FishCommandPipeImpl(node);
      }
      else if (type == COMMAND_WILDCARD) {
        return new FishCommandWildcardImpl(node);
      }
      else if (type == END_OF_LINE) {
        return new FishEndOfLineImpl(node);
      }
      else if (type == ENV_IDENTIFIER) {
        return new FishEnvIdentifierImpl(node);
      }
      else if (type == EXIT_FUNCTION) {
        return new FishExitFunctionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new FishExpressionImpl(node);
      }
      else if (type == FLOAT_TYPE) {
        return new FishFloatTypeImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new FishForStatementImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new FishFunctionDefinitionImpl(node);
      }
      else if (type == FUNCTION_NAME) {
        return new FishFunctionNameImpl(node);
      }
      else if (type == HEX_NUMBER_TYPE) {
        return new FishHexNumberTypeImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new FishIfStatementImpl(node);
      }
      else if (type == INNER_COMMAND) {
        return new FishInnerCommandImpl(node);
      }
      else if (type == INTEGER_TYPE) {
        return new FishIntegerTypeImpl(node);
      }
      else if (type == PATH_STATEMENT) {
        return new FishPathStatementImpl(node);
      }
      else if (type == PRIMITIVE_TYPES) {
        return new FishPrimitiveTypesImpl(node);
      }
      else if (type == SEMICOLON) {
        return new FishSemicolonImpl(node);
      }
      else if (type == STATEMENT) {
        return new FishStatementImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new FishStringLiteralImpl(node);
      }
      else if (type == SWITCH_STATEMENT) {
        return new FishSwitchStatementImpl(node);
      }
      else if (type == UNICODE_CHAR_TYPE) {
        return new FishUnicodeCharTypeImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new FishWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
