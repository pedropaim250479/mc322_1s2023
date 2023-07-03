package classes.lab;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoVeiculo implements LeituraArquivo{
    @Override
    public boolean recordArquivo(String conteudo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
            // Verifica se o arquivo está vazio
            if (bw.getChannel().size() == 0) {
                // Escreve o cabeçalho no arquivo CSV
                bw.write("Placa,Marca,Modelo,Ano,Valor");
                bw.newLine();
            }
            // Escreve os dados no arquivo CSV
            bw.write(conteudo);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo CSV: " + e.getMessage());
            return false;
        }
    }

@Override
    public ArrayList<String> readArquivo() throws IOException {
        ArrayList<String> veiculos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {  // Ignora o cabeçalho do arquivo CSV
                    primeiraLinha = false;
                    continue;
                }
                veiculos.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
        return veiculos;
    }

}
