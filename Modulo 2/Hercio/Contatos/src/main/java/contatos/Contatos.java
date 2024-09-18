package contatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Contatos {
    
    private static DefaultTableModel tableModel;
    private static JTable contactTable;
    private static JComboBox<String> categoryFilter;

    static void framePrincipal() {
        JFrame j = new JFrame("Salvar");
        j.setSize(400, 400);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();

        j.setJMenuBar(menuBar);

        JMenu arqMenu = new JMenu("Arquivo");
        JMenu editMenu = new JMenu("Editar");
        JMenu ajudaMenu = new JMenu("Ajuda");
        menuBar.add(arqMenu);
        menuBar.add(editMenu);
        menuBar.add(ajudaMenu);

        JMenuItem addAction = new JMenuItem("Adicionar");
        JMenuItem editAction = new JMenuItem("Editar");
        JMenuItem excAction = new JMenuItem("Excluir");
        JMenuItem saveAction = new JMenuItem("Salvar");
        JMenuItem cargAction = new JMenuItem("Carregar");
        JMenuItem ajudaAction = new JMenuItem("Ajuda");

        arqMenu.add(addAction);
        arqMenu.add(editAction);
        arqMenu.add(excAction);
        arqMenu.add(saveAction);
        arqMenu.add(cargAction);
        ajudaMenu.add(ajudaAction);

        JToolBar toolBar = new JToolBar();
        JButton addButton = new JButton("Adicionar");
        JButton editButton = new JButton("Editar");
        JButton excButton = new JButton("Excluir");
        JButton saveButton = new JButton("Salvar");
        JButton cargButton = new JButton("Carregar");

        toolBar.add(addButton);
        toolBar.add(editButton);
        toolBar.add(excButton);
        toolBar.add(saveButton);
        toolBar.add(cargButton);

        // Definindo modelo e tabela
        String[] columnNames = {"Nome", "Telefone", "E-mail", "Endereço", "Categoria"};
        tableModel = new DefaultTableModel(columnNames, 0);
        contactTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contactTable);

        // JPopupMenu
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("Editar"));
        popupMenu.add(new JMenuItem("Excluir"));
        
        contactTable.setComponentPopupMenu(popupMenu);

        // JPanel for filtering
        JPanel filterPanel = new JPanel();
        JLabel filterLabel = new JLabel("Filtrar por Categoria:");
        categoryFilter = new JComboBox<>(new String[]{"Todos", "Amigo", "Trabalho", "Família"});
        
        filterPanel.add(filterLabel);
        filterPanel.add(categoryFilter);
        
        // Filter functionality
        categoryFilter.addActionListener(e -> filterContacts());

        // Adicionando componentes ao frame
        j.setLayout(new BorderLayout());
        j.add(toolBar, BorderLayout.NORTH);
        j.add(scrollPane, BorderLayout.CENTER);
        j.add(filterPanel, BorderLayout.SOUTH);
        j.setJMenuBar(menuBar);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog(j, "Adicionar Contato", true);
                d.setLayout(new GridLayout(0, 2, 10, 10));

                JLabel jLbNome = new JLabel("Nome:");
                JTextField jTxNome = new JTextField();

                JLabel jLbTelefone = new JLabel("Telefone:");
                JTextField jTxTelefone = new JTextField();

                JLabel jLbEmail = new JLabel("E-mail:");
                JTextField jTxEmail = new JTextField();

                JLabel jLbEndereco = new JLabel("Endereço:");
                JTextField jTxEndereco = new JTextField();

                JLabel jLbCategoria = new JLabel("Categoria:");
                JTextField jTxCategoria = new JTextField();

                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Adiciona dados à tabela
                        String[] rowData = {
                            jTxNome.getText(),
                            jTxTelefone.getText(),
                            jTxEmail.getText(),
                            jTxEndereco.getText(),
                            jTxCategoria.getText()
                        };
                        tableModel.addRow(rowData);
                        d.dispose();
                        
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"))) {
                            String nome = jTxNome.getText();
                            String telefone = jTxTelefone.getText();
                            String email = jTxEmail.getText();
                            String endereco = jTxEndereco.getText();
                            String categoria = jTxCategoria.getText();

                            writer.write("Nome: " + nome);
                            writer.newLine();
                            writer.write("Telefone: " + telefone);
                            writer.newLine();
                            writer.write("E-mail: " + email);
                            writer.newLine();
                            writer.write("Endereço: " + endereco);
                            writer.newLine();
                            writer.write("categoria: " + categoria);
                            writer.newLine();

                        } catch (IOException i) {
                            i.printStackTrace();
                        }

                    }
                });

                d.add(jLbNome);
                d.add(jTxNome);
                d.add(jLbTelefone);
                d.add(jTxTelefone);
                d.add(jLbEmail);
                d.add(jTxEmail);
                d.add(jLbEndereco);
                d.add(jTxEndereco);
                d.add(jLbCategoria);
                d.add(jTxCategoria);
                d.add(new JLabel());
                d.add(okButton);

                d.setSize(300, 300);
                d.setLocationRelativeTo(j);
                d.setResizable(false);
                d.setVisible(true);
            }
        });

        j.setVisible(true);
    }

    private static void filterContacts() {
        String selectedCategory = (String) categoryFilter.getSelectedItem();

    }

    public static void main(String[] args) {
        framePrincipal();
    }
}

