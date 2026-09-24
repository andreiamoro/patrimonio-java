package br.com.patrimonio.janela;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    // Modelo da tabela
    private DefaultTableModel model;


    // =========================================================
    // MAIN
    // =========================================================

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


    // =========================================================
    // CONSTRUTOR
    // =========================================================

    public ListarUsuarios() {

        setTitle("Listar Usuários");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 900, 500);

        setLocationRelativeTo(null);


        // =====================================================
        // PAINEL PRINCIPAL
        // =====================================================

        contentPane = new JPanel();

        contentPane.setBorder(
                new EmptyBorder(5, 5, 5, 5)
        );

        setContentPane(contentPane);

        contentPane.setLayout(null);


        // =====================================================
        // TÍTULO
        // =====================================================

        JLabel lblTitulo = new JLabel("Listar Usuários");

        lblTitulo.setFont(
                new Font("Tahoma", Font.BOLD, 25)
        );

        lblTitulo.setBounds(
                20,
                11,
                250,
                30
        );

        contentPane.add(lblTitulo);


        // =====================================================
        // SEPARADOR
        // =====================================================

        JSeparator separator = new JSeparator();

        separator.setBounds(
                0,
                50,
                884,
                10
        );

        contentPane.add(separator);


        // =====================================================
        // LABEL PESQUISA
        // =====================================================

        JLabel lblPesquisar = new JLabel("Digite o ID:");

        lblPesquisar.setFont(
                new Font("Tahoma", Font.PLAIN, 15)
        );

        lblPesquisar.setBounds(
                20,
                70,
                100,
                25
        );

        contentPane.add(lblPesquisar);


        // =====================================================
        // CAMPO PESQUISA
        // =====================================================

        textField = new JTextField();

        textField.setBounds(
                110,
                73,
                250,
                25
        );

        contentPane.add(textField);

        textField.setColumns(10);


        // =====================================================
        // BOTÃO PESQUISAR
        // =====================================================

        JButton btnPesquisar = new JButton("Pesquisar");

        btnPesquisar.setFont(
                new Font("Tahoma", Font.BOLD, 14)
        );

        btnPesquisar.setBounds(
                380,
                70,
                130,
                30
        );

        contentPane.add(btnPesquisar);


        // =====================================================
        // BOTÃO LISTAR TODOS
        // =====================================================

        JButton btnListarTodos = new JButton("Listar Todos");

        btnListarTodos.setFont(
                new Font("Tahoma", Font.BOLD, 14)
        );

        btnListarTodos.setBounds(
                530,
                70,
                140,
                30
        );

        contentPane.add(btnListarTodos);


        // =====================================================
        // SCROLL PANE
        // =====================================================

        scrollPane = new JScrollPane();

        scrollPane.setBounds(
                20,
                120,
                845,
                320
        );

        contentPane.add(scrollPane);


        // =====================================================
        // COLUNAS
        // =====================================================

        String[] colunas = {

                "Id",
                "Nome de Usuário",
                "E-mail",
                "Perfil",
                "Ativo",
                "Criado Em",
                "Atualizado Em"
        };


        // =====================================================
        // MODELO DA TABELA
        // =====================================================

        model = new DefaultTableModel(
                colunas,
                0
        ) {

            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(
                    int row,
                    int column) {

                return false;
            }
        };


        // =====================================================
        // CRIAR TABELA
        // =====================================================

        table = new JTable(model);

        table.setRowHeight(25);

        table.getTableHeader().setFont(
                new Font(
                        "Tahoma",
                        Font.BOLD,
                        13
                )
        );

        scrollPane.setViewportView(table);


        // =====================================================
        // CARREGAR USUÁRIOS QUANDO ABRIR A TELA
        // =====================================================

        carregarUsuarios();


        // =====================================================
        // BOTÃO PESQUISAR
        // =====================================================

        btnPesquisar.addActionListener(e -> {

            pesquisarUsuario();

        });


        // =====================================================
        // BOTÃO LISTAR TODOS
        // =====================================================

        btnListarTodos.addActionListener(e -> {

            textField.setText("");

            carregarUsuarios();

        });


        // =====================================================
        // ENTER NO CAMPO TAMBÉM PESQUISA
        // =====================================================

        textField.addActionListener(e -> {

            pesquisarUsuario();

        });
    }


    // =========================================================
    // LISTAR TODOS OS USUÁRIOS
    // =========================================================

    private void carregarUsuarios() {

        // Limpar tabela antes de carregar
        model.setRowCount(0);


        // Criar DAO
        DAOUsuario dao = new DAOUsuario();


        // Buscar usuários do banco
        List<Usuarios> listaUsuarios =
                dao.listar();


        // Verificação de segurança
        if (listaUsuarios == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Não foi possível carregar os usuários.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        // Percorrer usuários
        for (Usuarios usuario : listaUsuarios) {

            String ativo;

            if (usuario.getAtivo() != null
                    && usuario.getAtivo()) {

                ativo = "Sim";

            } else {

                ativo = "Não";
            }


            Object[] dados = {

                    usuario.getId(),

                    usuario.getNome(),

                    usuario.getEmail(),

                    usuario.getPerfil(),

                    ativo,

                    usuario.getCriado_em(),

                    usuario.getAtualizado_em()
            };


            // Adicionar na JTable
            model.addRow(dados);
        }
    }


    // =========================================================
    // PESQUISAR USUÁRIO PELO ID
    // =========================================================

    private void pesquisarUsuario() {

        String texto =
                textField.getText().trim();


        // Se estiver vazio
        if (texto.isEmpty()) {

            carregarUsuarios();

            return;
        }


        try {

            // Converter texto para inteiro
            int id = Integer.parseInt(texto);


            // Criar DAO
            DAOUsuario dao =
                    new DAOUsuario();


            // Pesquisar usuário
            Usuarios usuario =
                    dao.listarID(id);


            // Limpar tabela
            model.setRowCount(0);


            // Verificar se encontrou
            if (usuario != null) {

                String ativo;

                if (usuario.getAtivo() != null
                        && usuario.getAtivo()) {

                    ativo = "Sim";

                } else {

                    ativo = "Não";
                }


                Object[] dados = {

                        usuario.getId(),

                        usuario.getNome(),

                        usuario.getEmail(),

                        usuario.getPerfil(),

                        ativo,

                        usuario.getCriado_em(),

                        usuario.getAtualizado_em()
                };


                model.addRow(dados);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Usuário não encontrado.",
                        "Pesquisa",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Digite um ID válido.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}