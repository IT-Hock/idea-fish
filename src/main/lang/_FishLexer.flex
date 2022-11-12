package de.ithock.idea.fishlang.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.ithock.idea.fishlang.psi.FishElementTypes.*;

%%

%{
  public _FishLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _FishLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

LINE_COMMENT=#.*
BLOCK_COMMENT=#[^#].*#
REAL_NUMBER=[0-9]+\.[0-9]+
INTEGER_NUMBER=[0-9]+
ENV_IDENTIFIER=\$[a-zA-Z_]([a-zA-Z0-9_]|\[[0-9]+])*
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
SINGLE_QUOTED_STRING='[^']*'
DOUBLE_QUOTED_STRING=\"[^\"]*\"
CRLF=\r?\n

%%
<YYINITIAL> {
  {WHITE_SPACE}               { return WHITE_SPACE; }

  "function"                  { return FUNCTION; }
  "end"                       { return END; }
  "echo"                      { return ECHO; }
  "else if"                   { return ELSEIF; }
  "if"                        { return IF; }
  "else"                      { return ELSE; }
  "for"                       { return FOR; }
  "in"                        { return IN; }
  "while"                     { return WHILE; }
  "switch"                    { return SWITCH; }
  "case"                      { return CASE; }
  "break"                     { return BREAK; }
  "continue"                  { return CONTINUE; }
  "return"                    { return RETURN; }
  "true"                      { return TRUE; }
  "false"                     { return FALSE; }
  "&&"                        { return AND; }
  "||"                        { return OR; }
  "!"                         { return NOT; }
  "=="                        { return EQ; }
  "!="                        { return NEQ; }
  ">"                         { return GT; }
  "<"                         { return LT; }
  ">="                        { return GTE; }
  "<="                        { return LTE; }
  "LE"                        { return LE; }
  "GE"                        { return GE; }

  {LINE_COMMENT}              { return LINE_COMMENT; }
  {BLOCK_COMMENT}             { return BLOCK_COMMENT; }
  {REAL_NUMBER}               { return REAL_NUMBER; }
  {INTEGER_NUMBER}            { return INTEGER_NUMBER; }
  {ENV_IDENTIFIER}            { return ENV_IDENTIFIER; }
  {IDENTIFIER}                { return IDENTIFIER; }
  {SINGLE_QUOTED_STRING}      { return SINGLE_QUOTED_STRING; }
  {DOUBLE_QUOTED_STRING}      { return DOUBLE_QUOTED_STRING; }
  {CRLF}                      { return CRLF; }

}

[^] { return BAD_CHARACTER; }
