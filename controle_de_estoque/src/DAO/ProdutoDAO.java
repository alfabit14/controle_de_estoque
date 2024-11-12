package DAO;
import model.*;
import conexao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public void adicionar_produto(Produto produto) {
        String sql = "insert into produto (nome, quantidade, valor) values(?, ?, ?)";
        try (Connection conexao = Conexao.GeraConexao()) {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setInt(2, produto.getQuantidade());
                stmt.setDouble(3, produto.getValor());

                stmt.executeUpdate();

            }
        } catch (SQLException e) {
            System.out.println("erro ao adicionar o produto");
        }

    }


    public List<Produto> listar_produto() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select* from produto";
        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValor(rs.getDouble("valor"));

                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("erro ao listar produtos");
        }
        return produtos;
    }


    public void remover_produto(String nome) {
        String sql = "delete from produto where nome = ?";
        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println("erro ao remover produto");
        }
    }

    public Produto buscar_produto(String nome) {
        Produto produto = new Produto();
        String sql = "select * from funcionario where nome = ?";

        try (Connection conexao = Conexao.GeraConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    produto.setNome(rs.getString("nome"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                    produto.setValor(rs.getDouble("valor"));


                }
            }

        } catch (SQLException e) {
            System.out.println("produto nao cadastrado");
        }
        return produto;
    }
}
