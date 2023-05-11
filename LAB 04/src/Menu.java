package classes.lab;

public enum Menu {
    // MENU PRINCIPAL
    CADASTRO(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALC_RECEITA_SEG(6),
    SAIR(0),
    // SUBMENU [1]
    CADASTRAR_CLIENTE(1.1),
    CADASTRAR_VEICULO(1.2),
    CADASTRAR_SEGURADORA(1.3),
    // SUBMENU[2]
    LISTAR_CLIENTE_SEGURADORA(2.1),
    LISTAR_SINISTRO_SEGURADORA(2.2),
    LISTAR_SINISTRO_CLIENTE(2.3),
    LISTAR_VEICULO_CLIENTE(2.4),
    LISTAR_VEICULO_SEGURADORA(2.5);

    public final double index;

    // "CONSTRUTOR"
    Menu(double index) {
        this.index = index;
    }

    public double getIndex() {
        return index;
    }
}
