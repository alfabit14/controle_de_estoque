package DAO;
import model.*;
import conexao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void adicionar_cliente(Cliente cliente) {
        String sql = "insert into cliente (nome, cpf, telefone, saldo) values(?, ? , ?, ?)";
        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCfp());
            stmt.setString(3, cliente.getTelefone());
            stmt.setDouble(4, cliente.getSaldo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("erro ao adicionar o cliente");
        }

    }


    public List<Cliente> listar_cliente() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "select* from cliente";
        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCfp(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSaldo(rs.getDouble("saldo"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("erro ao listar clientes");
        }
        return clientes;
    }


    public void remover_cliente(String nome) {
        String sql = "delete from cliente where nome = ?";
        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println("erro ao remover cliente");
        }
    }

    public Cliente buscar_cliente(String nome) {
        Cliente cliente = new Cliente();
        String sql = "select * from cliente where nome = ?";

        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCfp(rs.getString("cpf"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setSaldo(rs.getDouble("saldo"));

                }
            }

        } catch (SQLException e) {
            System.out.println("cliente nao cadastrado");
        }
        return cliente;
    }
}