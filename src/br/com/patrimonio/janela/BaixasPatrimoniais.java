package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class BaixasPatrimoniais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaixasPatrimoniais frame = new BaixasPatrimoniais();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BaixasPatrimoniais() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BaixasPatrimoniais.class.getResource("/br/com/patrimonio/imagens/icons8-baixa-prioridade-30.png")));
		setTitle("Baixas Patrimoniais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatrimonio = new JLabel("Patrimônio:");
		lblPatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPatrimonio.setBounds(10, 17, 83, 14);
		contentPane.add(lblPatrimonio);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(85, 15, 352, 22);
		contentPane.add(comboBox);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(290, 76, 89, 14);
		contentPane.add(lblUsuario);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(343, 74, 152, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblTipoBaixa = new JLabel("Tipo de Baixa:");
		lblTipoBaixa.setToolTipText("");
		lblTipoBaixa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoBaixa.setBounds(10, 72, 102, 22);
		contentPane.add(lblTipoBaixa);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(107, 74, 173, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblMotivo = new JLabel("Escreva o Motivo:");
		lblMotivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotivo.setBounds(10, 150, 141, 14);
		contentPane.add(lblMotivo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(53, 187, 461, 126);
		contentPane.add(textArea);
		
		JLabel lblValorRecuperado = new JLabel("Valor Recuperado:");
		lblValorRecuperado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorRecuperado.setBounds(0, 355, 141, 14);
		contentPane.add(lblValorRecuperado);
		
		textField = new JTextField();
		textField.setBounds(122, 354, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDocumento = new JLabel("Documento Coprobatório:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDocumento.setBounds(289, 355, 203, 19);
		contentPane.add(lblDocumento);
		
		textField_1 = new JTextField();
		textField_1.setBounds(458, 356, 173, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

	}

}
