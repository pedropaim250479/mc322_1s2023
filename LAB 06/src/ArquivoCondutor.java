package classes.lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoCondutor implements LeituraArquivo {
    private final String NOME_ARQUIVO = "lab06-seguradora_arquivos_v2/condutores.csv";
  @Override
public boolean recordArquivo(String conteudo) throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
        bw.write(conteudo);
        bw.newLine();
    } catch (IOException e) {
        System.out.println("Erro ao gravar o arquivo CSV: " + e.getMessage());
        return false;
    }
    return true;
}

@Override
public ArrayList<String> readArquivo() throws IOException {
    ArrayList<String> condutores = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
        String linha;
        boolean primeiraLinha = true;

        while ((linha = br.readLine()) != null) {
            if (primeiraLinha) {  // Ignora o cabeçalho do arquivo CSV
                primeiraLinha = false;
                continue;
            }
            condutores.add(linha);
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
    }
    return condutores;
}
  
}
