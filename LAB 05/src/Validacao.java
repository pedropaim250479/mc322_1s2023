package classes.lab;

public class Validacao {
    public static boolean validarCPF(String cpf) {
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

    public static boolean validaNome(String nome) {
        if (nome == null || nome.isEmpty())
            return false;
        return nome.matches("[\\p{L} ]+");
    }
}
