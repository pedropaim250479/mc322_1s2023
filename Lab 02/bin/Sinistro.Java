import java.util.Random;
public class Sinistro {
    private int id;
    private String data;
    private String endereco;
    
/*Função que retorna o Id aleatório */
    public static int gerarId(){
        Random random = new Random();
        int id = random.nextInt(Integer.MAX_VALUE);
        return id;
    }
    /**
     * @return String return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return String return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}