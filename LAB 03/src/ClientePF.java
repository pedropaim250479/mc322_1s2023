package classes.lab;
import java.sql.Date;
import java.util.List;

public class ClientePF extends Cliente {
    private String cpf;
    private Date dataNascimento;

    //Construtor da classe e superClasse
    public ClientePF (String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, 
    List<Veiculo> listaVeiculos, String cpf, Date dataNascimento){
        super(nome, dataLicenca, educacao, genero, classeEconomica, endereco, listaVeiculos);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;

    }

    //GEtters and Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    //Método toString()
    @Override
    public String toString() {
        return "ClientePF, cpf=" + cpf + ", data de Nascimento=" + dataNascimento + "]";
    }

    //Verificador de validade de CPF
    public boolean validarCPF(String cpf){
    //1. REmove os caracteres não numéricos
    cpf = cpf.replaceAll("[^\\d]", "");

    int tam = cpf.length();

    //2. Verifica se tem 11 dígitos
    if(tam != 11){
        return false;
    }

    //3. Verifica se os digitos são todos iguais
    boolean digitosIguais = true;
    for(int i = 1; i<tam; i++){
        if(cpf.charAt(i) != cpf.charAt(0)){
            digitosIguais = false;
            break;
        }
    }
    if (digitosIguais){
        return false;
    }

    //4. Calcula os dígitos verificadores
    int[] cpfArray = new int[11];
    for(int i = 0; i<tam;i++){
        cpfArray[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
    }
    int[] pesos1 = {10,9,8,7,6,5,4,3,2};
    int[] pesos2 = {11,10,9,8,7,6,5,4,3,2};
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i<9; i++){
        sum1 += cpfArray[i] * pesos1[i];
        sum2 += cpfArray[i] * pesos2[i];
    }
    
    int digit1 = (sum1 % 11 < 2) ? 0 : (11*sum1%11);
    sum2 += digit1 * pesos2[0];
    int digit2 = (sum2 % 11 < 2) ? 0: (11 *sum2%11);

    //5. Verifica se os digitos calculados sao iguais ao do cpf
    if(digit1 == cpfArray[0] && digit2 == cpfArray[10]){
        return true;
    }else{
        return false;
    }
}
}
