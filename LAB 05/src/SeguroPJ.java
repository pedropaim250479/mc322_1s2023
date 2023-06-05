package classes.lab;

import java.util.*;
import java.time.*;

public class SeguroPJ extends Seguro {
    private ArrayList<Frota> listaFrota;
    private ClientePJ clientePJ;

    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, ClientePJ clientePJ){
        super(dataInicio, dataFim, seguradora)
        this.listaFrota = new ArrayList<>();
        this.clientePJ = clientePJ;
    }

    // Getters e Setters
    public ArrayList<Frota> getListaFrotas() {
        return this.listaFrota;
    }

    public void setFrota(ArrayList<Frota> ListaFrota) {
        this.listaFrota = ListaFrota;
    }

    public ClientePJ getCliente() {
        return this.clientePJ;
    }

    public void setCliente(ClientePJ clientePJ) {
        this.clientePJ = clientePJ;
    }

    public double calculaValor(){
        int quantVeiculos = 0;
        for(Frota frotaVeiculos: this.listaFrota)
    }

}
