// This is a generated file. Not intended for manual editing.
package de.ithock.idea.fishlang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static de.ithock.idea.fishlang.psi.FishElementTypes.*;
import static de.ithock.idea.fishlang.psi.impl.FishParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FishParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return fishFile(b, l + 1);
  }

  /* ********************************************************** */
  // NEWLINE|<<eof>>
  public static boolean END_OF_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "END_OF_LINE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, END_OF_LINE, "<end of line>");
    r = consumeToken(b, NEWLINE);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<integer_type>> | <<primitive_types>> |
  //                 <<inner_command>> |
  //                 <<env_identifier>> |
  //                 <<path_statement>> |
  //                 <<array_access>>
  //                 | (IDENTIFIER ARG)
  //                 | FALSE | TRUE | NOT | AND | PIPE | WILDCARD
  //                 | HEX_NUMBER | BINARY_NUMBER | UNICODE_CHAR | CHAR
  //                 | ARG | "/" | "=" | "&&" | "(" | ")" | "[" | "]" | ">" | "<" | <<semicolon>>
  //                 | (AND (<<command>>|<<builtin_functions>>)) |
  //                 <<command_escape>> | <<command_pipe>> | <<command_wildcard>> | <<string_literal>>
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = integer_type(b, l + 1);
    if (!r) r = primitive_types(b, l + 1);
    if (!r) r = inner_command(b, l + 1);
    if (!r) r = env_identifier(b, l + 1);
    if (!r) r = path_statement(b, l + 1);
    if (!r) r = array_access(b, l + 1);
    if (!r) r = argument_6(b, l + 1);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, WILDCARD);
    if (!r) r = consumeToken(b, HEX_NUMBER);
    if (!r) r = consumeToken(b, BINARY_NUMBER);
    if (!r) r = consumeToken(b, UNICODE_CHAR);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, ARG);
    if (!r) r = consumeToken(b, "/");
    if (!r) r = consumeToken(b, "=");
    if (!r) r = consumeToken(b, "&&");
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, LBRAC);
    if (!r) r = consumeToken(b, RBRAC);
    if (!r) r = consumeToken(b, ">");
    if (!r) r = consumeToken(b, "<");
    if (!r) r = semicolon(b, l + 1);
    if (!r) r = argument_28(b, l + 1);
    if (!r) r = command_escape(b, l + 1);
    if (!r) r = command_pipe(b, l + 1);
    if (!r) r = command_wildcard(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER ARG
  private static boolean argument_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ARG);
    exit_section_(b, m, null, r);
    return r;
  }

  // AND (<<command>>|<<builtin_functions>>)
  private static boolean argument_28(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_28")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && argument_28_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<command>>|<<builtin_functions>>
  private static boolean argument_28_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_28_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = command(b, l + 1);
    if (!r) r = builtin_functions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<argument>> <<arguments>> | <<argument>>
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENTS, "<arguments>");
    r = arguments_0(b, l + 1);
    if (!r) r = argument(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // <<argument>> <<arguments>>
  private static boolean arguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument(b, l + 1);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (<<env_identifier>> <<array_access_quanifier>>) | (IDENTIFIER <<array_access_quanifier>>)
  public static boolean array_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access")) return false;
    if (!nextTokenIs(b, "<array access>", ENV_VAR, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_ACCESS, "<array access>");
    r = array_access_0(b, l + 1);
    if (!r) r = array_access_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // <<env_identifier>> <<array_access_quanifier>>
  private static boolean array_access_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = env_identifier(b, l + 1);
    r = r && array_access_quanifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER <<array_access_quanifier>>
  private static boolean array_access_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && array_access_quanifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '['((<<integer_type>>'..'<<integer_type>>|<<integer_type>>+)|<<string_literal>>)+']'
  public static boolean array_access_quanifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_quanifier")) return false;
    if (!nextTokenIs(b, LBRAC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRAC);
    r = r && array_access_quanifier_1(b, l + 1);
    r = r && consumeToken(b, RBRAC);
    exit_section_(b, m, ARRAY_ACCESS_QUANIFIER, r);
    return r;
  }

  // ((<<integer_type>>'..'<<integer_type>>|<<integer_type>>+)|<<string_literal>>)+
  private static boolean array_access_quanifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_quanifier_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_access_quanifier_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!array_access_quanifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_access_quanifier_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<integer_type>>'..'<<integer_type>>|<<integer_type>>+)|<<string_literal>>
  private static boolean array_access_quanifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_quanifier_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_access_quanifier_1_0_0(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<integer_type>>'..'<<integer_type>>|<<integer_type>>+
  private static boolean array_access_quanifier_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_quanifier_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_access_quanifier_1_0_0_0(b, l + 1);
    if (!r) r = array_access_quanifier_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<integer_type>>'..'<<integer_type>>
  private static boolean array_access_quanifier_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_quanifier_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integer_type(b, l + 1);
    r = r && consumeToken(b, "..");
    r = r && integer_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<integer_type>>+
  private static boolean array_access_quanifier_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_access_quanifier_1_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integer_type(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!integer_type(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_access_quanifier_1_0_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (<<env_identifier>>|IDENTIFIER) "=" (<<string_literal>>|<<integer_type>>|<<primitive_types>>|
  //            TRUE|FALSE|IDENTIFIER|<<env_identifier>>)
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, "<assignment>", ENV_VAR, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = assignment_0(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && assignment_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // <<env_identifier>>|IDENTIFIER
  private static boolean assignment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = env_identifier(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<string_literal>>|<<integer_type>>|<<primitive_types>>|
  //            TRUE|FALSE|IDENTIFIER|<<env_identifier>>
  private static boolean assignment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_literal(b, l + 1);
    if (!r) r = integer_type(b, l + 1);
    if (!r) r = primitive_types(b, l + 1);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = env_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BINARY_NUMBER
  public static boolean binary_number_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_number_type")) return false;
    if (!nextTokenIs(b, BINARY_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BINARY_NUMBER);
    exit_section_(b, m, BINARY_NUMBER_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // BUILTIN_FUNCTION|<<function_echo>>|<<exit_function>>|
  //                         <<function_source>>|<<function_abbr>>|<<function_set>>|
  //                         <<function_man>> | <<function_rm>> | <<function_mv>> |
  //                         <<function_cp>> | <<function_less>> | <<function_cat>> |
  //                         <<function_find>> | <<function_cd>> | <<function_which>> | <<function_touch>>
  public static boolean builtin_functions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_functions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_FUNCTIONS, "<builtin functions>");
    r = consumeToken(b, BUILTIN_FUNCTION);
    if (!r) r = function_echo(b, l + 1);
    if (!r) r = exit_function(b, l + 1);
    if (!r) r = function_source(b, l + 1);
    if (!r) r = function_abbr(b, l + 1);
    if (!r) r = function_set(b, l + 1);
    if (!r) r = function_man(b, l + 1);
    if (!r) r = function_rm(b, l + 1);
    if (!r) r = function_mv(b, l + 1);
    if (!r) r = function_cp(b, l + 1);
    if (!r) r = function_less(b, l + 1);
    if (!r) r = function_cat(b, l + 1);
    if (!r) r = function_find(b, l + 1);
    if (!r) r = function_cd(b, l + 1);
    if (!r) r = function_which(b, l + 1);
    if (!r) r = function_touch(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CASE (<<string_literal>>|<<command>>) <<statements>>* |
  //                      DEFAULT <<statements>>*
  public static boolean case_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_statement")) return false;
    if (!nextTokenIs(b, "<case statement>", CASE, DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_STATEMENT, "<case statement>");
    r = case_statement_0(b, l + 1);
    if (!r) r = case_statement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CASE (<<string_literal>>|<<command>>) <<statements>>*
  private static boolean case_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && case_statement_0_1(b, l + 1);
    r = r && case_statement_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<string_literal>>|<<command>>
  private static boolean case_statement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_statement_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_literal(b, l + 1);
    if (!r) r = command(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<statements>>*
  private static boolean case_statement_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_statement_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_statement_0_2", c)) break;
    }
    return true;
  }

  // DEFAULT <<statements>>*
  private static boolean case_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFAULT);
    r = r && case_statement_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<statements>>*
  private static boolean case_statement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_statement_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_statement_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // CHAR
  public static boolean char_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "char_type")) return false;
    if (!nextTokenIs(b, CHAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHAR);
    exit_section_(b, m, CHAR_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // BEGIN <<statements>>* END
  public static boolean code_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_block")) return false;
    if (!nextTokenIs(b, BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEGIN);
    r = r && code_block_1(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, CODE_BLOCK, r);
    return r;
  }

  // <<statements>>*
  private static boolean code_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "code_block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<command_identifier>> <<arguments>>? <<END_OF_LINE>>
  public static boolean command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND, "<command>");
    r = command_identifier(b, l + 1);
    r = r && command_1(b, l + 1);
    r = r && END_OF_LINE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // <<arguments>>?
  private static boolean command_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_1")) return false;
    arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ESCAPED_VALUE
  public static boolean command_escape(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_escape")) return false;
    if (!nextTokenIs(b, ESCAPED_VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ESCAPED_VALUE);
    exit_section_(b, m, COMMAND_ESCAPE, r);
    return r;
  }

  /* ********************************************************** */
  // "[" <<statements>> "]"|IDENTIFIER|<<env_identifier>>|<<array_access>>|<<builtin_functions>>
  public static boolean command_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_IDENTIFIER, "<command identifier>");
    r = command_identifier_0(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = env_identifier(b, l + 1);
    if (!r) r = array_access(b, l + 1);
    if (!r) r = builtin_functions(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "[" <<statements>> "]"
  private static boolean command_identifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_identifier_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRAC);
    r = r && statements(b, l + 1);
    r = r && consumeToken(b, RBRAC);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PIPE
  public static boolean command_pipe(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_pipe")) return false;
    if (!nextTokenIs(b, PIPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    exit_section_(b, m, COMMAND_PIPE, r);
    return r;
  }

  /* ********************************************************** */
  // WILDCARD
  public static boolean command_wildcard(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_wildcard")) return false;
    if (!nextTokenIs(b, WILDCARD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WILDCARD);
    exit_section_(b, m, COMMAND_WILDCARD, r);
    return r;
  }

  /* ********************************************************** */
  // ENV_VAR (IDENTIFIER|BUILTIN_FUNCTION) <<array_access_quanifier>>?
  public static boolean env_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_identifier")) return false;
    if (!nextTokenIs(b, ENV_VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENV_VAR);
    r = r && env_identifier_1(b, l + 1);
    r = r && env_identifier_2(b, l + 1);
    exit_section_(b, m, ENV_IDENTIFIER, r);
    return r;
  }

  // IDENTIFIER|BUILTIN_FUNCTION
  private static boolean env_identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_identifier_1")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, BUILTIN_FUNCTION);
    return r;
  }

  // <<array_access_quanifier>>?
  private static boolean env_identifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_identifier_2")) return false;
    array_access_quanifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EXIT <<integer_type>>?
  public static boolean exit_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exit_function")) return false;
    if (!nextTokenIs(b, EXIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXIT);
    r = r && exit_function_1(b, l + 1);
    exit_section_(b, m, EXIT_FUNCTION, r);
    return r;
  }

  // <<integer_type>>?
  private static boolean exit_function_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exit_function_1")) return false;
    integer_type(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // NOT? <<command>>|("[" <<command>> "]")|<<builtin_functions>>|
  //             <<assignment>>|<<code_block>>|<<statement>>|
  //             <<function_echo>>|<<command>>|<<function_definition>>|
  //             <<if_statement>>|<<while_statement>>|<<for_statement>>|
  //             <<switch_statement>> <<END_OF_LINE>>
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_0(b, l + 1);
    if (!r) r = expression_1(b, l + 1);
    if (!r) r = builtin_functions(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    if (!r) r = code_block(b, l + 1);
    if (!r) r = statement(b, l + 1);
    if (!r) r = function_echo(b, l + 1);
    if (!r) r = command(b, l + 1);
    if (!r) r = function_definition(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = expression_12(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NOT? <<command>>
  private static boolean expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression_0_0(b, l + 1);
    r = r && command(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT?
  private static boolean expression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0_0")) return false;
    consumeToken(b, NOT);
    return true;
  }

  // "[" <<command>> "]"
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRAC);
    r = r && command(b, l + 1);
    r = r && consumeToken(b, RBRAC);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<switch_statement>> <<END_OF_LINE>>
  private static boolean expression_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = switch_statement(b, l + 1);
    r = r && END_OF_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<statements>>* <<eof>>
  static boolean fishFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fishFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fishFile_0(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<statements>>*
  private static boolean fishFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fishFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fishFile_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // FLOAT
  public static boolean float_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float_type")) return false;
    if (!nextTokenIs(b, FLOAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FLOAT);
    exit_section_(b, m, FLOAT_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // FOR (IDENTIFIER|<<env_identifier>>|<<command>>) IN (IDENTIFIER|<<env_identifier>>|<<command>>)
  //                     <<statements>>* END
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && for_statement_1(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && for_statement_3(b, l + 1);
    r = r && for_statement_4(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  // IDENTIFIER|<<env_identifier>>|<<command>>
  private static boolean for_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = env_identifier(b, l + 1);
    if (!r) r = command(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER|<<env_identifier>>|<<command>>
  private static boolean for_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = env_identifier(b, l + 1);
    if (!r) r = command(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<statements>>*
  private static boolean for_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "for_statement_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ABBR <<arguments>>
  static boolean function_abbr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_abbr")) return false;
    if (!nextTokenIs(b, ABBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ABBR);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CAT <<arguments>>
  static boolean function_cat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_cat")) return false;
    if (!nextTokenIs(b, CAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CAT);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CD <<arguments>>
  static boolean function_cd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_cd")) return false;
    if (!nextTokenIs(b, CD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CD);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CP <<arguments>>
  static boolean function_cp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_cp")) return false;
    if (!nextTokenIs(b, CP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CP);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION <<function_name>> <<statements>>* END <<END_OF_LINE>>
  public static boolean function_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION);
    r = r && function_name(b, l + 1);
    r = r && function_definition_2(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && END_OF_LINE(b, l + 1);
    exit_section_(b, m, FUNCTION_DEFINITION, r);
    return r;
  }

  // <<statements>>*
  private static boolean function_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_definition_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ECHO <<arguments>>
  static boolean function_echo(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_echo")) return false;
    if (!nextTokenIs(b, ECHO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ECHO);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FIND <<arguments>>
  static boolean function_find(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_find")) return false;
    if (!nextTokenIs(b, FIND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FIND);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LESS <<arguments>>
  static boolean function_less(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_less")) return false;
    if (!nextTokenIs(b, LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MAN <<arguments>>
  static boolean function_man(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_man")) return false;
    if (!nextTokenIs(b, MAN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MAN);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MV <<arguments>>
  static boolean function_mv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_mv")) return false;
    if (!nextTokenIs(b, MV)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MV);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<command>>|IDENTIFIER
  public static boolean function_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_NAME, "<function name>");
    r = command(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RM <<arguments>>
  static boolean function_rm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_rm")) return false;
    if (!nextTokenIs(b, RM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RM);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SET <<arguments>>
  static boolean function_set(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_set")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SOURCE <<path_statement>>|<<arguments>>
  static boolean function_source(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_source")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_source_0(b, l + 1);
    if (!r) r = arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SOURCE <<path_statement>>
  private static boolean function_source_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_source_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SOURCE);
    r = r && path_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TOUCH <<arguments>>
  static boolean function_touch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_touch")) return false;
    if (!nextTokenIs(b, TOUCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TOUCH);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WHICH <<arguments>>
  static boolean function_which(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_which")) return false;
    if (!nextTokenIs(b, WHICH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHICH);
    r = r && arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HEX_NUMBER
  public static boolean hex_number_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hex_number_type")) return false;
    if (!nextTokenIs(b, HEX_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEX_NUMBER);
    exit_section_(b, m, HEX_NUMBER_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // IF <<expression>> <<statements>> (<<END_OF_LINE>>)? (ELSE IF <<statements>>+)* (ELSE <<statements>>+)? END <<END_OF_LINE>>
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && statements(b, l + 1);
    r = r && if_statement_3(b, l + 1);
    r = r && if_statement_4(b, l + 1);
    r = r && if_statement_5(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && END_OF_LINE(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // (<<END_OF_LINE>>)?
  private static boolean if_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3")) return false;
    if_statement_3_0(b, l + 1);
    return true;
  }

  // <<END_OF_LINE>>
  private static boolean if_statement_3_0(PsiBuilder b, int l) {
    return END_OF_LINE(b, l + 1);
  }

  // (ELSE IF <<statements>>+)*
  private static boolean if_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_statement_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_4", c)) break;
    }
    return true;
  }

  // ELSE IF <<statements>>+
  private static boolean if_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, IF);
    r = r && if_statement_4_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<statements>>+
  private static boolean if_statement_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statements(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_4_0_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE <<statements>>+)?
  private static boolean if_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_5")) return false;
    if_statement_5_0(b, l + 1);
    return true;
  }

  // ELSE <<statements>>+
  private static boolean if_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && if_statement_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<statements>>+
  private static boolean if_statement_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statements(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_5_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' IDENTIFIER <<arguments>> ')'
  public static boolean inner_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_command")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LPAREN, IDENTIFIER);
    r = r && arguments(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, INNER_COMMAND, r);
    return r;
  }

  /* ********************************************************** */
  // INT | INT <<integer_type>>
  public static boolean integer_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_type")) return false;
    if (!nextTokenIs(b, INT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INT);
    if (!r) r = integer_type_1(b, l + 1);
    exit_section_(b, m, INTEGER_TYPE, r);
    return r;
  }

  // INT <<integer_type>>
  private static boolean integer_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_type_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INT);
    r = r && integer_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HPATH|PATH|SPATH|URI
  public static boolean path_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_STATEMENT, "<path statement>");
    r = consumeToken(b, HPATH);
    if (!r) r = consumeToken(b, PATH);
    if (!r) r = consumeToken(b, SPATH);
    if (!r) r = consumeToken(b, URI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<integer_type>>|<<float_type>>|<<hex_number_type>>|<<binary_number_type>>|<<unicode_char_type>>|<<char_type>>
  public static boolean primitive_types(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_types")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMITIVE_TYPES, "<primitive types>");
    r = integer_type(b, l + 1);
    if (!r) r = float_type(b, l + 1);
    if (!r) r = hex_number_type(b, l + 1);
    if (!r) r = binary_number_type(b, l + 1);
    if (!r) r = unicode_char_type(b, l + 1);
    if (!r) r = char_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SEMI
  public static boolean semicolon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semicolon")) return false;
    if (!nextTokenIs(b, SEMI)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    exit_section_(b, m, SEMICOLON, r);
    return r;
  }

  /* ********************************************************** */
  // <<if_statement>>
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement(b, l + 1);
    exit_section_(b, m, STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (
  //         LINE_COMMENT |
  //         <<switch_statement>>|<<if_statement>>|<<while_statement>>|<<for_statement>>|
  //         <<function_definition>>|
  //         <<builtin_functions>>|<<assignment>>|
  //         <<code_block>>|<<statement>>|<<function_echo>>|<<command>>|
  //         PATH|SPATH|HPATH|URI|
  //         CONTINUE|BREAK|RETURN|TRUE|FALSE|AND|<<semicolon>>|<<END_OF_LINE>>)
  static boolean statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statements_0(b, l + 1);
    r = r && statements_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean statements_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LINE_COMMENT |
  //         <<switch_statement>>|<<if_statement>>|<<while_statement>>|<<for_statement>>|
  //         <<function_definition>>|
  //         <<builtin_functions>>|<<assignment>>|
  //         <<code_block>>|<<statement>>|<<function_echo>>|<<command>>|
  //         PATH|SPATH|HPATH|URI|
  //         CONTINUE|BREAK|RETURN|TRUE|FALSE|AND|<<semicolon>>|<<END_OF_LINE>>
  private static boolean statements_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_COMMENT);
    if (!r) r = switch_statement(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = function_definition(b, l + 1);
    if (!r) r = builtin_functions(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    if (!r) r = code_block(b, l + 1);
    if (!r) r = statement(b, l + 1);
    if (!r) r = function_echo(b, l + 1);
    if (!r) r = command(b, l + 1);
    if (!r) r = consumeToken(b, PATH);
    if (!r) r = consumeToken(b, SPATH);
    if (!r) r = consumeToken(b, HPATH);
    if (!r) r = consumeToken(b, URI);
    if (!r) r = consumeToken(b, CONTINUE);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = semicolon(b, l + 1);
    if (!r) r = END_OF_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SINGLE_QUOTED_STRING | DOUBLE_QUOTED_STRING | IDENTIFIER | <<env_identifier>>
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = consumeToken(b, SINGLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = env_identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SWITCH (<<env_identifier>>|<<command>>|IDENTIFIER) <<END_OF_LINE>> <<case_statement>>* END
  public static boolean switch_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_statement")) return false;
    if (!nextTokenIs(b, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH);
    r = r && switch_statement_1(b, l + 1);
    r = r && END_OF_LINE(b, l + 1);
    r = r && switch_statement_3(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, SWITCH_STATEMENT, r);
    return r;
  }

  // <<env_identifier>>|<<command>>|IDENTIFIER
  private static boolean switch_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = env_identifier(b, l + 1);
    if (!r) r = command(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<case_statement>>*
  private static boolean switch_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_statement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!case_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "switch_statement_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // UNICODE_CHAR
  public static boolean unicode_char_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unicode_char_type")) return false;
    if (!nextTokenIs(b, UNICODE_CHAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNICODE_CHAR);
    exit_section_(b, m, UNICODE_CHAR_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE (NOT)? (TRUE|FALSE|<<command>>) <<END_OF_LINE>> <<statements>>* END
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && while_statement_1(b, l + 1);
    r = r && while_statement_2(b, l + 1);
    r = r && END_OF_LINE(b, l + 1);
    r = r && while_statement_4(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  // (NOT)?
  private static boolean while_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement_1")) return false;
    consumeToken(b, NOT);
    return true;
  }

  // TRUE|FALSE|<<command>>
  private static boolean while_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = command(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<statements>>*
  private static boolean while_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "while_statement_4", c)) break;
    }
    return true;
  }

}
