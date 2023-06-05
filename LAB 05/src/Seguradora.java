package classes.lab;

import java.util.*;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> listaSeguros;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<ClientePF> listaClientesPF;
    private ArrayList<ClientePJ> listaClientePJ;
    // Construtor

    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSeguros = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaClientePJ = new ArrayList<>();
        this.listaClientesPF = new ArrayList<>();

    }

    // Getters e setters
    public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<ClientePF> getListaClientesPF() {
        return listaClientesPF;
    }

    public void setListaClientesPF(ArrayList<ClientePF> listaClientesPF) {
        this.listaClientesPF = listaClientesPF;
    }

    public ArrayList<ClientePJ> getListaClientePJ() {
        return listaClientePJ;
    }

    public void setListaClientePJ(ArrayList<ClientePJ> listaClientePJ) {
        this.listaClientePJ = listaClientePJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean cadastrarClientePf(ClientePF clientePF) {
        if (listaClientesPF.isEmpty()) {
            listaClientesPF.add(clientePF);
            listaClientes.add(clientePF);
        } else {
            for (ClientePF cliente : listaClientesPF) {
                if (cliente.getCpf().equals(clientePF.getCpf())) {
                    System.out.println("Cliente já cadastrado");
                    return false;
                }
            }
            listaClientes.add(clientePF);
            listaClientesPF.add(clientePF);
        }
        return true;
    }

    public boolean cadastrarClientePJ(ClientePJ clientePJ) {
        if (listaClientePJ.isEmpty()) {
            listaClientes.add(clientePJ);
            listaClientePJ.add(clientePJ);
        } else {
            for (ClientePJ cliente : listaClientePJ) {
                if (cliente.getCnpj().equals(clientePJ.getCnpj())) {
                    System.out.println("Cliente já cadastrado");
                    return false;
                }
            }
            listaClientePJ.add(clientePJ);
            listaClientes.add(clientePJ);
        }
        return true;
    }

    public boolean verificaId(Cliente cliente, String clienteId) {
        if (cliente instanceof ClientePF && ((ClientePF) cliente).getCpf().equals(clienteId)
                || cliente instanceof ClientePJ && ((ClientePJ) cliente).getCnpj().equals(clienteId)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean removerCliente(String clienteId) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (verificaId(listaCliente.get(i), clienteId)) {
                listaCliente.remove(i);
                return true;
            }
        }
        return false;
    }

    public void listarClientes(String tipo) {
        String pessoaFisica = "PFIS";
        String pessoaJuridica = "PJUR";
        for (Cliente clienteLista : listaCliente) {
            if (tipo.equals(pessoaFisica) && clienteLista.getTipoCliente().equals(pessoaFisica)) {
                System.out.println(clienteLista);
            } else if (tipo.equals(pessoaJuridica) && clienteLista.getTipoCliente().equals(pessoaJuridica)) {
                System.out.println(clienteLista);
            }
        }
    }

    public Boolean gerarSinistro(Cliente cliente, String dataCliente, Veiculo veiculocCliente, Seguradora seguradora,
            String endereco) {
        Sinistro sinistroCliente = new Sinistro(dataCliente, endereco, seguradora, veiculocCliente, cliente);
        listaSinistro.add(sinistroCliente);
        return true;
    }

    public Boolean visualizarSinistro(String clienteId, String tipoCliente) {
        int visPFCounter = 0;
        int visPJCounter = 0;
        String pessoaFisica = "PFIS";
        String pessoaJuridica = "PJUR";
        for (Cliente clienteLista : listaCliente) {
            if (tipoCliente.equals(pessoaFisica) && clienteLista.getTipoCliente().equals(tipoCliente))
                if (clienteLista.getId().equals(clienteId))
                    for (Sinistro sinistro : listaSinistro) {
                        if (sinistro.getCliente().equals(clienteLista)) {
                            System.out.println(sinistro);
                            visPFCounter++;
                        }
                    }
                else if (tipoCliente.equals(pessoaJuridica) && clienteLista.getTipoCliente().equals(tipoCliente)) {
                    if (clienteLista.getId().equals(clienteId))
                        for (Sinistro sinistro : listaSinistro) {
                            if (sinistro.getCliente().equals(clienteLista)) {
                                System.out.println(sinistro);
                                visPJCounter++;
                            }
                        }
                }
        }
        if (visPFCounter > 0 || visPJCounter > 0)
            return true;
        else
            return false;
    }

    public void listarSinistros() {
        for (Sinistro sinistroCliente : listaSinistro) {
            System.out.println(sinistroCliente);
        }
    }

    public double calculaPrecoSeguroCliente(Cliente cliente) {
        double sizeList = listaSinistro.size();
        return cliente.calculaScore() * (1 + sizeList);
    }

    public double calcularReceita() {
        double sum = 0;
        for (Cliente cliente : listaCliente)
            sum += cliente.getValorSeguro();
        return sum;
    }

    public String toString() {
        return "Seguradora " + nome + ", e-mail " + email + ", telefone " + telefone +
                "endereço" + endereco + ". \n";
    }

}