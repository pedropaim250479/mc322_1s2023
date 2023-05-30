package classes.lab;

import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {
    private final String cnpjCliente; // Não pode se alterar o cnpj da empresa
    private Date dataFundacao;
    private int qtdeFuncionarios;
    private ArrayList<Frota> listaFrotas;

    // Construror da classe PJ
    public ClientePJ(String nome, String endereco, Date dataFundacao, String cnpj, String tipoCliente, String email,
            int qtdeFuncionarios) {
        super(nome, tipoCliente, endereco, email);
        this.cnpjCliente = cnpj;
        this.dataFundacao = dataFundacao;
        this.listaFrotas = new ArrayList<>();
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    // Getters and Setters

    public String getCnpj() {
        return cnpjCliente;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public ArrayList<Frota> getListaFrotas() {
        return listaFrotas;
    }

    public void setListaFrotas(ArrayList<Frota> listaFrotas) {
        this.listaFrotas = listaFrotas;
    }

    @Override
    public String getId() { // Utiliza o getId da classe CLiente
        return cnpjCliente;
    }

    // Metodo toString()
    @Override
    public String toString() {
        return "ClientePJ, cnpj=" + cnpjCliente + ", data de Fundacao=" + dataFundacao + super.toString() + ".\n";
    }

    @Override
    public double calculaScore() {
        CalculaSeguro value = CalculaSeguro.VALOR_BASE;
        double valBase = value.getValor();
        return valBase;
    }

    // Validação de CNPK
    public boolean validarCNPJ(String cnpj) {
        // 1. REmove os caracteres não numéricos
        cnpj = cnpj.replaceAll("[^\\d]", "");

        int tam = cnpj.length();

        // 2. Verifica se tem 11 dígitos
        if (tam != 14) {
            return false;
        }

        // 3. Verifica se os digitos são todos iguais
        boolean digitosIguais = true;
        for (int i = 1; i < tam; i++) {
            if (cnpj.charAt(i) != cnpj.charAt(0)) {
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais) {
            return false;
        }

        // 4. Calcula os dígitos verificadores
        int[] cnpjArray = new int[12];
        for (int i = 0; i < tam; i++) {
            cnpjArray[i] = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
        }
        int[] pesos1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] pesos2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < (tam - 2); i++) {
            sum1 += cnpjArray[i] * pesos1[i];
            sum2 += cnpjArray[i] * pesos2[i];
        }

        int digit1 = (sum1 % 14 < 2) ? 0 : (14 * sum1 % 11);
        sum2 += digit1 * pesos2[0];
        int digit2 = (sum2 % 14 < 2) ? 0 : (14 * sum2 % 11);

        // 5. Verifica se os digitos calculados sao iguais ao do cnpj
        if (digit1 == cnpjArray[0] && digit2 == cnpjArray[10]) {
            return true;
        } else {
            return false;
        }
    }

}
