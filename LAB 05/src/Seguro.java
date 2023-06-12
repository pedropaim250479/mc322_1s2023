package classes.lab;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Seguro {
    protected final int id;
    static int counter = 0;
    protected LocalDate dataInicio;
    protected LocalDate dataFim;
    protected Seguradora seguradora;
    protected ArrayList<Sinistro> listaSinistros;
    protected ArrayList<Condutor> listaCondutores;
    protected double valorMensal;

    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
        this.id = counter;
        this.valorMensal = 0;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<>();
        this.listaCondutores = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return this.id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Seguro.counter = counter;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public boolean cadastrarCondutor(Condutor condutorCadastrar) {
        for (Condutor condutor : listaCondutores) {
            if (condutor.equals(condutorCadastrar)) {
                System.out.println("Já possui cadastro");
                return false;
            }
        }
        listaCondutores.add(condutorCadastrar);
        return true;
    }

    public boolean autorizarCondutor(Condutor condutorAutorizar) {
        for (Condutor condutor : listaCondutores) {
            if (condutor.equals(condutorAutorizar)) {
                condutor.setAutorizacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean desautorizarCondutor(Condutor condutorDesauto) {
        for (Condutor condutor : listaCondutores) {
            if (condutor.equals(condutorDesauto)) {
                condutor.setAutorizacao(false);
                return true;
            }
        }
        return false;
    }

    public boolean gerarSinistro(String data, Condutor condutorSinistro, String enderecoCondutor) {
        // Geração do Sinistro
        Sinistro sinistro = new Sinistro(data, enderecoCondutor, this.seguradora, condutorSinistro);
        ArrayList<Sinistro> listaSinistros = getListaSinistros();
        listaSinistros.add(sinistro);
        condutorSinistro.addSinistro(sinistro);
        setListaSinistros(listaSinistros);
        System.out.println("Sinistro Criado");
        return true;
    }

    public abstract double calculaValor();

    public abstract Cliente getCliente();

    @Override

    public String toString() {
        return "{" +
                " id='" + getId() + "'" + ", dataInicio='" + getDataInicio() + "'" + ", dataFim='" + getDataFim() + "'"
                +
                ", seguradora='" + getSeguradora() + "'" + ", listaSinistros='" + getListaSinistros() + "'"
                + ", listaCondutores='" + getListaCondutores() + "'" +
                ", valorMensal='" + getValorMensal() + "'" + "}";
    }
}
