package classes.lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoFrota implements LeituraArquivo{
   private final String NOME_ARQUIVO = "lab06-seguradora_arquivos_v2/frotas.csv"; 

   @Override
public boolean recordArquivo(String conteudo) throws IOException {
    // Implementação da função gravarArquivo
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
        bw.write(conteudo);
        bw.newLine();
    } catch (IOException e) {
        System.out.println("Erro ao gravar o arquivo CSV: " + e.getMessage());
        return false;
    }
    return true;
    // Retorna true se o arquivo foi gravado com sucesso, caso contrário, retorna false
}

@Override
public ArrayList<String> readArquivo() throws IOException {
    ArrayList<String> frotas = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
        String linha;
        boolean primeiraLinha = true;

        while ((linha = br.readLine()) != null) {
            if (primeiraLinha) {  // Ignora o cabeçalho do arquivo CSV
                primeiraLinha = false;
                continue;
            }
            frotas.add(linha);
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
    }
    return frotas;
}

public int contarFrotas() {
    int contador = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
        // Ignora o cabeçalho do arquivo CSV
        br.readLine();

        while (br.readLine() != null) {
            contador++;
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
    }
    return contador;
}

}
