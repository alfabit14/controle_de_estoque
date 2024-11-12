package view;
import conexao.*;
import controller.Empresa_bd;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class GUI {
    private static Empresa_bd ebd2 = new Empresa_bd();

    public static void main(String[] args) {

        try (Connection conexao = Conexao.GeraConexao()){
            if(conexao != null){
                JOptionPane.showMessageDialog(null,"conexao realizada com sucesso");
            }

        }catch (SQLException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, "erro ao conectar");
        }
        JFrame frame = new JFrame("dprodutos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1));

        JButton btn_cadastrar_cliente = new JButton("cadastrar cliente");
        JButton btn_cadastrar_produto = new JButton("cadastar produto");
        JButton btn_cadastrar_funcionario = new JButton("cadastrar funcionario");
        JButton btn_listar_cliente = new JButton("listar clientes");
        JButton btn_listar_produto = new JButton("listar produto");
        JButton btn_listar_funcionario  =new JButton("listar funcionario");

        btn_cadastrar_cliente.addActionListener(e -> cadastrar_cliente());
        btn_cadastrar_produto.addActionListener(e -> cadastrar_produto());
        btn_cadastrar_funcionario.addActionListener(e -> cadastrar_funcionario());
        btn_listar_cliente.addActionListener(e -> listar_cliente());
        btn_listar_produto.addActionListener(e -> listar_produto());
        btn_listar_funcionario.addActionListener(e -> listar_funcionario());


        panel.add(btn_cadastrar_cliente);
        panel.add(btn_listar_cliente);
        panel.add(btn_cadastrar_produto);
        panel.add(btn_listar_produto);
        panel.add(btn_cadastrar_funcionario);
        panel.add(btn_listar_funcionario);



        frame.getContentPane().add(panel);
        frame.setVisible(true);



    }





    private static void cadastrar_cliente() {
        String nome = JOptionPane.showInputDialog("digite o nome do cliente");
        String cpf = JOptionPane.showInputDialog("digite o seu cpf");
        String telefone = JOptionPane.showInputDialog("digite o seu telefone");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("digite o saldo"));
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCfp(cpf);
        c.setTelefone(telefone);
        c.setSaldo(saldo);
        ebd2.adiciona_cliente(c);
        JOptionPane.showMessageDialog(null,"cliente cadastrado com sucesso");
    }

    private static void cadastrar_produto() {
        String nome = JOptionPane.showInputDialog("digite o nome do produto");
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("digite a quantidade"));
        double valor = Double.parseDouble(JOptionPane.showInputDialog("digite o valor"));
        Produto p = new Produto();
        p.setNome(nome);
        p.setQuantidade(quantidade);
        p.setValor(valor);
        ebd2.adiciona_produto(p);
        JOptionPane.showMessageDialog(null,"produto cadastrado com sucesso");
    }
    private static void cadastrar_funcionario() {
        String nome = JOptionPane.showInputDialog("digite o nome do funcionario");
        String cpf = JOptionPane.showInputDialog("digite o seu cpf");
        String telefone = JOptionPane.showInputDialog("digite o seu telefone");
        String cargo = JOptionPane.showInputDialog("digite o seu cargo");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("digite o seu salario"));

        Funcionario f = new Funcionario();
        f.setNome(nome);
        f.setCfp(cpf);
        f.setTelefone(telefone);
        f.setCargo(cargo);
        f.setSalario(salario);
        ebd2.adiciona_funcionario(f);
        JOptionPane.showMessageDialog(null,"funcionario cadastrado com sucesso");

    }
    

    private static void listar_cliente() {
        StringBuilder clientes = new StringBuilder("listas dos cleintes \n");
        for(Cliente c: ebd2.listar_cliente()){
            clientes.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(null,clientes.toString());



    }
    private static void listar_produto() {
        StringBuilder produtos = new StringBuilder("listas dos produtos \n");
        for(Produto p: ebd2.listar_produto()){
            produtos.append(p).append("\n");
        }
        JOptionPane.showMessageDialog(null,produtos.toString());



    }
    private static void listar_funcionario() {
        StringBuilder funcionarios = new StringBuilder("listas dos funcionarios \n");
        for(Funcionario f: ebd2.listar_funcionario()){
            funcionarios.append(f).append("\n");
        }
        JOptionPane.showMessageDialog(null,funcionarios.toString());



    }
}
