package classes.lab;
import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

public class Cliente{
    private String nome;
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private String endereco;
    private List<Veiculo> listaVeiculos;
    
    //Construtor de Cliente

    public Cliente(String nome, Date dataLicenca, String educacao, String genero, String classeEconomica,
        String endereco, List<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.endereco = endereco;
        this.listaVeiculos = new ArrayList<>();
    }

    //Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
    
    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", dataLicenca=" + dataLicenca + ", educacao=" + educacao + ", genero="
                + genero + ", classeEconomica=" + classeEconomica + ", endereco=" + endereco + ", listaVeiculos="
                + listaVeiculos + "]";
    }

}