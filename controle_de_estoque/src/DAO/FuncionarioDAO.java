package DAO;
import model.*;
import conexao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public void adicionar_funcionario(Funcionario funcionario) {
        String sql = "insert into funcionario (nome, cpf, telefone, cargo, salario) values(?, ? , ?, ?, ?)";
        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCfp());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4,funcionario.getCargo());
            stmt.setDouble(5, funcionario.getSalario());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("erro ao adicionar o funcionario");
        }

    }


    public List<Funcionario> listar_funcionario() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "select* from funcionario";
        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCfp(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("erro ao listar funcionarios");
        }
        return funcionarios;
    }


    public void remover_funcionario(String nome) {
        String sql = "delete from funcionario where nome = ?";
        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println("erro ao remover funcionario");
        }
    }

    public Funcionario buscar_funcionario(String nome) {
        Funcionario funcionario = new Funcionario();
        String sql = "select * from funcionario where nome = ?";

        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCfp(rs.getString("cpf"));
                    funcionario.setTelefone(rs.getString("telefone"));
                    funcionario.setCargo(rs.getString("cargo"));
                    funcionario.setSalario(rs.getDouble("salario"));

                }
            }

        } catch (SQLException e) {
            System.out.println("funcionario nao cadastrado");
        }
        return funcionario;
    }
}
