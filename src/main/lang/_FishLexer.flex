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

LINE_COMMENT=#[^\r?\n]*
SINGLE_QUOTED_STRING=[^\']'.*([^\']|\\\\)'
DOUBLE_QUOTED_STRING=[^\\\"]\".*([^\\]|\\\\)\"
PATH=[a-zA-Z0-9._+-]*("/"[a-zA-Z0-9._+-]+)+"/"?
HPATH=\~("/"[a-zA-Z0-9._+-]+)+"/"?
SPATH=<[a-zA-Z0-9._+-]+("/"[a-zA-Z0-9._+-]+)*>
URI=[a-zA-Z][a-zA-Z0-9.+-]*:[a-zA-Z0-9%/?:@&=+$,\-_.!~*']+
BUILTIN_FUNCTION=__fish_([A-Za-z0-9_]+)
HEX_NUMBER=\\[xX][0-9a-fA-F]+
BINARY_NUMBER=\\[01]+
UNICODE_CHAR=\\[uU][0-9a-fA-F]+
CHAR=\\[cC][a-zA-Z]+
ESCAPED_VALUE=\\[\w~!@#$%\^&*()_+{}|:\"<>?`\-=\[\];',./]
INT=[0-9]+
FLOAT=(([1-9][0-9]*\.[0-9]*)|(0?\.[0-9]+))([Ee][+-]?[0-9]+)?
ARG=--?[A-Za-z0-9_\-/\\,.]+
IDENTIFIER=[a-zA-Z\d@/_-]+
NEWLINE=\r?\n
TB=\t
WHITE_SPACE=[ ]+

%%
<YYINITIAL> {
  {WHITE_SPACE}               { return WHITE_SPACE; }

  "*"                         { return WILDCARD; }
  "|"                         { return PIPE; }
  "true"                      { return TRUE; }
  "false"                     { return FALSE; }
  "begin"                     { return BEGIN; }
  "end"                       { return END; }
  "function"                  { return FUNCTION; }
  "if"                        { return IF; }
  "else"                      { return ELSE; }
  "while"                     { return WHILE; }
  "for"                       { return FOR; }
  "switch"                    { return SWITCH; }
  "case"                      { return CASE; }
  "default"                   { return DEFAULT; }
  "break"                     { return BREAK; }
  "continue"                  { return CONTINUE; }
  "return"                    { return RETURN; }
  "and"                       { return AND; }
  "not"                       { return NOT; }
  "or"                        { return OR; }
  "in"                        { return IN; }
  "echo"                      { return ECHO; }
  "set"                       { return SET; }
  "abbr"                      { return ABBR; }
  "source"                    { return SOURCE; }
  "exit"                      { return EXIT; }
  "cd"                        { return CD; }
  "ls"                        { return LS; }
  "man"                       { return MAN; }
  "mv"                        { return MV; }
  "cp"                        { return CP; }
  "open"                      { return OPEN; }
  "less"                      { return LESS; }
  "cat"                       { return CAT; }
  "rm"                        { return RM; }
  ":"                         { return COLON; }
  ";"                         { return SEMI; }
  ","                         { return COMMA; }
  "("                         { return LPAREN; }
  ")"                         { return RPAREN; }
  "{"                         { return LCURLY; }
  "}"                         { return RCURLY; }
  "["                         { return LBRAC; }
  "]"                         { return RBRAC; }
  "$"                         { return ENV_VAR; }
  "WHICH"                     { return WHICH; }
  "TOUCH"                     { return TOUCH; }
  "FIND"                      { return FIND; }

  {LINE_COMMENT}              { return LINE_COMMENT; }
  {SINGLE_QUOTED_STRING}      { return SINGLE_QUOTED_STRING; }
  {DOUBLE_QUOTED_STRING}      { return DOUBLE_QUOTED_STRING; }
  {PATH}                      { return PATH; }
  {HPATH}                     { return HPATH; }
  {SPATH}                     { return SPATH; }
  {URI}                       { return URI; }
  {BUILTIN_FUNCTION}          { return BUILTIN_FUNCTION; }
  {HEX_NUMBER}                { return HEX_NUMBER; }
  {BINARY_NUMBER}             { return BINARY_NUMBER; }
  {UNICODE_CHAR}              { return UNICODE_CHAR; }
  {CHAR}                      { return CHAR; }
  {ESCAPED_VALUE}             { return ESCAPED_VALUE; }
  {INT}                       { return INT; }
  {FLOAT}                     { return FLOAT; }
  {ARG}                       { return ARG; }
  {IDENTIFIER}                { return IDENTIFIER; }
  {NEWLINE}                   { return NEWLINE; }
  {TB}                        { return TB; }
  {WHITE_SPACE}               { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
