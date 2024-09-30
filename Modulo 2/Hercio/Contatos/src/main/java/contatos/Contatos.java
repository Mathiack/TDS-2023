package contatos;

// Importing java libraries
// Importando bibliotecas do java
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Contatos {
    
    // Graphic Interface items
    // Itens da interface gráfica
    private static DefaultTableModel tableModel;
    private static JTable contactTable;
    private static JComboBox<String> categoryFilter;
    private static JTextField searchField;

    // Main frame
    // Janela principal
    static void framePrincipal() {
        // JFrame settings
        // Configurações do JFrame
        JFrame j = new JFrame("Contatos do Hércio");
        j.setSize(600, 400);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Menu Bar
        // Barra de Menu
        JMenuBar menuBar = new JMenuBar();
        j.setJMenuBar(menuBar);

        // More menus
        // Mais menus
        JMenu arqMenu = new JMenu("Arquivo");
        JMenu editMenu = new JMenu("Editar");
        JMenu ajudaMenu = new JMenu("Ajuda");
        menuBar.add(arqMenu);
        menuBar.add(editMenu);
        menuBar.add(ajudaMenu);

        // Menu items
        // Itens do menu
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

        // Tool Bar
        // Barra de Tarefas
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

        // Some Table settings
        // Algumas configurações da tabela
        String[] columnNames = {"Nome", "Telefone", "E-mail", "Endereço", "Categoria"};
        tableModel = new DefaultTableModel(columnNames, 0);
        contactTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contactTable);

        // Panel to filter by category
        // Painel pra filtrar por categoria
        JPanel filterPanel = new JPanel();
        JLabel filterLabel = new JLabel("Filtrar por Categoria:");
        categoryFilter = new JComboBox<>(new String[]{"Todos", "Amigo", "Trabalho", "Família"});
        JLabel searchLabel = new JLabel("Buscar:");
        searchField = new JTextField(15);

        filterPanel.add(filterLabel);
        filterPanel.add(categoryFilter);
        filterPanel.add(searchLabel);
        filterPanel.add(searchField);

        // Action for buttons
        // Ação para os botões
        categoryFilter.addActionListener(e -> filterContacts());
        searchField.addActionListener(e -> filterContacts());

        j.setLayout(new BorderLayout());
        j.add(toolBar, BorderLayout.NORTH);
        j.add(scrollPane, BorderLayout.CENTER);
        j.add(filterPanel, BorderLayout.SOUTH);
        j.setJMenuBar(menuBar);

        // Action for Adicionar button
        // Ação para o botão de Adicionar
        addButton.addActionListener(e -> showAddEditDialog(j, null, -1));
        
        // Action for Edit button
        // Ação para o botão de Editar
        editButton.addActionListener(e -> {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow != -1) {
                showAddEditDialog(j, selectedRow, selectedRow);
            } else {
                JOptionPane.showMessageDialog(j, "Selecione um contato para editar.");
            }
        });

        // Action for Delete button
        // Ação para o botão de Excluir
        excButton.addActionListener(e -> deleteContact());
        
        // Action for Load button
        // Ação para o botão de Carregar
        cargButton.addActionListener(e -> loadContactsFromFile());

        // Load contacts from file on startup
        loadContactsFromFile();

        // Make the JFrame visible
        // Faz o JFrame ficar visível
        j.setVisible(true);
    }

    // Function to delete contact
    // Função para deletar o contato
    private static void deleteContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            updateOutputFile();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um contato para excluir.");
        }
    }

    // Function to edit contact
    // Função para editar o contato
    private static void showAddEditDialog(JFrame parent, Integer rowIndex, int tableRow) {
        JDialog d = new JDialog(parent, rowIndex == null ? "Adicionar Contato" : "Editar Contato", true);
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

        if (rowIndex != null) {
            jTxNome.setText((String) tableModel.getValueAt(rowIndex, 0));
            jTxTelefone.setText((String) tableModel.getValueAt(rowIndex, 1));
            jTxEmail.setText((String) tableModel.getValueAt(rowIndex, 2));
            jTxEndereco.setText((String) tableModel.getValueAt(rowIndex, 3));
            jTxCategoria.setText((String) tableModel.getValueAt(rowIndex, 4));
        }

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            String[] rowData = {
                jTxNome.getText(),
                jTxTelefone.getText(),
                jTxEmail.getText(),
                jTxEndereco.getText(),
                jTxCategoria.getText()
            };
            
            if (rowIndex == null) {
                tableModel.addRow(rowData);
            } else {
                for (int i = 0; i < rowData.length; i++) {
                    tableModel.setValueAt(rowData[i], rowIndex, i);
                }
            }
            d.dispose();
            updateOutputFile();
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
        d.setLocationRelativeTo(parent);
        d.setResizable(false);
        d.setVisible(true);
    }

    // Function to update the output file (saida.txt)
    // Função para atualizar o arquivo de saída (saida.txt)
    private static void updateOutputFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.write(tableModel.getColumnName(j) + ": " + tableModel.getValueAt(i, j));
                    writer.newLine();
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to load contacts from output file
    // Função para carregar contatos do arquivo de saída
    private static void loadContactsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("saida.txt"))) {
            String line;
            String[] contactData = new String[5];
            int index = 0;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (index > 0) {
                        tableModel.addRow(contactData);
                        contactData = new String[5];
                        index = 0;
                    }
                } else {
                    String[] parts = line.split(": ");
                    if (parts.length == 2) {
                        int colIndex = switch (parts[0]) {
                            case "Nome" -> 0;
                            case "Telefone" -> 1;
                            case "E-mail" -> 2;
                            case "Endereço" -> 3;
                            case "Categoria" -> 4;
                            default -> -1;
                        };
                        if (colIndex != -1) {
                            contactData[colIndex] = parts[1];
                            index++;
                        }
                    }
                }
            }
            if (index > 0) {
                tableModel.addRow(contactData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to filter contacts from output file
    // Função para filtrar contatos do arquivo de saída
    private static void filterContacts() {
        String selectedCategory = (String) categoryFilter.getSelectedItem();
        String searchTerm = searchField.getText().toLowerCase();

        tableModel.setRowCount(0);

        try (BufferedReader reader = new BufferedReader(new FileReader("saida.txt"))) {
            String line;
            String[] contactData = new String[5];
            int index = 0;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (index > 0) {
                        String nome = contactData[0].toLowerCase();
                        String email = contactData[2].toLowerCase();
                        String categoria = contactData[4];

                        boolean matchesCategory = selectedCategory.equals("Todos") || categoria.equals(selectedCategory);
                        boolean matchesSearch = nome.contains(searchTerm) || email.contains(searchTerm);

                        if (matchesCategory && matchesSearch) {
                            tableModel.addRow(contactData);
                        }

                        contactData = new String[5]; 
                        index = 0;
                    }
                } else {
                    String[] parts = line.split(": ");
                    if (parts.length == 2) {
                        int colIndex = switch (parts[0]) {
                            case "Nome" -> 0;
                            case "Telefone" -> 1;
                            case "E-mail" -> 2;
                            case "Endereço" -> 3;
                            case "Categoria" -> 4;
                            default -> -1;
                        };
                        if (colIndex != -1) {
                            contactData[colIndex] = parts[1];
                            index++;
                        }
                    }
                }
            }
            if (index > 0) {
                String nome = contactData[0].toLowerCase();
                String email = contactData[2].toLowerCase();
                String categoria = contactData[4];

                boolean matchesCategory = selectedCategory.equals("Todos") || categoria.equals(selectedCategory);
                boolean matchesSearch = nome.contains(searchTerm) || email.contains(searchTerm);

                if (matchesCategory && matchesSearch) {
                    tableModel.addRow(contactData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        framePrincipal();
    }
}
