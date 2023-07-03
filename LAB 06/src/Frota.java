package classes.lab;

import java.util.*;

public class Frota {
    String code;
    ArrayList<Veiculo> listaVeiculos;
    int counter;

    public Frota() {
        this.code = codeVal();
        this.listaVeiculos = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String codeVal() {
        // Gerar um valor para o código da Frota, de maneira aleatória
        String codigoAleatorio = "";
        Random geraAleatorio = new Random();
        for (int i = 0; i < 10; i++) {
            int id = geraAleatorio.nextInt(30);
            char codigo = (char) (id + 100);
            codigoAleatorio += codigo;
        }
        return codigoAleatorio;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void adicionaVeiculo(Veiculo veiculo) {
        for (Veiculo veiculo_1 : listaVeiculos) {
            if (veiculo_1.getPlaca().equals(veiculo.getPlaca()))
                System.out.println("O veículo" + veiculo + "em questão já existe na lista");
        }
        this.listaVeiculos.add(veiculo);
    }

    public boolean removeVeiculo(String id_veiculo) {
        Iterator<Veiculo> veiculo_iterator = listaVeiculos.iterator();
        while (veiculo_iterator.hasNext()) {
            Veiculo veiculo_remove = veiculo_iterator.next();
            if (veiculo_remove.getPlaca().equals(id_veiculo)) {
                veiculo_iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" + "code = " + getCode() + "," + "lista de veiculos" + getListaVeiculos() + "}";
    }
}
