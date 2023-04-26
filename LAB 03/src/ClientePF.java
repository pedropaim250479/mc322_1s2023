package classes.lab;
import java.util.Date;

public class ClientePF extends Cliente {
    private final String cpfCliente;
    private Date dataNascimento;
    private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;

   

    //Construtor da classe e superClasse
    public ClientePF (String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, 
    String cpf, Date dataNascimento, String tipoCliente){
        super(nome, tipoCliente, endereco);
        this.cpfCliente = cpf;
        this.dataLicenca = dataLicenca;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.educacao = educacao;
        this.classeEconomica = classeEconomica;

    }

    //GEtters and Setters

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

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    @Override
    public String getId(){ // Utiliza o getId da classe CLiente
        return cpfCliente;
    }
    //Método toString()
    @Override
    public String toString() {
        return "ClientePF, cpf=" + cpfCliente + ", data de Nascimento=" + dataNascimento + "]";
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
