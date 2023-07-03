package classes.lab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        // Criar Clientes PJ
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date dataFund1 = format.parse("01/03/1929");
        Date dataFund2 = format.parse("06/01/2010");
        ClientePJ clientePJ_1 = new ClientePJ("Mercedes F1", "Brackley", dataFund2, "05.980.450/0000-25", "PJ");
        ClientePJ clientePJ_2 = new ClientePJ("Scuderia Ferrari", "Maranello", dataFund1, "06.980.590/0001-24", "PJ");

        Boolean verificaCNPJ_1 = clientePJ_1.validarCNPJ(clientePJ_1.getCnpj());
        Boolean verificaCNPJ_2 = clientePJ_2.validarCNPJ(clientePJ_2.getCnpj());

        // Criar clientes PF
        Date dataNascimento1 = format.parse("01/03/1929");
        Date dataLicenca1 = format.parse("01/03/1929");
        Date dataNascimento2 = format.parse("06/01/2010");
        Date dataLicenca2 = format.parse("06/01/2010");
        ClientePF clientePF_1 = new ClientePF("Michael Schumacher", "Berlim", dataLicenca1, "Ensino Superior",
                "Masculino", "A", "567.461.694-00", dataNascimento1, "Pf");
        ClientePF clientePF_2 = new ClientePF("Lewis Hamilton", "Londres", dataLicenca2, "Ensino Superios", "Masculino",
                "A", "264.261.867-01", dataNascimento2, "PF");

        Boolean verificaCPF_1 = clientePF_1.validarCPF(clientePF_1.getCpf());
        Boolean verificaCPF_2 = clientePF_2.validarCPF(clientePF_2.getCpf());

        // Criar Veiculos

        Veiculo carro_1 = new Veiculo("BCA0123", "Mercedes", "C63 AMG", 2015);
        Veiculo carro_2 = new Veiculo("ABC0124", "Ferrari", "Ferrari 458 Italia", 2013);
        Veiculo carro_3 = new Veiculo("CDAB0122", "Renault", "Megane", 2018);
        Veiculo carro_4 = new Veiculo("ABD1234", "Chevrolet", "Kadett", 1998);

        // Adicionar Veiculos aos clientes

        clientePF_1.addVeiculoCliente(carro_4);
        clientePF_2.addVeiculoCliente(carro_1);
        clientePJ_1.addVeiculoCliente(carro_3);
        clientePJ_2.addVeiculoCliente(carro_2);

        // Criar seguradora para os clientes
        Seguradora seguradora1 = new Seguradora("Seguradora Seguros", "(19)976458653", "seguradoraseguros@gmail.com",
                "Campinas");
        Seguradora seguradora2 = new Seguradora("Seguradora Confia", "(11)9726143", "confiaseguros@gmail.com",
                "São Paulo");
        seguradora1.cadastrarCliente(clientePF_2);
        seguradora1.cadastrarCliente(clientePJ_1);
        seguradora2.cadastrarCliente(clientePF_1);
        seguradora2.cadastrarCliente(clientePJ_2);

        // Gerar os sinistros para os clientes
        seguradora1.gerarSinistro(clientePF_2, null, carro_4, seguradora2, null);
        seguradora1.gerarSinistro(clientePF_2, null, carro_4, seguradora2, null);
        seguradora2.gerarSinistro(clientePF_2, null, carro_4, seguradora2, null);
        seguradora2.gerarSinistro(clientePF_2, null, carro_4, seguradora2, null);

        Scanner scan = new Scanner(System.in);
        int escolha = scan.nextInt();
        do {
            System.out.println("Digite um comando...");
            switch (escolha) {
                case 1:
                    seguradora1.listarClientes("cnpj");
                    break;
                case 2:
                    seguradora1.listarSinistros();
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Cadastrando...");
                    System.out.println("[1] Pessoa Física ou [2] Pessoa Jurídica ?");
                    int escolha2 = scan.nextInt();
                    System.out.println("Cadastrando...");
                    switch (escolha2) {
                        case 1:
                            System.out.println("Qual é o seu nome?");
                            String nomePF = scan.nextLine();
                            System.out.println("Qual o seu endereço?");
                            String endereco = scan.nextLine();
                            System.out.println("Qual o seu genero?");
                            String genero = scan.nextLine();
                            System.out.println("Qual sua classe economica?");
                            String classeEcono = scan.nextLine();
                            System.out.println("Qual seu nível de Educação?");
                            String educacao = scan.nextLine();
                            System.out.println("Qual o seu CPF?");
                            final String cpf = scan.nextLine();
                            ClientePF clienteNovo = new ClientePF(nomePF, endereco, dataLicenca2, educacao, genero,
                                    classeEcono, cpf, dataNascimento2, "PF");
                            seguradora1.cadastrarCliente(clienteNovo);
                            System.out.println("Cliente PF Cadastrado");
                            break;
                        case 2:
                            System.out.println("Qual é o seu nome?");
                            String nomePJ = scan.nextLine();
                            System.out.println("Qual o seu endereço?");
                            String enderecoPj = scan.nextLine();
                            System.out.println("Qual o seu CNPJ?");
                            final String cnpj = scan.nextLine();
                            ClientePJ clienteNovo2 = new ClientePJ(nomePJ, enderecoPj, dataFund2, cnpj, "PJ");
                            seguradora1.cadastrarCliente(clienteNovo2);
                            System.out.println("Cliente PJ Cadastrado");
                            break;
                        default:
                            System.out.println("Dogite um Valor Válido");
                            break;
                    }
                    break;
                case 5:
                    seguradora2.listarClientes("pf");
                    break;
                case 6:
                    seguradora2.listarSinistros();
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Cadastrando...");
                    System.out.println("[1] Pessoa Física ou [2] Pessoa Jurídica ?");
                    int escolha3 = scan.nextInt();
                    System.out.println("Cadastrando...");
                    switch (escolha3) {
                        case 1:
                            System.out.println("Qual é o seu nome?");
                            String nomePF = scan.nextLine();
                            System.out.println("Qual o seu endereço?");
                            String endereco = scan.nextLine();
                            System.out.println("Qual o seu genero?");
                            String genero = scan.nextLine();
                            System.out.println("Qual sua classe economica?");
                            String classeEcono = scan.nextLine();
                            System.out.println("Qual seu nível de Educação?");
                            String educacao = scan.nextLine();
                            System.out.println("Qual o seu CPF?");
                            final String cpf = scan.nextLine();
                            ClientePF clienteNovo = new ClientePF(nomePF, endereco, dataLicenca2, educacao, genero,
                                    classeEcono, cpf, dataNascimento2, "PF");
                            seguradora1.cadastrarCliente(clienteNovo);
                            System.out.println("Cliente PF Cadastrado");
                            break;
                        case 2:
                            System.out.println("Qual é o seu nome?");
                            String nomePJ = scan.nextLine();
                            System.out.println("Qual o seu endereço?");
                            String enderecoPj = scan.nextLine();
                            System.out.println("Qual o seu CNPJ?");
                            final String cnpj = scan.nextLine();
                            ClientePJ clienteNovo2 = new ClientePJ(nomePJ, enderecoPj, dataFund2, cnpj, "PJ");
                            seguradora1.cadastrarCliente(clienteNovo2);
                            System.out.println("Cliente PJ Cadastrado");
                            break;
                        default:
                            System.out.println("Dogite um Valor Válido");
                            break;
                    }
                    break;
                default:
                    System.out.println("Favor digitar um comando válido...\n");
                    break;
            }
        } while (escolha != 9);
        System.out.println("Até Mais!");
        scan.close();
    }

    public static void MenuOperacoes() throws ParseException {
        MenuOperacoes menuOperacoes;
        Scanner scan = new Scanner(System.in);
        String opcaoMenu;
        int escolha;
        do {
            System.out.println("Selecione o comando do menu a seguir... \n");
            System.out.println("[" + MenuOperacoes.CADASTRO.index + "]" + MenuOperacoes.CADASTRO);
            System.out.println("[" + MenuOperacoes.LISTAR.index + "]" + MenuOperacoes.LISTAR);
            System.out.println("[" + MenuOperacoes.EXCLUIR.index + "]" + MenuOperacoes.EXCLUIR);
            System.out.println("[" + MenuOperacoes.GERAR_SINISTRO.index + "]" + MenuOperacoes.GERAR_SINISTRO);
            System.out.println("[" + MenuOperacoes.CALC_RECEITA_SEG.index + "]" + MenuOperacoes.CALC_RECEITA_SEG);
            System.out.println("[" + MenuOperacoes.SAIR.index + "]" + MenuOperacoes.SAIR);
            escolha = scan.nextInt();
            switch(escolha){
                case 1:
                    opcaoMenu = "CADASTRO";
                    break;
                case 2:
                    opcaoMenu = "LISTAR";
                    break;
                case 3:
                    opcaoMenu = "EXCLUIR";
                    break;
                case 4:
                    opcaoMenu = "GERAR_SINISTRO";
                    break;
                case 5:
                    opcaoMenu = "TRANSFERIR_SEGURO";
                    break;
                case 6:
                    opcaoMenu = "CALC_RECEITA_SEG";
                    break;
                case 0:
                    opcaoMenu = "SAIR";
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    opcaoMenu = "ERRO";
                    break;
            }
            menuOperacoes = MenuOperacoes.valueOf(opcaoMenu);
            switch (menuOperacoes) {
                case CADASTRO:
                    int escolha1 = scan.nextInt();
                    switch (escolha1) {
                        case 11:

                            break;
                    }
                case LISTAR:
                    int escolha2 = scan.nextInt();

                    break;
                case EXCLUIR:
                    int escolha3 = scan.nextInt();

                    break;
                case GERAR_SINISTRO:
                    break;

                case TRANSFERIR_SEGURO:
                    break;
                
                case CALC_RECEITA_SEG:
                    break;

                default:
                    System.out.println("Comando Inválido, digite novamente");
                    break;
            }
        } while (menuOperacoes != MenuOperacoes.SAIR);
        scan.close();
    }

}
