package classes.lab;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Seguradora { 
    private String nome ; 
    private String telefone ; 
    private String email ; 
    private String endereco ; 
    private ArrayList<Sinistro> listaSinistro;
    private ArrayList<Cliente> listaCliente;
// Construtor 

public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistro = new ArrayList<>();
        this.listaCliente = new ArrayList<>();
    }
    // Getters e setters 
    public ArrayList<Sinistro> getListaSinistro() {
        return listaSinistro;
    }
    public void setListaSinistro(ArrayList<Sinistro> listaSinistro) {
        this.listaSinistro = listaSinistro;
    }
    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }
    public void setListaCliente(ArrayList<Cliente> listaCliente) {
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

    public Boolean cadastrarCliente(Cliente cliente){
        listaCliente.add(cliente);
        return true;
    }

    public Boolean removerCliente(String clienteId){
        Iterator <Sinistro> iteradorListaSinistros = listaSinistro.iterator();
        Iterator <Cliente> iteradorListaCliente = listaCliente.iterator();
        while (iteradorListaCliente.hasNext()){
            Cliente clienteLista = iteradorListaCliente.next();
            if(clienteLista.getId().equals(clienteId)){
                while(iteradorListaCliente.hasNext()){
                    Sinistro sinistroLista = iteradorListaSinistros.next();
                    if(sinistroLista.getCliente().equals(clienteLista)){
                        ArrayList <Veiculo> listaVeiculos = clienteLista.getListaVeiculos();
                        Iterator <Veiculo> iteradorListaVeiculos = listaVeiculos.iterator();
                        while(iteradorListaVeiculos.hasNext()){
                            Veiculo veiculoLista = iteradorListaVeiculos.next();
                            iteradorListaVeiculos.remove();
                        }
                        iteradorListaSinistros.remove();
                    }
                    iteradorListaCliente.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public void listarClientes(String tipo){
        String pessoaFisica = "PFIS";
        String pessoaJuridica = "PJUR";
        for(Cliente clienteLista : listaCliente){
            if(tipo.equals(pessoaFisica) && clienteLista.getTipoCliente().equals(pessoaFisica)){
                System.out.println(clienteLista);
            }
        else if(tipo.equals(pessoaJuridica) && clienteLista.getTipoCliente().equals(pessoaJuridica)){
            System.out.println(clienteLista);
        }
        }
    }

    public Boolean gerarSinistro(Cliente cliente, String dataCliente, Veiculo veiculocCliente, Seguradora seguradora, String endereco){
        Sinistro sinistroCliente = new Sinistro(dataCliente, endereco, seguradora, veiculocCliente, cliente);
        listaSinistro.add(sinistroCliente);
        return true;
    }

    public Boolean visualizarSinistro(String clienteId, String tipoCliente){
        int visPFCounter = 0;
        int visPJCounter = 0;
        String pessoaFisica = "PFIS";
        String pessoaJuridica = "PJUR";
        for(Cliente clienteLista : listaCliente){
            if(tipoCliente.equals(pessoaFisica) && clienteLista.getTipoCliente().equals(tipoCliente))
                if(clienteLista.getId().equals(clienteId))
                    for(Sinistro sinistro : listaSinistro){
                        if(sinistro.getCliente().equals(clienteLista)){
                            System.out.println(sinistro);
                            visPFCounter++;
                        }
                }
            else if(tipoCliente.equals(pessoaJuridica) && clienteLista.getTipoCliente().equals(tipoCliente)){
                if(clienteLista.getId().equals(clienteId))
                    for(Sinistro sinistro : listaSinistro){
                        if(sinistro.getCliente().equals(clienteLista)){
                            System.out.println(sinistro);
                            visPJCounter++;
                        }
                }
            }
        }
        if(visPFCounter > 0 || visPJCounter > 0)
            return true;
        else
            return false;
    }

    public void listarSinistros() {
		for(Sinistro sinistroCliente : listaSinistro) {
				System.out.println(sinistroCliente);	
		}
	}

    public String toString() {
		return "Seguradora " + nome + ", e-mail " + email + ", telefone " +telefone + 
				"endereço" + endereco + ". \n";
	}

}
