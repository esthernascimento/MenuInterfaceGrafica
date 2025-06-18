package View;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;


public class SobreDesenvolvedores extends JDialog {

    private static final long serialVersionUID = 1L;

    private static final Color corMarromEscuro = new Color(101, 67, 33);
    private static final Color corFundo = new Color(245, 240, 230);
    private static final Color corBotao = new Color(160, 120, 80);

    private JLabel lbFoto1, lbNome1, lbFoto2, lbNome2;
    private ImageIcon img1, img2;

    public SobreDesenvolvedores() {
        this.setTitle("Sobre os Desenvolvedores");
        this.setModal(true);
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(corFundo);

        img1 = new ImageIcon("src/img/esther.jpg");
        Image imgRed1 = img1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        lbFoto1 = new JLabel(new ImageIcon(imgRed1));
        lbFoto1.setBounds(30, 30, 80, 80);
        add(lbFoto1);

        lbNome1 = new JLabel("Esther Nascimento - esther@gmail.com");
        lbNome1.setBounds(130, 55, 300, 25);
        lbNome1.setForeground(corMarromEscuro);
        add(lbNome1);

        img2 = new ImageIcon("src/img/julia.jpg");
        Image imgRed2 = img2.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        lbFoto2 = new JLabel(new ImageIcon(imgRed2));
        lbFoto2.setBounds(30, 150, 80, 80);
        add(lbFoto2);

        lbNome2 = new JLabel("Júlia Nogueira - julia@gmail.com");
        lbNome2.setBounds(130, 175, 300, 25);
        lbNome2.setForeground(corMarromEscuro);
        add(lbNome2);
    }
}