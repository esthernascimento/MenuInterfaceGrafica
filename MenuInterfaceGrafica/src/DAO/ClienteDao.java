package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Cliente;

public class ClienteDao {

    private Connection connection;

    public ClienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Cliente cliente) {
        String sql = "INSERT INTO tbcliente (" +
                     "nomeCliente, generoCliente, estadoCivilCliente, dataNascCliente, " +
                     "telefoneCliente, emailCliente, rgCliente, cpfCliente, " +
                     "ruaCliente, numeroCliente, complementoCliente, bairroCliente, " +
                     "cidadeCliente, estadoCliente, paisCliente, cepCliente" +
                     ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null; 

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getGenero());
            stmt.setString(3, cliente.getEstadoCivil());
            stmt.setDate(4, java.sql.Date.valueOf(cliente.getDataNascimento()));
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getRg());
            stmt.setString(8, cliente.getCpf());
            stmt.setString(9, cliente.getRua());
            stmt.setString(10, cliente.getNumeroEndereco());
            stmt.setString(11, cliente.getComplemento());
            stmt.setString(12, cliente.getBairro());
            stmt.setString(13, cliente.getCidade());
            stmt.setString(14, cliente.getEstado());
            stmt.setString(15, cliente.getPais());
            stmt.setString(16, cliente.getCep());

            stmt.execute();
            stmt.close();   

            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Cliente:\n" + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar a conexão no finally: " + ex.getMessage());
            }
        }
    }
    

    public List<Cliente> getLista() throws SQLException{
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from tbcliente");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(1));
				cliente.setNome(rs.getString(2));
				cliente.setGenero(rs.getString(3));
				cliente.setEstadoCivil(rs.getString(4));
				cliente.setDataNascimento(rs.getString(5));
				cliente.setTelefone(rs.getString(6));
				cliente.setEmail(rs.getString(7));
				cliente.setRg(rs.getString(8));
				cliente.setCpf(rs.getString(9));
				cliente.setRua(rs.getString(10));
				cliente.setNumeroEndereco(rs.getString(11));
				cliente.setComplemento(rs.getString(12));
				cliente.setBairro(rs.getString(13));
				cliente.setCidade(rs.getString(14));
				cliente.setPais(rs.getString(15));
				cliente.setCep(rs.getString(16));
				
				
				clientes.add(cliente);				
			}
			
			rs.close();
			stmt.close();
			
			return clientes;
		}
		catch(SQLException e) {
			throw new RuntimeException();
		}
		finally{
			connection.close();
		}
	}
}