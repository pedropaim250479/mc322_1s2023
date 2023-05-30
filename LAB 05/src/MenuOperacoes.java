package classes.lab;

public enum MenuOperacoes {
    // MENU PRINCIPAL
    CADASTRO(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALC_RECEITA_SEG(6),
    SAIR(0),
    // SUBMENU [1]
    CADASTRAR_CLIENTE(11),
    CADASTRAR_VEICULO(12),
    CADASTRAR_SEGURADORA(13),
    VOLTAR_1(14),
    // SUBMENU[2]
    LISTAR_CLIENTE_SEGURADORA(21),
    LISTAR_SINISTRO_SEGURADORA(22),
    LISTAR_SINISTRO_CLIENTE(23),
    LISTAR_VEICULO_CLIENTE(24),
    LISTAR_VEICULO_SEGURADORA(25),
    VOLTAR_2(26),
    // SUBMENU[3]
    EXCLUIR_CLIENTE(31),
    EXCLUIR_VEICULO(32),
    EXCLUIR_SINISTRO(33),
    VOLTAR_3(34);

    public final int index;

    // "CONSTRUTOR"
    MenuOperacoes(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
