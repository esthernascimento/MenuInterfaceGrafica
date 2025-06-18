package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import DAO.CategoriaDao;
import Model.Categoria;

public class FormularioCategoria extends JDialog {

    private static final long serialVersionUID = 1L;

    private JLabel lbCategoria, lbDescricao;
    private JTextField txCategoria, txDescricao, txId;
    private JButton btSalvar, btBuscar, btExcluir;
    private JLabel lbId;

    private static final Color corMarromEscuro = new Color(101, 67, 33);
    private static final Color corFundo = new Color(245, 240, 230);
    private static final Color corBotao = new Color(160, 120, 80);

    public FormularioCategoria() {
        setTitle("Cadastro de Categoria");
        setModal(true);
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(corFundo);

        lbId = new JLabel("ID da Categoria:");
        lbId.setBounds(10, 10, 120, 25);
        lbId.setForeground(corMarromEscuro);
        add(lbId);

        txId = new JTextField();
        txId.setBounds(130, 10, 100, 25);
        add(txId);

        btBuscar = new JButton("Buscar");
        btBuscar.setBounds(240, 10, 100, 25);
        btBuscar.setBackground(corBotao);
        btBuscar.setForeground(corMarromEscuro);
        add(btBuscar);

        lbCategoria = new JLabel("Nome da categoria:");
        lbCategoria.setBounds(10, 50, 180, 25);
        lbCategoria.setForeground(corMarromEscuro);
        add(lbCategoria);

        txCategoria = new JTextField();
        txCategoria.setBounds(150, 50, 200, 25);
        add(txCategoria);

        lbDescricao = new JLabel("Descrição:");
        lbDescricao.setBounds(10, 100, 180, 25);
        lbDescricao.setForeground(corMarromEscuro);
        add(lbDescricao);

        txDescricao = new JTextField();
        txDescricao.setBounds(150, 100, 200, 25);
        add(txDescricao);

        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(150, 160, 90, 30);
        btSalvar.setBackground(corBotao);
        btSalvar.setForeground(corMarromEscuro);
        add(btSalvar);

        btExcluir = new JButton("Excluir");
        btExcluir.setBounds(250, 160, 90, 30);
        btExcluir.setBackground(Color.RED.darker());
        btExcluir.setForeground(Color.WHITE);
        add(btExcluir);

     
        btBuscar.addActionListener(e -> {
            int id = Integer.parseInt(txId.getText());
            CategoriaDao dao = new CategoriaDao();
            try {
                Categoria cat = dao.buscarId(id);
                if (cat != null) {
                    txCategoria.setText(cat.getNomeCategoria());
                    txDescricao.setText(cat.getDescricaoCategoria());
                    JOptionPane.showMessageDialog(null, "Categoria encontrada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Categoria não encontrada.");
                    txCategoria.setText("");
                    txDescricao.setText("");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCategoria = txCategoria.getText();
                String descricaoCategoria = txDescricao.getText();
                String idText = txId.getText().trim();

                Categoria categoria = new Categoria();
                categoria.setNomeCategoria(nomeCategoria);
                categoria.setDescricaoCategoria(descricaoCategoria);

                CategoriaDao categoriaDao = new CategoriaDao();

                try {
                    if (!idText.isEmpty()) {
                        int id = Integer.parseInt(idText);
                        Categoria existente = categoriaDao.buscarId(id);

                        if (existente != null) {
                            
                            categoria.setIdCategoria(id);
                            categoriaDao.editar(categoria);
                            JOptionPane.showMessageDialog(FormularioCategoria.this, "Categoria atualizada com sucesso!");
                        } else {
                           
                            categoriaDao.adicionar(categoria);
                            JOptionPane.showMessageDialog(FormularioCategoria.this, "Nova categoria cadastrada com sucesso!");
                        }
                    } else {
                      
                        categoriaDao.adicionar(categoria);
                        JOptionPane.showMessageDialog(FormularioCategoria.this, "Nova categoria cadastrada com sucesso!");
                    }

                    txId.setText("");
                    txCategoria.setText("");
                    txDescricao.setText("");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FormularioCategoria.this, "Erro ao salvar categoria: " + ex.getMessage());
                }
            }
        });
        
        btExcluir.addActionListener(e -> {
        	
            try {
                String idText = txId.getText().trim();

                if (!idText.isEmpty()) {
                    int resposta = JOptionPane.showConfirmDialog(
                        null,
                        "Tem certeza que deseja excluir esta categoria?",
                        "Confirmação de Exclusão",
                        JOptionPane.YES_NO_OPTION
                    );

                    if (resposta == JOptionPane.YES_OPTION) {
                        int id = Integer.parseInt(idText);
                        Categoria categoria = new Categoria();
                        categoria.setIdCategoria(id);

                        CategoriaDao dao = new CategoriaDao();
                        dao.remover(categoria);

                        JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso!");

                        txId.setText("");
                        txCategoria.setText("");
                        txDescricao.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Informe um ID para excluir.");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao excluir categoria: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido. Digite um número inteiro.");
            }
        });
    }
}