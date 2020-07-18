lexer grammar Hello;
ID:YY{System.out.println("Correct format");};
fragment YY:[0-9][0-9]MM;
fragment MM:([0][0-9]|[1][0-2])DD;
fragment DD:([0][0-9]|[1][0-2])SSSS;
fragment SSSS:[0-9][0-9][0-9][0-9]C;
fragment C:[0-9]A;
fragment A:[0-9]Z;
fragment Z:[0-9];
WS:[\t\r\n]+ ->skip;

