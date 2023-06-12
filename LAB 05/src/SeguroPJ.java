package classes.lab;

import java.util.*;
import java.time.*;

public class SeguroPJ extends Seguro {
    private ArrayList<Frota> listaFrota;
    private ClientePJ clientePJ;

    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, ClientePJ clientePJ,
            Veiculo veiculoCliente) {
        super(dataInicio, dataFim, seguradora);
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

    public double calculaValor() {
        int quantVeiculos = 0;
        int quantFunc = clientePJ.getQtdeFuncionarios();
        for (Frota frotaVeiculos : this.listaFrota) {
            quantVeiculos += frotaVeiculos.getListaVeiculos().size();
        }
        // Ano Fudacao
        int anoFundacao = (Period.between(clientePJ.getDataFundacao(), LocalDate.now())).getYears();

        // Quantidade de Sinistros
        int quantSinistros = getSeguradora().getSinsistrosCliente(clientePJ).size();

        // Quantidade de sinistros por condutor
        int quantSinistrosCondutor = 0;
        for (Condutor condutor : listaCondutores) {
            quantSinistrosCondutor += condutor.getListaSinistros().size();
        }

        // VAlor do seguro
        double valorSeguro = (CalculaSeguro.VALOR_BASE.getValor()) * (10 + quantFunc / 10) * (1 + 1 / (anoFundacao + 2))
                * (2 + quantSinistros / 10) * (5 + quantSinistrosCondutor / 10);
        valorMensal = valorSeguro;
        return valorSeguro;
    }

    @Override

    public String toString() {
        return "{" + " listaFrotas='" + getListaFrotas() + "'" +
                ", cliente='" + getCliente() + "'" +
                "}";
    }

}
