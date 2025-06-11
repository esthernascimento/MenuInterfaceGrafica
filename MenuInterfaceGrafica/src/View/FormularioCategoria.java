package View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.CategoriaDao;
import Model.Categoria;

public class FormularioCategoria extends JDialog {

    private static final long serialVersionUID = 1L;

    private JLabel lbCategoria, lbDescricao;
    private JTextField txCategoria, txDescricao;
    private JButton btSalvar;
    
    private static final Color corMarromEscuro = new Color(101, 67, 33);
    private static final Color corFundo = new Color(245, 240, 230);
    private static final Color corBotao = new Color(160, 120, 80);

    public FormularioCategoria() {
        this.setTitle("Cadastro de Categoria");
        this.setModal(true);
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(corFundo);
        
        lbCategoria = new JLabel("Nome da categoria:");
        lbCategoria.setBounds(10, 50, 180, 25);
        lbCategoria.setForeground(corMarromEscuro);
        add(lbCategoria);

        txCategoria = new JTextField();
        txCategoria.setBounds(150, 50, 200, 25);
        add(txCategoria);

        lbDescricao = new JLabel("DescriÃ§Ã£o:");
        lbDescricao.setBounds(10, 100, 180, 25);
        lbDescricao.setForeground(corMarromEscuro);
        add(lbDescricao);

        txDescricao = new JTextField();
        txDescricao.setBounds(150, 100, 200, 25);
        add(txDescricao);
        
        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(150, 160, 100, 30);
        btSalvar.setBackground(corBotao);
        btSalvar.setForeground(corMarromEscuro);
        add(btSalvar);

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCategoria = txCategoria.getText();
                String descricaoCategoria = txDescricao.getText();

                StringBuilder dados = new StringBuilder();
                dados.append("Categoria: ").append(nomeCategoria)
                     .append("\nDescrição: ").append(descricaoCategoria);

                Categoria categoria = new Categoria(); {
                	categoria.setNomeCategoria(nomeCategoria);
                	categoria.setDescricaoCategoria(descricaoCategoria);
                	
                	CategoriaDao categoriaDao = new CategoriaDao();
                	try {
						categoriaDao.adicionar(categoria);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                
                JOptionPane.showMessageDialog(FormularioCategoria.this, dados.toString());
            }
        });
    }
}
