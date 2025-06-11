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
	
	public void adicionar(Categoria categoria)throws SQLException {
		
		try {
			String sql = "insert into tbcategoria (nomeCategoria,descricaoCategoria) values(?,?)";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,categoria.getNomeCategoria());
			stmt.setString(2, categoria.getDescricaoCategoria());
			
			stmt.execute();
			stmt.close();
			
			 JOptionPane.showMessageDialog(null, "Categoria inserido com sucesso");
			
		}
		catch(SQLException e) {
			System.out.println("Erro: "+e);
		}
		finally {
			connection.close();
		}		
	}
	
	
}
