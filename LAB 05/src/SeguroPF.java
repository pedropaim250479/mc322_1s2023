package classes.lab;

import java.time.LocalDate;
import java.time.Period;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF clientePF;

    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo,
            ClientePF clientePF) {
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.clientePF = clientePF;
        super.setValorMensal(calculaValor());
    }

    // Getters e Setters

    public ClientePF getCliente() {
        return this.clientePF;
    }

    public void setCliente(ClientePF cliente) {
        this.clientePF = cliente;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    // Calcular Valor Seguro
    public double calculaValor() {
        int idadeCondutor = (Period.between(clientePF.getDataNascimento(), LocalDate.now())).getYears();
        int quantVeiculos = (clientePF.getListaVeiculos().size());
        int quantSinistrosCliente = getSeguradora().getSinistrosCliente(clientePF).size();
        int quantSinistrosCondutor = 0;
        for (Condutor condutor : super.getListaCondutores()) {
            quantSinistrosCondutor += condutor.getListaSinistros().size();
        }
        double fatorIdade = 0;
        if ((18 <= idadeCondutor) && (idadeCondutor <= 30)) {
            fatorIdade = CalculaSeguro.FATOR_18_30.getValor();
        } else if ((30 < idadeCondutor) && (idadeCondutor <= 60)) {
            fatorIdade = CalculaSeguro.FATOR_30_60.getValor();
        } else {
            fatorIdade = CalculaSeguro.FATOR_60_90.getValor();
        }
        //
        return (CalculaSeguro.VALOR_BASE.getValor() * fatorIdade * (1 + (1 / quantVeiculos)) *
                (2 + (quantSinistrosCliente / 10)) * (5 + (quantSinistrosCondutor / 10)));
    }

    @Override
    public String toString() {
        return "{" +
                " veiculo='" + getVeiculo() + "'" +
                ", cliente='" + getCliente() + "'" +
                "}";
    }
}
