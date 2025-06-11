package View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormularioProduto extends JDialog {

    private JLabel lbProduto, lbValor, lbQuantidade, lbPesquisar;
    private JTextField txProduto, txValor, txQuantidade, txPesquisar;
    private JButton btSalvar;
    
    private static final Color corMarromEscuro = new Color(101, 67, 33);
    private static final Color corFundo = new Color(245, 240, 230);
    private static final Color corBotao = new Color(160, 120, 80);

    public FormularioProduto() {
		this.setTitle("Cadastro de Produto");
	    this.setModal(true);
	    this.setSize(400, 300);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    this.setLayout(null);
	    this.getContentPane().setBackground(corFundo);

        lbPesquisar = new JLabel("Pesquisar:");
        lbPesquisar.setBounds(10, 20, 100, 25);
        lbPesquisar.setForeground(corMarromEscuro);
        add(lbPesquisar);
        
        
        txPesquisar = new JTextField();
        txPesquisar.setBounds(120, 20, 200, 25);        
        add(txPesquisar);


        txPesquisar = new JTextField();
        txPesquisar.setBounds(120, 20, 200, 25);
        add(txPesquisar);

        lbProduto = new JLabel("Produto:");
        lbProduto.setBounds(10, 60, 100, 25);
        lbProduto.setForeground(corMarromEscuro);
        add(lbProduto);

        txProduto = new JTextField();
        txProduto.setBounds(120, 60, 200, 25);
        add(txProduto);

        lbValor = new JLabel("Valor:");
        lbValor.setBounds(10, 100, 100, 25);
        lbValor.setForeground(corMarromEscuro);
        add(lbValor);

        txValor = new JTextField();
        txValor.setBounds(120, 100, 200, 25);
        add(txValor);

        lbQuantidade = new JLabel("Quantidade:");
        lbQuantidade.setBounds(10, 140, 100, 25);
        lbQuantidade.setForeground(corMarromEscuro);
        add(lbQuantidade);

        txQuantidade = new JTextField();
        txQuantidade.setBounds(120, 140, 200, 25);
        add(txQuantidade);

        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(150, 170, 100, 30);
        btSalvar.setBackground(corBotao);
        btSalvar.setForeground(corMarromEscuro);
        add(btSalvar);
    
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produto = txProduto.getText();
                String valor = txValor.getText();
                String quantidade = txQuantidade.getText();

                JOptionPane.showMessageDialog(null,
                        "Produto: " + produto + "\nValor: " + valor + "\nQuantidade: " + quantidade);
            }
            
        });        
        
    }
}