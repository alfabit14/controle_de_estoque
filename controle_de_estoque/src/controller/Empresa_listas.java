package controller;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Empresa_listas {
    private ArrayList<Produto> produto;
    private ArrayList<Funcionario> funcionario;
    private ArrayList<Cliente> cliente;
    public Empresa_listas() {
        this.produto = new ArrayList<>();
        this.funcionario = new ArrayList<>();
        this.cliente = new ArrayList<>();
    }


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


    public void adiciona_cliente(Cliente cl){
        cliente.add(cl);

    }

    public List<Cliente> listar_cliente(){
        return cliente;
    }


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
}
