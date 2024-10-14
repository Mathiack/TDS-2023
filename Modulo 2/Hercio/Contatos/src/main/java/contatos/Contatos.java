package contatos;

// Importing java libraries
// Importando bibliotecas do java
import java.util.regex.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;

// Our class name
// Nome da nossa classe
public class Contatos {

    // Graphic Interface items
    // Itens da interface gráfica
    private static DefaultTableModel tableModel;
    private static JTable contactTable;
    private static JComboBox<String> categoryFilter;
    private static JTextField searchField;

    private static File loadedFile = null; // this vai servi for di ZC foi carregado or need carregar one file

    // Main frame
    // Janela principal
    static void framePrincipal() {
        // JFrame settings
        // Configurações do JFrame
        JFrame j = new JFrame("Contatos");
        j.setSize(600, 400);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
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

        // Add the JMenuItems
        // Adiciona os JmenuItens
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

        // Add the buttons on the JToolBar
        // Adiciona os botões na JToolBar
        toolBar.add(addButton);
        toolBar.add(editButton);
        toolBar.add(excButton);
        toolBar.add(saveButton);
        toolBar.add(cargButton);

        
        ajudaAction.addActionListener(e -> helpFrame());

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

        // Add more things of the JPanel and JLabel
        // Adiciona mais coisas do JPanel e JLabel
        filterPanel.add(filterLabel);
        filterPanel.add(categoryFilter);
        filterPanel.add(searchLabel);
        filterPanel.add(searchField);

        // Action for buttons
        // Ação para os botões
        categoryFilter.addActionListener(e -> filterContacts());
        searchField.addActionListener(e -> filterContacts());
        saveButton.addActionListener(e -> saveContactsToFile());  // Agora o botão "Salvar" grava os contatos no arquivo

        // Setting layout and add
        j.setLayout(new BorderLayout());
        j.add(toolBar, BorderLayout.NORTH);
        j.add(scrollPane, BorderLayout.CENTER);
        j.add(filterPanel, BorderLayout.SOUTH);
        j.setJMenuBar(menuBar);

        // Action for Adicionar button
        // Ação para o botão de Adicionar
        addButton.addActionListener(e -> showAddEditDialog(j, null, -1));
        addAction.addActionListener(e -> showAddEditDialog(j, null, -1));
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

        editAction.addActionListener(e -> {
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
        excAction.addActionListener(e -> deleteContact());

        // Action for Load button
        // Ação para o botão de Carregar
        cargButton.addActionListener(e -> loadContactsFromFile());
        cargAction.addActionListener(e -> loadContactsFromFile());

        // Make the JFrame visible
        // Faz o JFrame ficar visível
        j.setVisible(true);
    }

    
    static void helpFrame() {
        JFrame j = new JFrame("Ajuda");
        j.setSize(600, 400);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setResizable(false);

        JLabel ajuda = new JLabel("Para Adicionar clique em Adicionar");
        ajuda.setBounds(20, 20, 100, 30);
        j.add(ajuda);
        
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
            String nome = jTxNome.getText();
            String telefone = jTxTelefone.getText();
            String email = jTxEmail.getText();
            String endereco = jTxEndereco.getText();
            String categoria = jTxCategoria.getText();

            if (!isValidPhone(telefone)) {
                JOptionPane.showMessageDialog(d, "Telefone inválido! Tente: (XX) XXXXX-XXXX", "Erro", JOptionPane.ERROR_MESSAGE); //janelinha de erro pois o que foi digitado no txt do telefone n ta no formato
                return;
            }
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(d, "E-mail inválido!", "Erro", JOptionPane.ERROR_MESSAGE); //janelinha de erro pois o que foi digitado no txt do email n ta no formato
                return;
            }

            String[] rowData = {nome, telefone, email, endereco, categoria};

            if (rowIndex == null) {
                tableModel.addRow(rowData);  // Adiciona na tabela, mas não no arquivo
            } else {
                for (int i = 0; i < rowData.length; i++) {
                    tableModel.setValueAt(rowData[i], rowIndex, i);  // Edita na tabela, mas não no arquivo
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

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; // padrão de emails | fica assim -> email@email.email (espero)
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private static boolean isValidPhone(String phone) {
        String phoneRegex = "^\\(\\d{2}\\) \\d{5}-\\d{4}$"; // padrão de telefones | fica assim -> (XX) XXXXX-XXXX
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phone).matches();
    }

    // Function to update the output file (saida.txt)
    // Função para atualizar o arquivo de saída (saida.txt)
    private static void updateOutputFile() {
        if (loadedFile == null) {
            // Não faz nada se não houver um arquivo carregado
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(loadedFile))) {
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
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione um arquivo (.txt)");

        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            loadedFile = fileChooser.getSelectedFile(); // Armazena o arquivo carregado
            tableModel.setRowCount(0); // remove os contatos do antigo arquivo que estava carregado

            try (BufferedReader reader = new BufferedReader(new FileReader(loadedFile))) {
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
                                case "Nome" ->
                                    0;
                                case "Telefone" ->
                                    1;
                                case "E-mail" ->
                                    2;
                                case "Endereço" ->
                                    3;
                                case "Categoria" ->
                                    4;
                                default ->
                                    -1;
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
        } else {
            System.out.println("");
        }
    }

    // Function to save contacts in output file
    // Função para salvar contatos no arquivo
    private static void saveContactsToFile() {
        File fileToSave = loadedFile;

        // Se não houver arquivo carregado, peça ao usuário para escolher um arquivo para salvar
        if (fileToSave == null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar contatos em um arquivo");

            // Abre o diálogo para seleção de arquivo
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                fileToSave = fileChooser.getSelectedFile();
                loadedFile = fileToSave; // Atualiza o arquivo carregado
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.write(tableModel.getColumnName(j) + ": " + tableModel.getValueAt(i, j));
                    writer.newLine();
                }
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Contatos salvos com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os contatos: " + e.getMessage());
        }
    }

    // Function to filter contacts from output file
    // Função para filtrar contatos a partir da categoria
    private static void filterContacts() {
        String selectedCategory = (String) categoryFilter.getSelectedItem();
        String searchTerm = searchField.getText().toLowerCase();

        tableModel.setRowCount(0);

        // ve se um arquivo foi carregado
        if (loadedFile == null) {
            JOptionPane.showMessageDialog(null, "Carregue um arquivo!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(loadedFile))) {
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
                            case "Nome" ->
                                0;
                            case "Telefone" ->
                                1;
                            case "E-mail" ->
                                2;
                            case "Endereço" ->
                                3;
                            case "Categoria" ->
                                4;
                            default ->
                                -1;
                        };
                        if (colIndex != -1) {
                            contactData[colIndex] = parts[1];
                            index++;
                        }
                    }
                }
            }

            // Adiciona o último contato, se existir
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

    // Main function that calls framePrincipal, the main frame
    // Função principal que chama o framePrincipal, a janela principal
    public static void main(String[] args) {
        framePrincipal(); // NÃO REMOVA SENÃO NÃO VOSSO CÓDIGO NÃO RODARÁ
    }
}


