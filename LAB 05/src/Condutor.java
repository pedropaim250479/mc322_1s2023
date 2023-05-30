package classes.lab;

import java.util.*;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private ArrayList<Sinistro> listaSinistros;
    private boolean autorizacao;
    private Date dataNascimento;

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.listaSinistros = new ArrayList<>();
        this.autorizacao = false;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public boolean isAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(boolean autorizacao) {
        this.autorizacao = autorizacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean addSinistro(Sinistro newSinistro) {
        for (Sinistro sinistro : this.listaSinistros) {
            if (sinistro.equals(newSinistro)) {
                System.out.println("Sinistro já cadastrado");
                return false;
            }
        }
        listaSinistros.add(newSinistro);
        return true;
    }

    @Override
    public String toString() {
        return "Condutor [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
                + ", email=" + email + ", listaSinistros=" + listaSinistros + ", autorizacao=" + autorizacao
                + ", dataNascimento=" + dataNascimento + "]";
    }
}
