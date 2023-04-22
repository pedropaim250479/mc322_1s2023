public class Cliente{
    private String nome;
    private String cpf;
    private String dataNascimento;
    public int idade;
    private String endereco;
    

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getCpf() {
        return cpf;
    }

  
    private void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public static boolean validarCPF(String cpf){
        //1. REmove os caracteres não numéricos
        cpf = cpf.replaceAll("[^\\d]","");

        //2. Verifica se tem 11 dígitos
        if(cpf.lenght() != 11){
            return false;
        }

        //3. Verifica se os digitos são todos iguais
        boolean digitosIguais = true;
        for(int i = 1; i<cpf.lenght(); i++){
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
        for(int i = 0; i<cpf.lenght();i++){
            cpfArray[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }
        int[] pesos1 = {10,9,8,7,6,5,4,3,2};
        int[] pesos2 = {11,10,9,8,7,6,5,4,3,2};
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i<9; i++){
            sum1 += cpfArray[i] * pesos1[i];
            sum2 += cpfArray[i] * pesos2[i]
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
    public String getDataNascimento() {
        return dataNascimento;
    }

    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

  
    public String getEndereco() {
        return endereco;
    }

  
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}