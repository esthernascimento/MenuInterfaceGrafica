package View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;

    private static final Color corMarromEscuro = new Color(101, 67, 33); 
    private static final Color corFundo = new Color(245, 240, 230);   

	public Menu() {

		this.setSize(800, 600);
		this.setTitle("Sistema de Gestão - Menu Principal");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		this.getContentPane().setBackground(new Color(245, 240, 230));

		JMenu arq = new JMenu("Arquivo");
        arq.setForeground(corMarromEscuro);

		JMenu cad = new JMenu("Cadastrar");
        cad.setForeground(corMarromEscuro);

		JMenu aju = new JMenu("Ajuda");
        aju.setForeground(corMarromEscuro);

		JMenuItem sair = new JMenuItem("Sair");
		JMenuItem produto = new JMenuItem("Produto");
		JMenuItem cliente = new JMenuItem("Cliente");
		JMenuItem categoria = new JMenuItem("Categoria");
		JMenuItem pedido = new JMenuItem("Pedido");
		JMenuItem itensPedido = new JMenuItem("Itens do Pedido");
		JMenuItem sobre = new JMenuItem("Sobre");

		arq.add(sair);
		cad.add(produto);
		cad.add(cliente);
		cad.add(categoria);
		cad.add(pedido);
		cad.add(itensPedido);
		aju.add(sobre);

		JMenuBar bar = new JMenuBar();
		
		// COR DA BARRA DE MENU (FUNDO DA NAVBAR) - AGORA COM corFundo (BEGE CLARO)
		bar.setBackground(corFundo); 
	
		setJMenuBar(bar);
		bar.add(arq);
		bar.add(cad);
		bar.add(aju);

		sair.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			}
		);

		produto.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					FormularioProduto formularioproduto = new FormularioProduto();
					formularioproduto.setVisible(true);
				}
			}
		);

		cliente.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					FormularioCliente formulariocliente = new FormularioCliente();
					formulariocliente.setVisible(true);
				}
			}
		);

		categoria.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					FormularioCategoria formulariocategoria = new FormularioCategoria();
					formulariocategoria.setVisible(true);
				}
			}
		);

		pedido.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					FormularioPedido formulariopedido = new FormularioPedido();
					formulariopedido.setVisible(true);
				}
			}
		);

		itensPedido.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					FormularioItensPedido formularioitens = new FormularioItensPedido();
					formularioitens.setVisible(true);
				}
			}
		);

		sobre.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						SobreDesenvolvedores telaSobre = new SobreDesenvolvedores();
						telaSobre.setVisible(true);
					}
				}
			);

		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Menu();
	}
}