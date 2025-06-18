package View;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioItensPedido extends JDialog {

    private static final long serialVersionUID = 1L;

    private JLabel lbProduto, lbQuantidade, lbValor;
    private JTextField txProduto, txQuantidade, txValor;
    private JButton btSalvar;
    
    private static final Color corMarromEscuro = new Color(101, 67, 33);
    private static final Color corFundo = new Color(245, 240, 230);
    private static final Color corBotao = new Color(160, 120, 80);

    public FormularioItensPedido() {
        this.setModal(true); 
        this.setSize(400, 300);
        this.setTitle("Cadastro de Itens do Pedido");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(corFundo);

        lbProduto = new JLabel("Produto:");
        lbProduto.setBounds(20, 30, 100, 25);
        lbProduto.setForeground(corMarromEscuro);
        add(lbProduto);

        txProduto = new JTextField();
        txProduto.setBounds(120, 30, 200, 25);
        add(txProduto);

        lbQuantidade = new JLabel("Quantidade:");
        lbQuantidade.setBounds(20, 70, 100, 25);
        lbQuantidade.setForeground(corMarromEscuro);
        add(lbQuantidade);

        txQuantidade = new JTextField();
        txQuantidade.setBounds(120, 70, 200, 25);
        add(txQuantidade);

        lbValor = new JLabel("Valor:");
        lbValor.setBounds(20, 110, 100, 25);
        lbValor.setForeground(corMarromEscuro);
        add(lbValor);

        txValor = new JTextField();
        txValor.setBounds(120, 110, 200, 25);
        add(txValor);

        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(150, 170, 100, 30);
        btSalvar.setBackground(corBotao);
        btSalvar.setForeground(corMarromEscuro);
        add(btSalvar);

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produto = txProduto.getText();
                String quantidade = txQuantidade.getText();
                String valor = txValor.getText();

                StringBuilder dados = new StringBuilder();
                dados.append("Produto: ").append(produto)
                     .append("\nQuantidade: ").append(quantidade)
                     .append("\nValor: ").append(valor);

                JOptionPane.showMessageDialog(FormularioItensPedido.this, dados.toString());
            }
        });
    }
}