package analisador_lexico_dojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analisador_Lexico_DOJO {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String response = "";

        // Leitura
        try {
            FileReader arq = new FileReader("jsdojo.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            response = linha;// lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto


            while (linha != null) {
                
                linha = lerArq.readLine();
                
                
                if(linha != null){
                   
                linha = linha.replaceAll("([ \\t]*//.*)","");
                    response += linha;
                    
                }
                // lê da segunda até a última linha
            }
            
            response = response.replaceAll("\\s", "");
            response = response.replaceAll("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)","");
            
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        
        
        // Análise do código
        
    Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher("Visit W3Schools!");
    boolean matchFound = matcher.find();
    if(matchFound) {
      System.out.println("Match found");
    } else {
      System.out.println("Match not found");
    }
        
        System.out.println(response);

    }

}

