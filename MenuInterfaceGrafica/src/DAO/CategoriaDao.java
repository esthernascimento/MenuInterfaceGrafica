package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.Categoria;

public class CategoriaDao {
    private Connection connection;

    public CategoriaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Categoria categoria) throws SQLException {
        try {
            String sql = "INSERT INTO tbcategoria (nomeCategoria, descricaoCategoria) VALUES (?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getDescricaoCategoria());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            connection.close();
        }
    }

    public Categoria buscarId(int id) throws SQLException {
        Categoria categoria = null;
        String sql = "SELECT * FROM tbcategoria WHERE idCategoria = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            categoria = new Categoria();
            categoria.setIdCategoria(rs.getInt("idCategoria"));
            categoria.setNomeCategoria(rs.getString("nomeCategoria"));
            categoria.setDescricaoCategoria(rs.getString("descricaoCategoria"));
        }

        rs.close();
        stmt.close();

        return categoria;
    }

    public List<Categoria> getLista() throws SQLException {
        try {
            List<Categoria> categorias = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM tbcategoria");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setNomeCategoria(rs.getString(2));
                categoria.setDescricaoCategoria(rs.getString(3));
                categorias.add(categoria);
            }

            rs.close();
            stmt.close();

            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            connection.close();
        }
    }

    public void remover(Categoria categoria) throws SQLException {
        try {
            String sql = "DELETE FROM tbcategoria WHERE idCategoria = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, categoria.getIdCategoria());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            connection.close();
        }
    }

    public void editar(Categoria categoria) throws SQLException {
        try {
            String sql = "UPDATE tbcategoria SET nomeCategoria=?, descricaoCategoria=? WHERE idCategoria = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getDescricaoCategoria());
            stmt.setInt(3, categoria.getIdCategoria());

            stmt.execute();
            stmt.close();

            System.out.println("Categoria atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            connection.close();
        }
    }
}