package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import Model.Pedido;

public class PedidoDao {

    private Connection connection;

    public PedidoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Pedido pedido) throws SQLException {
        try {
            String sql = "INSERT INTO tbpedido (idCliente, dataPedido) VALUES (?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, pedido.getIdCliente());
            stmt.setDate(2, java.sql.Date.valueOf(pedido.getDataPedido())); // formato yyyy-mm-dd

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Pedido inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Pedido:\n" + e.getMessage());
        } finally {
            connection.close();
        }
    }
}
