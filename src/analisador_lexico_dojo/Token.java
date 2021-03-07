package analisador_lexico_dojo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token {
    
    public String[] vetorPalavrasReservadas = new String[]{
        "function",
        "abstract",
        "break",
        "char",
        "debugger",
        "double",
        "export",
        "finally",
        "goto",
        "in",
        "let",
        "null",
        "public",
        "super",
        "throw",
        "try",
        "volatile",
        "arguments",
        "byte",
        "class",
        "default",
        "else",
        "extends",
        "float",
        "if",
        "instanceof",
        "long",
        "package",
        "return",
        "switch",
        "throws",
        "typeof",
        "while",
        "await",
        "case",
        "const",
        "delete",
        "enum",
        "false",
        "for",
        "implements",
        "int",
        "native",
        "private",
        "short",
        "synchronized",
        "transient",
        "var",
        "with",
        "boolean",
        "catch",
        "continue",
        "do",
        "eval",
        "final",
        "function",
        "import",
        "interface",
        "new",
        "protected",
        "static",
        "this",
        "true",
        "void",
        "yield"};

    public String[] vetorOperadores = new String[]{
        "==",
        "!=",
        "===",
        "!==",
        ">",
        ">=",
        "<",
        "<=",
        "+",
        "-",
        "*",
        "/",
        "+=",
        "-=",
        "*=",
        "/=",
        "%",
        "++",
        "--",
        "**",
        "&",
        "|",
        "^",
        "!",
        "&&",
        "||",
        ":",
        "=",
        "?"
    };
    
    public String[] vetorSeparadores = new String[]{
        "(",
        ")",
        ",",
        "{",
        "}",
        ".",
        "[",
        "]",
        ";",
        ");"
    };
    
    public String[] vetorASI = new String[]{
        "let",
        "const",
        "import",
        "export",
        "debugger",
        "continue",
        "break",
        "throw",
        "return",
        "module",
        "module.exports",
        "yield"
    };
    private String lexema;

    /**
     * @return the lexema
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * @param lexema the lexema to set
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    Pattern pattern;
    Matcher matcher;
    
    public String analise(String token) 
    {
        
        String tipo = "";

        for (int i = 0; i < vetorPalavrasReservadas.length; i++) 
        {
            //pattern = Pattern.compile("function(", Pattern.CASE_INSENSITIVE);
            //matcher = pattern.matcher(busca);
            //boolean matchFound = matcher.find();
            Pattern p = Pattern.compile("[a-zA-Z0-9_]");
            Matcher m = p.matcher(token);
            boolean b = m.matches();
            boolean var = true;
            String reservadas = "";
            String operadores = "";
            String separadores = "";
            String ASI = "";
            
            reservadas = vetorPalavrasReservadas[i];
            
            if(i < vetorOperadores.length){
                operadores = vetorOperadores[i];
            }
            if(i < vetorSeparadores.length){
                separadores = vetorSeparadores[i];
            }
            if(i < vetorASI.length){
                ASI = vetorASI[i];
            }
            
            if (token.equals(reservadas)) 
            {
                tipo =  "Reservado";
                break;
            } 
            else if(token.equals(operadores)){
                tipo =  "Operador";
                break;
            }
            else if(token.equals(separadores)){
                tipo =  "Separador";
                break;
            }
            else if(token.contains("jQuery")){
                tipo = "Reservadas Biblioteca jQuery";
                break;
            }
            else if(token.equals(ASI)){
                tipo = "ASI";
                break;
            }
            else if(b || token.contains("this.")){
                tipo = "Variável";
                break;
            }
            else
            {
                 tipo = "Não identificado";
            
            }
            
        }
            return tipo;
    }

}

