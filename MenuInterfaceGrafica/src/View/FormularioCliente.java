package View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

import Model.Categoria;
import Model.Cliente;
import DAO.CategoriaDao;
import DAO.ClienteDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FormularioCliente extends JDialog {

    private static final long serialVersionUID = 1L;

    // Definindo cores
    private static final Color corMarromEscuro = new Color(101, 67, 33);
    private static final Color corFundo = new Color(245, 240, 230);
    private static final Color corBotao = new Color(160, 120, 80);
    
    private JLabel lbNome, lbGenero, lbEstadoCivil, lbDataNasc, lbTelefone, lbEmail, lbRg, lbCpf, lbEndereco,
    lbRua, lbNumero, lbComplemento, lbBairro, lbCidade, lbEstado, lbPais, lbCep;
    private JTextField txNome, txDataNasc, txTelefone, txEmail, txRg, txCpf, txRua, txNumero, txComplemento, 
    txBairro, txCidade, txEstado, txPais, txCep;
    private JRadioButton btMasculino, btFeminino;
    private ButtonGroup generoGroup;
    private JComboBox<String> estadoCivilCombo;
    private JCheckBox ckWhatsapp;
    private JButton btSalvar;

    public FormularioCliente() {
        this.setTitle("Cadastro de Clientes");
        this.setModal(true);
        this.setSize(420, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(corFundo);

        // Nome
        lbNome = new JLabel("Nome:");
        lbNome.setBounds(10, 10, 80, 25);
        lbNome.setForeground(corMarromEscuro);
        add(lbNome);

        txNome = new JTextField();
        txNome.setBounds(100, 10, 200, 25);
        txNome.setBackground(Color.WHITE);
        add(txNome);

        // Genero
        lbGenero = new JLabel("Gênero:");
        lbGenero.setBounds(10, 50, 80, 25);
        lbGenero.setForeground(corMarromEscuro);
        add(lbGenero);

        btMasculino = new JRadioButton("Masculino");
        btMasculino.setBounds(100, 50, 100, 25);
        btMasculino.setForeground(corMarromEscuro);
        btMasculino.setBackground(corFundo);
        add(btMasculino);

        btFeminino = new JRadioButton("Feminino");
        btFeminino.setBounds(200, 50, 100, 25);
        btFeminino.setForeground(corMarromEscuro);
        btFeminino.setBackground(corFundo);
        add(btFeminino);

        generoGroup = new ButtonGroup();
        generoGroup.add(btMasculino);
        generoGroup.add(btFeminino);
        btMasculino.setSelected(true);

        // Estado Civil
        lbEstadoCivil = new JLabel("Estado Civil:");
        lbEstadoCivil.setBounds(10, 90, 80, 25);
        lbEstadoCivil.setForeground(corMarromEscuro);
        add(lbEstadoCivil);

        String[] opcoesEstadoCivil = {"Solteiro", "Casado", "ViÃºvo", "Divorciado"};
        estadoCivilCombo = new JComboBox<>(opcoesEstadoCivil);
        estadoCivilCombo.setBounds(100, 90, 120, 25);
        estadoCivilCombo.setBackground(Color.WHITE);
        add(estadoCivilCombo);

        // Data de Nascimento
        lbDataNasc = new JLabel("Data de Nascimento:");
        lbDataNasc.setBounds(10, 130, 150, 25);
        lbDataNasc.setForeground(corMarromEscuro);
        add(lbDataNasc);

        txDataNasc = new JTextField();
        txDataNasc.setBounds(160, 130, 100, 25);
        txDataNasc.setBackground(Color.WHITE);
        add(txDataNasc);

        // Telefone
        lbTelefone = new JLabel("Telefone:");
        lbTelefone.setBounds(10, 170, 80, 25);
        lbTelefone.setForeground(corMarromEscuro);
        add(lbTelefone);

        txTelefone = new JTextField();
        txTelefone.setBounds(100, 170, 120, 25);
        txTelefone.setBackground(Color.WHITE);
        add(txTelefone);


        // Email
        lbEmail = new JLabel("Email:");
        lbEmail.setBounds(10, 230, 80, 25);
        lbEmail.setForeground(corMarromEscuro);
        add(lbEmail);

        txEmail = new JTextField();
        txEmail.setBounds(100, 230, 200, 25);
        txEmail.setBackground(Color.WHITE);
        add(txEmail);

        // RG
        lbRg = new JLabel("RG:");
        lbRg.setBounds(10, 270, 80, 25);
        lbRg.setForeground(corMarromEscuro);
        add(lbRg);

        txRg = new JTextField();
        txRg.setBounds(100, 270, 100, 25);
        txRg.setBackground(Color.WHITE);
        add(txRg);

        // CPF
        lbCpf = new JLabel("CPF:");
        lbCpf.setBounds(10, 310, 80, 25);
        lbCpf.setForeground(corMarromEscuro);
        add(lbCpf);

        txCpf = new JTextField();
        txCpf.setBounds(100, 310, 100, 25);
        txCpf.setBackground(Color.WHITE);
        add(txCpf);

        // Endereço
        lbEndereco = new JLabel("Digite o seu endereço abaixo:");
        lbEndereco.setBounds(10, 340, 380, 25);
        lbEndereco.setForeground(corMarromEscuro);
        add(lbEndereco);

        lbRua = new JLabel("Rua:");
        lbRua.setBounds(10, 370, 80, 25);
        lbRua.setForeground(corMarromEscuro);
        add(lbRua);

        txRua = new JTextField();
        txRua.setBounds(100, 370, 200, 25);
        txRua.setBackground(Color.WHITE);
        add(txRua);

        lbNumero = new JLabel("Número:");
        lbNumero.setBounds(10, 410, 80, 25);
        lbNumero.setForeground(corMarromEscuro);
        add(lbNumero);

        txNumero = new JTextField();
        txNumero.setBounds(100, 410, 80, 25);
        txNumero.setBackground(Color.WHITE);
        add(txNumero);

        lbComplemento = new JLabel("Complemento:");
        lbComplemento.setBounds(10, 450, 100, 25);
        lbComplemento.setForeground(corMarromEscuro);
        add(lbComplemento);

        txComplemento = new JTextField();
        txComplemento.setBounds(120, 450, 150, 25);
        txComplemento.setBackground(Color.WHITE);
        add(txComplemento);

        lbBairro = new JLabel("Bairro:");
        lbBairro.setBounds(10, 490, 80, 25);
        lbBairro.setForeground(corMarromEscuro);
        add(lbBairro);

        txBairro = new JTextField();
        txBairro.setBounds(100, 490, 150, 25);
        txBairro.setBackground(Color.WHITE);
        add(txBairro);

        lbCidade = new JLabel("Cidade:");
        lbCidade.setBounds(10, 530, 80, 25);
        lbCidade.setForeground(corMarromEscuro);
        add(lbCidade);

        txCidade = new JTextField();
        txCidade.setBounds(100, 530, 150, 25);
        txCidade.setBackground(Color.WHITE);
        add(txCidade);

        lbEstado = new JLabel("Estado:");
        lbEstado.setBounds(10, 570, 80, 25);
        lbEstado.setForeground(corMarromEscuro);
        add(lbEstado);

        txEstado = new JTextField();
        txEstado.setBounds(100, 570, 150, 25);
        txEstado.setBackground(Color.WHITE);
        add(txEstado);

        lbPais = new JLabel("País:");
        lbPais.setBounds(10, 610, 80, 25);
        lbPais.setForeground(corMarromEscuro);
        add(lbPais);

        txPais = new JTextField();
        txPais.setBounds(100, 610, 150, 25);
        txPais.setBackground(Color.WHITE);
        add(txPais);

        lbCep = new JLabel("CEP:");
        lbCep.setBounds(10, 650, 80, 25);
        lbCep.setForeground(corMarromEscuro);
        add(lbCep);

        txCep = new JTextField();
        txCep.setBounds(100, 650, 100, 25);
        txCep.setBackground(Color.WHITE);
        add(txCep);

        // Botão
        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(150, 690, 100, 30);
        btSalvar.setBackground(corBotao);
        btSalvar.setForeground(corMarromEscuro);
        add(btSalvar);
   
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = btMasculino.isSelected() ? "Masculino" : "Feminino";

                StringBuilder dados = new StringBuilder();
                dados.append("Nome: ").append(txNome.getText())
                        .append("\n Gênero: ").append(genero)
                        .append("\n Estado Civil: ").append(estadoCivilCombo.getSelectedItem())
                        .append("\n Data de Nascimento: ").append(txDataNasc.getText())
                        .append("\n Telefone: ").append(txTelefone.getText())
                        .append("\n Email: ").append(txEmail.getText())
                        .append("\n RG: ").append(txRg.getText())
                        .append("\n CPF: ").append(txCpf.getText())
                        .append("\n Endereço:")
                        .append("\n Rua: ").append(txRua.getText())
                        .append("\n Número: ").append(txNumero.getText())
                        .append("\n Complemento: ").append(txComplemento.getText())
                        .append("\n Bairro: ").append(txBairro.getText())
                        .append("\n Cidade: ").append(txCidade.getText())
                        .append("\n Estado: ").append(txEstado.getText())
                        .append("\n País: ").append(txPais.getText())
                        .append("\n CEP: ").append(txCep.getText());

                Cliente novoCliente = new Cliente(); 

                try {
                   
                    novoCliente.setNome(txNome.getText());
                    novoCliente.setGenero(genero);
                    novoCliente.setEstadoCivil((String) estadoCivilCombo.getSelectedItem());

                   
                    String dataNascDigitada = txDataNasc.getText();
                    SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formatoSQL = new SimpleDateFormat("yyyy-MM-dd");
                    
              
                    Date dataConvertida = formatoBR.parse(dataNascDigitada); 
                    String dataFormatadaParaSQL = formatoSQL.format(dataConvertida); 

                    novoCliente.setDataNascimento(dataFormatadaParaSQL);

                    novoCliente.setTelefone(txTelefone.getText());
                    novoCliente.setEmail(txEmail.getText());
                    novoCliente.setRg(txRg.getText());
                    novoCliente.setCpf(txCpf.getText());
                    novoCliente.setRua(txRua.getText());
                    novoCliente.setNumeroEndereco(txNumero.getText());
                    novoCliente.setComplemento(txComplemento.getText());
                    novoCliente.setBairro(txBairro.getText());
                    novoCliente.setCidade(txCidade.getText());
                    novoCliente.setEstado(txEstado.getText());
                    novoCliente.setPais(txPais.getText());
                    novoCliente.setCep(txCep.getText());

                   
                    ClienteDao clienteDao = new ClienteDao();
                    clienteDao.adicionar(novoCliente);
                    
					List<Cliente> clientes = new ClienteDao().getLista();

					for(Cliente cli:clientes) {
						System.out.println(
								cli.getIdCliente() + " "+
								cli.getNome() + " "+
								cli.getGenero() + " "+
								cli.getEstadoCivil() + " "+
								cli.getDataNascimento() + " "+
								cli.getTelefone() + " "+
								cli.getEmail() + " "+
								cli.getRg() + " "+
								cli.getCpf() + " "+
								cli.getRua() + " "+
								cli.getNumeroEndereco() + " "+
								cli.getComplemento() + " "+
								cli.getBairro() + " "+
								cli.getCidade() + " "+
								cli.getPais() + " "+
								cli.getCep()
								
							);
					}
			
                    JOptionPane.showMessageDialog(FormularioCliente.this, dados.toString());

                } catch (Exception ex) { 
                    JOptionPane.showMessageDialog(FormularioCliente.this, 
                        "Erro ao salvar cliente: " + ex.getMessage());
                }
            
            }
        });
    }
}

