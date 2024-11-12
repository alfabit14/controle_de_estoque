package controller;
import model.*;
import DAO.*;

import java.util.List;

public class Empresa_bd {

    private ClienteDAO clienteDAO;
    private FuncionarioDAO funcionarioDAO;
    private ProdutoDAO produtoDAO;
    public Empresa_bd() {

        this.clienteDAO = new ClienteDAO();
        this.funcionarioDAO = new FuncionarioDAO();
        this.produtoDAO = new ProdutoDAO();
    }

/*
    public void adiciona_produto(Produto prod){
        produto.add(prod);

    }

    public List<Produto> listar_produto(){
        return produto;
    }



    public void adiciona_funcionario(Funcionario func){
        funcionario.add(func);
    }

    public List<Funcionario> listar_funcionario(){
        return funcionario;
    }



 */
    public void adiciona_cliente(Cliente cl){
        clienteDAO.adicionar_cliente(cl);
    }

    public List<Cliente> listar_cliente(){
        return clienteDAO.listar_cliente();
    }
    public void remover_cliente (String nome){
        clienteDAO.remover_cliente(nome);
    }

    public Cliente buscar_cliente(String nome){
        return clienteDAO.buscar_cliente(nome);
    }

    //-------------------------------------------------------------------------------------------------------
    public void adiciona_funcionario(Funcionario f){
        funcionarioDAO.adicionar_funcionario(f);
    }

    public List<Funcionario> listar_funcionario(){
        return funcionarioDAO.listar_funcionario();
    }
    public void remover_funcionario (String nome){
        funcionarioDAO.remover_funcionario(nome);
    }

    public Funcionario buscar_funcionario(String nome){
        return funcionarioDAO.buscar_funcionario(nome);
    }
    //-------------------------------------------------------------------------------------------------------
    public void adiciona_produto(Produto p){
        produtoDAO.adicionar_produto(p);
    }

    public List<Produto> listar_produto(){
        return produtoDAO.listar_produto();
    }
    public void remover_produto (String nome){
        produtoDAO.remover_produto(nome);
    }

    public Produto buscar_produto(String nome){
        return produtoDAO.buscar_produto(nome);
    }
/*
    public void remover_cliente(String nome){
        if(cliente.removeIf(cliente1 -> cliente1.getNome().equalsIgnoreCase(nome))){
            System.out.println("removido com sucesso");
        }
        else{
            System.out.println("funcionario nao encontrado");
        }

    }

    public void remover_funcionario(String nome) {

        if (funcionario.removeIf(funcionario1 -> funcionario1.getNome().equalsIgnoreCase(nome))) {
            System.out.println("removido com sucesso");
        }
        else{
            System.out.println("funcionario nao encontrado");
        }
    }

    public Cliente buscar_cliente (String nome){
        for(Cliente cliente1: cliente ){
            if(cliente1.getNome().equalsIgnoreCase(nome)){
                return cliente1;}
        }
        return null;
    }
    public Funcionario buscar_funcionario (String nome){
        for(Funcionario funcionario1: funcionario ){
            if(funcionario1.getNome().equalsIgnoreCase(nome)){
                return funcionario1;}
        }
        return null;
    }
    public Produto buscar_produto (String nome){
        for(Produto produto1: produto ){
            if(produto1.getNome().equalsIgnoreCase(nome)){
                return produto1;}
        }
        return null;
    }

 */
}
