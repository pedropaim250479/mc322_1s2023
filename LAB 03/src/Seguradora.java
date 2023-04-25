package classes.lab;
import java.util.List;
import java.util.ArrayList;

public class Seguradora { 
    private String nome ; 
    private String telefone ; 
    private String email ; 
    private String endereco ; 
    private List<Sinistro> listaSinistro;
    private List<Cliente> listaCliente;
// Construtor 

public Seguradora(String nome, String telefone, String email, String endereco, List<Sinistro> listaSinistro,
            List<Cliente> listaCliente) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistro = new ArrayList<>();
        this.listaCliente = new ArrayList<>();
    }
    // Getters e setters 
    public List<Sinistro> getListaSinistro() {
        return listaSinistro;
    }
    public void setListaSinistro(List<Sinistro> listaSinistro) {
        this.listaSinistro = listaSinistro;
    }
    public List<Cliente> getListaCliente() {
        return listaCliente;
    }
    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    public String getNome () { 
        return nome ; 
    } 
    public void setNome ( String nome ) { 
        this.nome = nome ; 
    } 
    public String getTelefone () { 
        return telefone ; 
    } 
    public void setTelefone ( String telefone ) { 
        this.telefone = telefone ; 
    } 
    public String getEmail () { 
        return email ; 
    } 
    public void setEmail ( String email ) { 
        this.email = email ; 
    } 
    public String getEndereco () { 
        return endereco ; 
    } 
    public void setEndereco ( String endereco ) { 
        this.endereco = endereco ; 
    }

    public boolean cadastrarCliente(Cliente cliente){
        
    }

    public boolean removerCliente(String cliente){

    }

    public List<Cliente> listarClientes(){

    }

    public boolean gerarSinistro(){

    }

    public boolean visualizarSinistro(String cliente){

    }

    public List<Sinistro> listaSinistros(){
        
    }

}
