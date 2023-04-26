package classes.lab;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {
    public static void main(String[] args) throws ParseException{
        //Criar Clientes PJ
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
        ClientePF clientePF_1 = new ClientePF("Michael Schumacher", "Berlim", dataLicenca1, "Ensino Superior", "Masculino", "A", "567.461.694-00", dataNascimento1, "Pf");
        ClientePF clientePF_2 = new ClientePF("Lewis Hamilton", "Londres", dataLicenca2, "Ensino Superios","Masculino", "A", "264.261.867-01", dataNascimento2, "PF");
       
        Boolean verificaCPF_1 = clientePF_1.validarCPF(clientePF_1.getCpf());
        Boolean verificaCPF_2 = clientePF_2.validarCPF(clientePF_2.getCpf());
    
        //Criar Veiculos

        Veiculo carro_1 = new Veiculo("BCA0123", "Mercedes", "C63 AMG", 2015);
        Veiculo carro_2 = new Veiculo("ABC0124", "Ferrari", "Ferrari 458 Italia",2013);
        Veiculo carro_3 = new Veiculo("CDAB0122", "Renault", "Megane", 2018);
        Veiculo carro_4 = new Veiculo("ABD1234", "Chevrolet", "Kadett", 1998);

        //Adicionar Veiculos aos clientes

        clientePF_1.addVeiculoCliente(carro_4);
        clientePF_2.addVeiculoCliente(carro_1);
        clientePJ_1.addVeiculoCliente(carro_3);
        clientePJ_2.addVeiculoCliente(carro_2);

        //Criar seguradora para os clientes
        Seguradora seguradora1 = new Seguradora("Seguradora Seguros","(19)976458653" , "seguradoraseguros@gmail.com", "Campinas");
        Seguradora seguradora2 = new Seguradora("Seguradora Confia", "(11)9726143" , "confiaseguros@gmail.com", "São Paulo");
        seguradora1.cadastrarCliente(clientePF_2);
        seguradora1.cadastrarCliente(clientePJ_1);
        seguradora2.cadastrarCliente(clientePF_1);
        seguradora2.cadastrarCliente(clientePJ_2);

        //Gerar os sinistros para os clientes
        seguradora1.gerarSinistro(clientePF_2, null, carro_4, seguradora2, null);
        seguradora1.gerarSinistro(clientePF_2, null, carro_4, seguradora2, null);
        seguradora2.gerarSinistro(clientePF_2, null, carro_4, seguradora2, null);
        seguradora2.gerarSinistro(clientePF_2, null, carro_4, seguradora2, null);

        Scanner scan = new Scanner(System.in);
        System.out.printf("Olá, bem-vindo. Abaixo serão listadas as opções que você poderá acessar. Digite os valores para acessar!\n");
        System.out.printf("[1] Para acessar os clientes da seguradora" + seguradora1.getNome()+"\n"
                         +"[2] Para acessar a lista de sinistros da seguradora" +seguradora1.getNome()+"\n"
                         +"[3] Para remover um cliente da seguradora" +seguradora1.getNome()+"\n"
                         +"[4] Para adicionar um cliente à seguradora"+seguradora1.getNome()+"\n"
                         +"[5] Para acessar os clientes da seguradora" + seguradora2.getNome()+"\n"
                         +"[6] Para acessar a lista de sinistros da seguradora" +seguradora2.getNome()+"\n"
                         +"[7] Para remover um cliente da seguradora" +seguradora2.getNome()+"\n"
                         +"[8] Para adicionar um cliente à seguradora"+ seguradora2.getNome()+"\n"
                         +"[9] Para sair\n");
        int escolha = scan.nextInt();
        do{
            System.out.println("Digite um comando...");
            switch(escolha){
                case 1:
                    seguradora1.listarClientes();
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
                    switch(escolha2){
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
                            ClientePF clienteNovo = new ClientePF(nomePF, endereco, dataLicenca2, educacao, genero, classeEcono, cpf, dataNascimento2, "PF");
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
                    seguradora2.listarClientes();
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
                    switch(escolha3){
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
                            ClientePF clienteNovo = new ClientePF(nomePF, endereco, dataLicenca2, educacao, genero, classeEcono, cpf, dataNascimento2, "PF");
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
    }while(escolha != 9);
    System.out.println("Até Mais!");
    scan.close();
    }

        
    
}
