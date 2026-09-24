package br.com.patrimonio.janela;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.Usuarios;

public class ListarUsuarios extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private JScrollPane scrollPane;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    ListarUsuarios frame = new ListarUsuarios();
                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }
            }
        });
    }

    public ListarUsuarios() {

        setTitle("Listar Usuários");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setBounds(100, 100, 748, 427);

        contentPane = new JPanel();

        contentPane.setBorder(
                new EmptyBorder(5, 5, 5, 5)
        );

        setContentPane(contentPane);

        contentPane.setLayout(null);


        // TÍTULO

        JLabel lblNewLabel = new JLabel("Listar Usuários");

        lblNewLabel.setFont(
                new Font("Tahoma", Font.BOLD, 25)
        );

        lblNewLabel.setBounds(
                20, 11, 226, 25
        );

        contentPane.add(lblNewLabel);


        // SEPARADOR

        JSeparator separator = new JSeparator();

        separator.setBounds(
                0, 41, 722, 9
        );

        contentPane.add(separator);


        // LABEL PESQUISAR

        JLabel lblNewLabel_1 =
                new JLabel("Digite Usuário:");

        lblNewLabel_1.setFont(
                new Font("Tahoma", Font.PLAIN, 15)
        );

        lblNewLabel_1.setBounds(
                10, 61, 120, 25
        );

        contentPane.add(lblNewLabel_1);


        // CAMPO DE PESQUISA

        textField = new JTextField();

        textField.setBounds(
                108, 65, 261, 20
        );

        contentPane.add(textField);

        textField.setColumns(10);


        // BOTÃO PESQUISAR

        JButton btnPesquisar =
                new JButton("Pesquisar");

        btnPesquisar.setFont(
                new Font("Tahoma", Font.BOLD, 15)
        );

        btnPesquisar.setBounds(
                389, 60, 125, 27
        );

        contentPane.add(btnPesquisar);


        // SCROLL DA TABELA

        scrollPane = new JScrollPane();

        scrollPane.setBounds(
                10, 118, 712, 259
        );

        contentPane.add(scrollPane);


        // CRIAR A TABELA PRIMEIRO

        table = new JTable();

        scrollPane.setViewportView(table);


        // CARREGAR TODOS OS USUÁRIOS

        carregarUsuarios(0);


        // AÇÃO DO BOTÃO PESQUISAR

        btnPesquisar.addActionListener(e -> {

            String pesquisa = textField.getText().trim();

            // Se estiver vazio mostra todos
            if (pesquisa.isEmpty()) {

                carregarUsuarios(0);

            } else {

                try {

                    // Aqui estamos pesquisando pelo ID
                    int id = Integer.parseInt(pesquisa);

                    carregarUsuarios(id);

                } catch (NumberFormatException erro) {

                    System.out.println(
                            "Digite um ID válido."
                    );

                }

            }

        });

    }


    // MÉTODO PARA CARREGAR OS USUÁRIOS

    private void carregarUsuarios(int id) {

        // Cabeçalho da tabela

        String colunas[] = {

                "Id",
                "Nome de Usuário",
                "E-mail",
                "Perfil",
                "Ativo",
                "Criado Em",
                "Atualizado Em"

        };


        // Modelo da JTable

        DefaultTableModel model =
                new DefaultTableModel(colunas, 0);


        // DAO de usuários

        DAOUsuario du =
                new DAOUsuario();


        // SE ID = 0, LISTA TODOS

        if (id == 0) {

            List<Usuarios> listaUsuarios =
                    du.listar();


            for (Usuarios usuario : listaUsuarios) {

                Object[] dados = {

                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getPerfil(),
                        usuario.getAtivo(),
                        usuario.getCriado_em(),
                        usuario.getAtualizado_em()

                };


                model.addRow(dados);

            }

        } else {

            // PESQUISA PELO ID

            Usuarios usuario =
                    du.listarID(id);


            if (usuario != null) {

                Object[] dados = {

                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getPerfil(),
                        usuario.getAtivo(),
                        usuario.getCriado_em(),
                        usuario.getAtualizado_em()

                };


                model.addRow(dados);

            }

        }
        
        scrollPane.setViewportView(table);

        btnPesquisar.addActionListener(e -> {
            pesquisarUsuario();
        });

        btnListarTodos.addActionListener(e -> {
            textField.setText("");
            carregarUsuarios();
        });

        textField.addActionListener(e -> {
            pesquisarUsuario();
        });

        // Carrega os dados por último
        try {
            carregarUsuarios();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                this,
                "Erro ao carregar usuários:\n" + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }


        // Colocar modelo na tabela

        table.setModel(model);

    }

}