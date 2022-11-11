package de.ithock.idea.fishlang.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.ithock.idea.fishlang.psi.FishTypes.*;

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

SCOMMENT=#[^\r\n]*
LINE_BREAK=\\n|\\r\\n|\\r|\\n\\r
ANY=[^]
ID=\$?[a-zA-Z_][a-zA-Z0-9_'-]*
INT=[0-9]+
FLOAT=(([1-9][0-9]*\.[0-9]*)|(0?\.[0-9]+))([Ee][+-]?[0-9]+)?
PATH=[a-zA-Z0-9._+-]*("/"[a-zA-Z0-9._+-]+)+"/"?
HPATH=~("/"[a-zA-Z0-9._+-]+)+"/"?
SPATH=<[a-zA-Z0-9._+-]+("/"[a-zA-Z0-9._+-]+)*>
URI=[a-zA-Z][a-zA-Z0-9.+-]*:[a-zA-Z0-9%/?:@&=+$,\-_.!~*']+
WHITE_SPACE=[ \t\r\n]+
MCOMMENT="/"\*([^*]|\*[^/])*\*"/"

%%
<YYINITIAL> {
  {WHITE_SPACE}         { return WHITE_SPACE; }

  "if"                  { return IF; }
  "else"                { return ELSE; }
  "end"                 { return END; }
  "for"                 { return FOR; }
  "function"            { return FUNCTION; }
  "in"                  { return IN; }
  "or"                  { return OR_KW; }
  "..."                 { return ELLIPSIS; }
  "return"              { return RETURN; }
  "="                   { return ASSIGN; }
  ":"                   { return COLON; }
  ";"                   { return SEMI; }
  ","                   { return COMMA; }
  "@"                   { return AT; }
  "("                   { return LPAREN; }
  ")"                   { return RPAREN; }
  "{"                   { return LCURLY; }
  "}"                   { return RCURLY; }
  "["                   { return LBRAC; }
  "]"                   { return RBRAC; }
  "$"                   { return DOLLAR; }
  "."                   { return DOT; }
  "?"                   { return HAS; }
  "not"                 { return NOT; }
  "*"                   { return TIMES; }
  "/"                   { return DIVIDE; }
  "+"                   { return PLUS; }
  "-"                   { return MINUS; }
  "<"                   { return LT; }
  ">"                   { return GT; }
  "++"                  { return CONCAT; }
  "//"                  { return UPDATE; }
  "<="                  { return LEQ; }
  ">="                  { return GEQ; }
  "=="                  { return EQ; }
  "!="                  { return NEQ; }
  "&&"                  { return AND; }
  "||"                  { return OR; }
  "true"                { return TRUE; }
  "false"               { return FALSE; }
  "ELSEIF"              { return ELSEIF; }
  "IMPL"                { return IMPL; }
  "REC"                 { return REC; }
  "LET"                 { return LET; }
  "STRING_OPEN"         { return STRING_OPEN; }
  "STRING_CLOSE"        { return STRING_CLOSE; }
  "IND_STRING_OPEN"     { return IND_STRING_OPEN; }
  "IND_STRING_CLOSE"    { return IND_STRING_CLOSE; }
  "STR"                 { return STR; }
  "IND_STR"             { return IND_STR; }
  "INHERIT"             { return INHERIT; }

  {SCOMMENT}            { return SCOMMENT; }
  {LINE_BREAK}          { return LINE_BREAK; }
  {ANY}                 { return ANY; }
  {ID}                  { return ID; }
  {INT}                 { return INT; }
  {FLOAT}               { return FLOAT; }
  {PATH}                { return PATH; }
  {HPATH}               { return HPATH; }
  {SPATH}               { return SPATH; }
  {URI}                 { return URI; }
  {WHITE_SPACE}         { return WHITE_SPACE; }
  {MCOMMENT}            { return MCOMMENT; }

}

[^] { return BAD_CHARACTER; }
