package classes.lab;

import java.util.Date;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private final String cpfCliente;
    private Date dataNascimento;
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private ArrayList<Veiculo> listaVeiculos;

    // Construtor da classe e superClasse
    public ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero,
            String classeEconomica,
            String cpf, Date dataNascimento, String tipoCliente, String email) {
        super(nome, tipoCliente, endereco, email);
        this.cpfCliente = cpf;
        this.dataLicenca = dataLicenca;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.educacao = educacao;
        this.listaVeiculos = new ArrayList<>();
    }

    // GEtters and Setters

    public String getCpf() {
        return cpfCliente;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    @Override
    public String getId() { // Utiliza o getId da classe CLiente
        return cpfCliente;
    }

    public boolean removerVeiculo(Veiculo veiculo) {
        for (Veiculo veiculoC : listaVeiculos) {
            if (veiculoC.equals(veiculo)) {
                listaVeiculos.remove(veiculoC);
                System.out.println("Veiculo removido");
                return true;
            }
        }
        System.out.println("Veiculo não encontrado");
        return false;
    }

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        for (Veiculo veiculoCadastrar : listaVeiculos) {
            if (veiculoCadastrar.equals(veiculo)) {
                System.out.println("O veiculo" + veiculo + "já está cadastrado");
                return false;
            }
        }
        listaVeiculos.add(veiculo);
        System.out.println("Veículo cadastrado");
        return true;
    }

    // Método toString()
    @Override
    public String toString() {
        return "[" + " cpf='" + getCpf() + "'" +
                ", genero='" + getGenero() + "'" +
                ", educacao='" + getEducacao() + "'" +
                ", dataNascimento='" + getDataNascimento() + "'" +
                ", listaVeiculos='" + getListaVeiculos() + "'" +
                "]";
    }

    @Override
    public double calculaScore() {
        CalculaSeguro value = CalculaSeguro.VALOR_BASE;
        double valBase = value.getValor();
        return valBase;
    }

    // Verificador de validade de CPF
    public boolean validarCPF(String cpf) {
        // 1. REmove os caracteres não numéricos
        cpf = cpf.replaceAll("[^\\d]", "");

        int tam = cpf.length();

        // 2. Verifica se tem 11 dígitos
        if (tam != 11) {
            return false;
        }

        // 3. Verifica se os digitos são todos iguais
        boolean digitosIguais = true;
        for (int i = 1; i < tam; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais) {
            return false;
        }

        // 4. Calcula os dígitos verificadores
        int[] cpfArray = new int[11];
        for (int i = 0; i < tam; i++) {
            cpfArray[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }
        int[] pesos1 = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] pesos2 = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 9; i++) {
            sum1 += cpfArray[i] * pesos1[i];
            sum2 += cpfArray[i] * pesos2[i];
        }

        int digit1 = (sum1 % 11 < 2) ? 0 : (11 * sum1 % 11);
        sum2 += digit1 * pesos2[0];
        int digit2 = (sum2 % 11 < 2) ? 0 : (11 * sum2 % 11);

        // 5. Verifica se os digitos calculados sao iguais ao do cpf
        if (digit1 == cpfArray[0] && digit2 == cpfArray[10]) {
            return true;
        } else {
            return false;
        }
    }
}
