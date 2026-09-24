package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Patrimonio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patrimonio frame = new Patrimonio();
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
	public Patrimonio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Patrimonio.class.getResource("/br/com/patrimonio/imagens/icons8-torre-de-pisa-16.png")));
		setTitle("Patrimonio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 782, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumero = new JLabel("Nº Tombamento:");
		lblNumero.setForeground(Color.BLACK);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumero.setBounds(10, 39, 132, 14);
		contentPane.add(lblNumero);
		
		textField = new JTextField();
		textField.setBounds(134, 38, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(10, 91, 77, 14);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 90, 200, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(Color.BLACK);
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescricao.setBounds(301, 261, 101, 14);
		contentPane.add(lblDescricao);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(393, 217, 332, 124);
		contentPane.add(textArea);
		
		JLabel lblCursos = new JLabel("Cursos:");
		lblCursos.setForeground(Color.BLACK);
		lblCursos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCursos.setBounds(10, 205, 65, 14);
		contentPane.add(lblCursos);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setForeground(Color.BLACK);
		lblLocal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLocal.setBounds(10, 148, 77, 14);
		contentPane.add(lblLocal);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.BLACK);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategoria.setBounds(10, 306, 101, 20);
		contentPane.add(lblCategoria);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(93, 307, 151, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus.setBounds(10, 263, 65, 14);
		contentPane.add(lblStatus);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(68, 261, 151, 22);
		contentPane.add(comboBox_3);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.RED);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.setBounds(240, 407, 206, 39);
		contentPane.add(btnCadastrar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(68, 204, 200, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(68, 147, 200, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCriadoPor = new JLabel("Criado Por:\r\n");
		lblCriadoPor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCriadoPor.setForeground(Color.BLACK);
		lblCriadoPor.setBounds(375, 66, 91, 14);
		contentPane.add(lblCriadoPor);
		
		JLabel lblCriadoEm = new JLabel("Criado Por:");
		lblCriadoEm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCriadoEm.setForeground(Color.BLACK);
		lblCriadoEm.setBounds(375, 91, 91, 14);
		contentPane.add(lblCriadoEm);
		
		JLabel lblValorAquisicao = new JLabel("Valor Aquisição:");
		lblValorAquisicao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValorAquisicao.setForeground(Color.BLACK);
		lblValorAquisicao.setBounds(375, 117, 121, 20);
		contentPane.add(lblValorAquisicao);
		
		JLabel lblDataAquisicao = new JLabel("Data Aquisição:");
		lblDataAquisicao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDataAquisicao.setBounds(375, 148, 121, 19);
		contentPane.add(lblDataAquisicao);
		
		textField_4 = new JTextField();
		textField_4.setBounds(464, 65, 214, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(464, 90, 214, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(499, 119, 179, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(499, 147, 179, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		lblNewLabel.setIcon(new ImageIcon(Patrimonio.class.getResource("/br/com/patrimonio/imagens/Windows Dev Home Wallpaper R Surface.png")));
		lblNewLabel.setBounds(0, 0, 766, 491);
		contentPane.add(lblNewLabel);

	}
}
