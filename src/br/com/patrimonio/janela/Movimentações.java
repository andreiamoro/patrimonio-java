package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Movimentações extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movimentações frame = new Movimentações();
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
	public Movimentações() {
		setTitle("Movimentações");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Movimentações.class.getResource("/br/com/patrimonio/imagens/icons8-movimentação-manual-30.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomePatrimonio = new JLabel("Patrimônio:");
		lblNomePatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomePatrimonio.setBounds(10, 11, 82, 14);
		contentPane.add(lblNomePatrimonio);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(87, 9, 172, 22);
		contentPane.add(comboBox);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(280, 13, 60, 14);
		contentPane.add(lblUsuario);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(335, 9, 187, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblTipoMovimentacao = new JLabel("Tipo de Movimentação:");
		lblTipoMovimentacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoMovimentacao.setBounds(10, 56, 172, 22);
		contentPane.add(lblTipoMovimentacao);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(169, 58, 283, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblResponsavelDestino = new JLabel("Responsável Destino:");
		lblResponsavelDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResponsavelDestino.setBounds(10, 107, 157, 22);
		contentPane.add(lblResponsavelDestino);
		
		textField = new JTextField();
		textField.setBounds(150, 110, 298, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDataPrevista = new JLabel("Data Prevista de Retorno:");
		lblDataPrevista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataPrevista.setBounds(10, 163, 172, 14);
		contentPane.add(lblDataPrevista);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 162, 130, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDataRetorno = new JLabel("Data Efetiva de Retorno:");
		lblDataRetorno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataRetorno.setBounds(319, 163, 172, 14);
		contentPane.add(lblDataRetorno);
		
		textField_2 = new JTextField();
		textField_2.setBounds(481, 162, 146, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblObservacoes = new JLabel("Observações:");
		lblObservacoes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblObservacoes.setBounds(10, 198, 108, 19);
		contentPane.add(lblObservacoes);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 228, 613, 140);
		contentPane.add(textArea);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(243, 389, 157, 39);
		contentPane.add(btnCadastrar);

	}
}
