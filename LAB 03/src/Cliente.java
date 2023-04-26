package classes.lab;
import java.util.ArrayList;

public abstract class Cliente{
    private String nome;
    private String tipoCliente;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    
    //Construtor de Cliente

    public Cliente(String nome, String tipoCliente, String endereco) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.endereco = endereco;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    //Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void removeVeiculoCliente(Veiculo veiculoCliente){
        listaVeiculos.remove(veiculoCliente);
    }

    public void addVeiculoCliente(Veiculo veiculoCliente){
        listaVeiculos.add(veiculoCliente);
    }


    public Veiculo procuraVeiculoCliente(String placa){
        for(Veiculo veiculo : listaVeiculos){
            if(veiculo.getPlaca().equals(placa)){
                return veiculo;
            }            
        }return null;
    }

    public abstract String getId();
    
    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", endereco=" + endereco + "]";
    }
}