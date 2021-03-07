package analisador_lexico_dojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Analisador_Lexico_DOJO {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String response = "";
        Token token = new Token();

        String[] vetorPalavrasReservadas = new String[]{
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
            "yield",};

        
        // Leitura
        try {
            FileReader arq = new FileReader("jsdojo.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            response = linha;

            while (linha != null) {

                linha = lerArq.readLine();

                if (linha != null) {

                    linha = linha.replaceAll("([ \\t]*//.*)", "");
                    response += linha;

                }
            }

            //response = response.replaceAll("\\s", "");
            response = response.replaceAll("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)", "");
            int index = 0;
            String teste = "";
            StringTokenizer st = new StringTokenizer(response);
            String tipo = "";
            while (st.hasMoreTokens()) {
                teste = st.nextToken();
                tipo = token.analise(teste);
                index += teste.length();
                System.out.println(Integer.toString(index) + " | " +  teste + " | " + tipo);
           }
            
            arq.close();
            
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        
        

        /*
        Pattern pattern;
        Matcher matcher;

        for(int i=0;i<vetorPalavrasReservadas.length; i++) 
        {
            pattern = Pattern.compile(vetorPalavrasReservadas[i], Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(response);
            
            boolean matchFound = matcher.find();
            if (matchFound) 
            {
                System.out.println("Match found");
            } 
            else 
            {
                System.out.println("Match not found");
            }

            System.out.println(response);

        }*/

    }

   

}


