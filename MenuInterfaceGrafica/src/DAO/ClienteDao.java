package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import Model.Cliente;

public class ClienteDao {

    private Connection connection;

    public ClienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Cliente cliente) {
        String sql = "INSERT INTO tbcliente (" +
                     "nomeCliente, generoCliente, estadoCivilCliente, dataNascCliente, " +
                     "telefoneCliente, whatsappCliente, emailCliente, rgCliente, cpfCliente, " +
                     "ruaCliente, numeroCliente, complementoCliente, bairroCliente, " +
                     "cidadeCliente, estadoCliente, paisCliente, cepCliente" +
                     ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null; 

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getGenero());
            stmt.setString(3, cliente.getEstadoCivil());
            stmt.setDate(4, java.sql.Date.valueOf(cliente.getDataNascimento()));
            stmt.setString(5, cliente.getTelefone());
            stmt.setBoolean(6, cliente.isAceitaWhatsapp());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getRg());
            stmt.setString(9, cliente.getCpf());
            stmt.setString(10, cliente.getRua());
            stmt.setString(11, cliente.getNumeroEndereco());
            stmt.setString(12, cliente.getComplemento());
            stmt.setString(13, cliente.getBairro());
            stmt.setString(14, cliente.getCidade());
            stmt.setString(15, cliente.getEstado());
            stmt.setString(16, cliente.getPais());
            stmt.setString(17, cliente.getCep());

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
}