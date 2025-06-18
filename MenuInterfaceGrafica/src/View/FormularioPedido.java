package View;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import DAO.CategoriaDao;
import DAO.PedidoDao;
import Model.Categoria;
import Model.Pedido;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPedido extends JDialog {

    private static final long serialVersionUID = 1L;

    private JLabel lbCliente, lbData;
    private JTextField txCliente, txData;
    private JButton btSalvar;

    private static final Color corMarromEscuro = new Color(101, 67, 33);
    private static final Color corFundo = new Color(245, 240, 230);
    private static final Color corBotao = new Color(160, 120, 80);

    public FormularioPedido() {
        this.setModal(true);
        this.setSize(400, 250);
        this.setTitle("Cadastro de Pedido");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(corFundo);

        lbCliente = new JLabel("Cliente:");
        lbCliente.setBounds(20, 30, 100, 25);
        lbCliente.setForeground(corMarromEscuro);
        add(lbCliente);

        txCliente = new JTextField();
        txCliente.setBounds(120, 30, 200, 25);
        add(txCliente);

        lbData = new JLabel("Data:");
        lbData.setBounds(20, 70, 100, 25);
        lbData.setForeground(corMarromEscuro);
        add(lbData);

        txData = new JTextField();
        txData.setBounds(120, 70, 200, 25);
        add(txData);

        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(150, 130, 100, 30);
        btSalvar.setBackground(corBotao);
        btSalvar.setForeground(corMarromEscuro);
        add(btSalvar);

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cliente = txCliente.getText();  
                String data = txData.getText();        

                StringBuilder dados = new StringBuilder();
                dados.append("Cliente: ").append(cliente)
                     .append("\nData do Pedido: ").append(data);

                Pedido pedido = new Pedido(); {
                    try {
                        // conversão de String pra int
                        int idCliente = Integer.parseInt(cliente);

                        // conversão da data de "dd/MM/yyyy" → "yyyy-MM-dd"
                        SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat formatoSQL = new SimpleDateFormat("yyyy-MM-dd");
                        Date dataConvertida = formatoBR.parse(data);
                        String dataFormatada = formatoSQL.format(dataConvertida);

                        pedido.setIdCliente(idCliente);
                        pedido.setDataPedido(dataFormatada);

                        PedidoDao pedidoDao = new PedidoDao();
                        pedidoDao.adicionar(pedido);
                        
                        List<Pedido> pedidos = new PedidoDao().getLista();

						for(Pedido ped:pedidos) {
							System.out.println(
									ped.getIdPedido()  + " "+
									ped.getIdPedido()  + " "+
									ped.getDataPedido()
								);
						}

                        JOptionPane.showMessageDialog(FormularioPedido.this, dados.toString());

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(FormularioPedido.this, 
                            "Erro ao salvar pedido: " + ex.getMessage());
                    }
                }
            }
        });
    }
}

