package classes.lab;

import java.util.List;
import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Sinistro> listaSinistro;
    private List<Cliente> listaCliente;
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
    public List<Sinistro> getListaSinistro() {
        return listaSinistro;
    }

    public void setListaSinistro(ArrayList<Sinistro> listaSinistro) {
        this.listaSinistro = listaSinistro;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
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

    public Boolean cadastrarCliente(Cliente cliente) {
        listaCliente.add(cliente);
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
