package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import conexao.Conexao;
import controller.*;
import model.*;


public class Main {
    public static void main(String[] args) {

        try (Connection conexao = Conexao.GeraConexao()){
            if(conexao != null){
                System.out.println("sistema conectado com sucesso");
            }

        }catch (SQLException e) {
           // e.printStackTrace();
            System.out.println("erro ao conectar");
        }

        Scanner input = new Scanner(System.in);
        Empresa_listas el = new Empresa_listas();
        Empresa_bd ebd = new Empresa_bd();
        Funcionario p = new Funcionario("Elon Musk", "235.534.525-02", "(83)9353523562", "gerenciador", 1000000.01);
        char opcao, resp, listas, remover, buscar;
        do{
            System.out.println("digite f para cadastrar um funcionario");
            System.out.println("digite c para cadastrar um cliente");
            System.out.println("digite d para ver os dados do propreietario da empresa");
            System.out.println("digite p para cadastrar um produto");
            System.out.println("digite l para listar");
            System.out.println("digite r para remover cliente/produto/funcionario");
            System.out.println("digite b para buscar cliente/produto/funcionario");
            opcao = input.next().charAt(0);
            switch (opcao){
                case 'f':
                    Funcionario f = new Funcionario();

                    System.out.println("digite o nome do funcionario");
                    f.setNome(input.next());
                    System.out.println("digite o CPF do funcionario");
                    f.setCfp(input.next());
                    System.out.println("digite o telefone do funcionario");
                    f.setTelefone(input.next());
                    System.out.println("digite o cargo do funcionario");
                    f.setCargo(input.next());
                    System.out.println("digite o salario do funcionario");
                    f.setSalario(input.nextDouble());

                    System.out.println("o nome do funcionario é "+ f.getNome());
                    System.out.println("o cpf é "+ f.getCfp());
                    System.out.println("o telefone é "+ f.getTelefone());
                    System.out.println("o cargo é "+ f.getCargo());
                    System.out.println("o salario é "+ f.getSalario());
                    //el.adiciona_funcionario(f);
                    ebd.adiciona_funcionario(f);

                    do{
                        System.out.println("digite 1 se ele participou de um curso de aperfeiçoamento");
                        System.out.println("digite 2 se ele vai fazer hora extra");
                        System.out.println("digite 3 se nao houver aumento de salario");
                        int resposta = input.nextInt();

                        switch (resposta){

                            case 1:

                                f.curso_capacitacao();

                                break;


                            case 2:

                                f.hora_extra();


                                break;


                            case 3:

                                System.out.println("o salario continua igual ");

                                break;

                            default:
                                System.out.println("opcao invalida");
                        }
                        System.out.println("para repetir digite s");
                        resp = input.next().charAt(0);
                    }while(resp==('s'));



                    break;


                case 'c':
                    Cliente c = new Cliente();

                    System.out.println("digite o nome do cliente");
                    c.setNome(input.next());
                    System.out.println("digite o CPF do cliente");
                    c.setCfp(input.next());
                    System.out.println("digite o telefone do cliente");
                    c.setTelefone(input.next());

                    System.out.println("o nome do cliente é "+ c.getNome());
                    System.out.println("o cpf é "+ c.getCfp());
                    System.out.println("o telefone é "+ c.getTelefone());
                    el.adiciona_cliente(c);
                    ebd.adiciona_cliente(c);
                    break;


                case 'd':

                    System.out.println(p.getNome());
                    System.out.println(p.getCfp());
                    System.out.println(p.getTelefone());
                    System.out.println(p.getCargo());
                    System.out.println(p.getSalario());

                    break;

                case 'p':

                    Produto pr = new Produto();
                    System.out.println("digite o nome do produto");
                    pr.setNome(input.next());
                    System.out.println("digite a quantidade de estoque do produto");
                    pr.setQuantidade(input.nextInt());
                    System.out.println("digiite o valor do produto");
                    pr.setValor(input.nextDouble());
                    //el.adiciona_produto(pr);
                    ebd.adiciona_produto(pr);
                    break;

                case 'l':

                    System.out.println("digite c para listar clientes, \n" +
                            "p para produtos, \n" +
                            "f para funcionarios ");

                    listas = input.next().charAt(0);
                    switch(listas){

                        case 'c':

                            System.out.println("os clientes cadastrados sao:");
                            //el.listar_cliente().forEach(System.out::println);
                            ebd.listar_cliente().forEach(System.out::println);
                            break;


                        case 'p':

                            System.out.println("os produtos cadastrados sao:");
                            //el.listar_produto().forEach(System.out::println);
                            ebd.listar_produto().forEach(System.out::println);
                            break;


                        case 'f':

                            System.out.println("os funcionarios cadastrados sao:");
                            //el.listar_funcionario().forEach(System.out::println);
                            ebd.listar_funcionario().forEach(System.out::println);

                            break;

                        default:
                            System.out.println("invalido");

                            break;


                    }
                    break;

                case 'r':

                    System.out.println("digite c parara remover cliente");
                    System.out.println("p para remover produto");
                    System.out.println("f para remover funcionario");
                    remover = input.next().charAt(0);
                    switch (remover){

                        case 'c':

                            System.out.println("digite o nome do cliente que desaja remover");
                            String nomec = input.next();
                            //el.remover_cliente(nomec);
                            ebd.remover_cliente(nomec);
                            System.out.println("cliente removido com sucesso");

                        break;

                        case 'f':

                            System.out.println("digite o nome do funcionario que desaja remover");
                            String nomef = input.next();
                            //el.remover_funcionario(nomef);
                            //System.out.println("funcionario removido com sucesso");
                            ebd.remover_funcionario(nomef);

                            break;

                        case 'p':

                            System.out.println("digite o nome do produto que deseja remover");
                            String nomep = input.next();
                            //el.remover_produto(nomep);
                            //System.out.println("produto removido com sucesso");
                            ebd.remover_produto(nomep);

                    }


                    break;



                case 'b':

                    System.out.println("digite c para buscar um clinte");
                    System.out.println("f para funcicionario");
                    System.out.println("p para produto");
                    buscar = input.next().charAt(0);
                    switch (buscar){
                        case 'c':

                            System.out.println("digite o nome do cliente a ser pesquisado");
                            String nomec = input.next();
                            //System.out.println(el.buscar_cliente(nomec));
                            System.out.println(ebd.buscar_cliente(nomec));

                            break;

                        case 'f':

                            System.out.println("digite o nome do funcionario a ser pesquisado");
                            String nomef = input.next();
                            //System.out.println(el.buscar_funcionario(nomef));
                            System.out.println(ebd.buscar_funcionario(nomef));

                            break;

                        case 'p':

                            System.out.println("digite o produto a ser pesquisado");
                            String nomep = input.next();
                            //System.out.println(el.buscar_produto(nomep));
                            System.out.println(ebd.buscar_produto(nomep));
                            break;
                    }




                    break;





                default:
                    System.out.println("opção invalida");
                    break;
            }
            System.out.println("deseja repetir? s/n");
            opcao = input.next().charAt(0);




































        }while (opcao == 's');















    }
}