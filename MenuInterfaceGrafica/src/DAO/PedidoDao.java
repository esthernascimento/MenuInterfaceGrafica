package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Categoria;
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
    
    
	public List<Pedido> getLista() throws SQLException{
		try {
			List<Pedido> pedidos = new ArrayList<Pedido>();
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from tbpedido");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setIdPedido(rs.getInt(1));
				pedido.setIdCliente(rs.getInt(2));
				pedido.setDataPedido(rs.getString(3));
				
				pedidos.add(pedido);				
			}
			
			rs.close();
			stmt.close();
			
			return pedidos;
		}
		catch(SQLException e) {
			throw new RuntimeException();
		}
		finally{
			connection.close();
		}
	}
	
	
}
