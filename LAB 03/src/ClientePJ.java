package classes.lab;
import java.util.List;
import java.sql.Date;

public class ClientePJ extends Cliente {
    private String cnpj;
    private Date dataFundacao;

    //Construror da classe PJ
    public ClientePJ (String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, 
    List<Veiculo> listaVeiculos, String cnpj, Date dataNascimento){
        super(nome, dataLicenca, educacao, genero, classeEconomica, endereco, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataNascimento;

    }

    //Getters and Setters

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }


    //Metodo toString()
    @Override
    public String toString() {
        return "ClientePJ, cnpj=" + cnpj + ", data de Fundacao=" + dataFundacao + "]";
    }

    //Validação de CNPK
    public static boolean validarCNPJ(String cnpj){
        //1. REmove os caracteres não numéricos
        cnpj = cnpj.replaceAll("[^\\d]", "");

        int tam = cnpj.length();

        //2. Verifica se tem 11 dígitos
        if(tam != 14){
            return false;
        }

        //3. Verifica se os digitos são todos iguais
        boolean digitosIguais = true;
        for(int i = 1; i<tam; i++){
            if(cnpj.charAt(i) != cnpj.charAt(0)){
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais){
            return false;
        }

        //4. Calcula os dígitos verificadores
        int[] cnpjArray = new int[12];
        for(int i = 0; i<tam;i++){
            cnpjArray[i] = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
        }
        int[] pesos1 = {5,4,3,2,9,8,7,6,5,4,3,2};
        int[] pesos2 = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i<(tam-2); i++){
            sum1 += cnpjArray[i] * pesos1[i];
            sum2 += cnpjArray[i] * pesos2[i];
        }
        
        int digit1 = (sum1 % 14 < 2) ? 0 : (14*sum1%11);
        sum2 += digit1 * pesos2[0];
        int digit2 = (sum2 % 14 < 2) ? 0: (14*sum2%11);

        //5. Verifica se os digitos calculados sao iguais ao do cnpj
        if(digit1 == cnpjArray[0] && digit2 == cnpjArray[10]){
            return true;
        }else{
            return false;
        }
    }

    
}
