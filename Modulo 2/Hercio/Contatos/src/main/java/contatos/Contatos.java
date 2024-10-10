package contatos;

// Importing java libraries
// Importando bibliotecas do java
import java.util.regex.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.net.*;


// Our class name
// Nome da nossa classe
public class Contatos {
    
    // Graphic Interface items
    // Itens da interface gráfica
    private static DefaultTableModel modelT;
    private static JTable tabela;
    private static JComboBox<String> filtroDeCategorias;
    private static JTextField campoPesquisa;

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

        // Some Table settings
        // Algumas configurações da tabela
        String[] colunasNome = {"Nome", "Telefone", "E-mail", "Endereço", "Categoria"};
        modelT = new DefaultTableModel(colunasNome, 0); // Setting the model || Configurando o model
        tabela= new JTable(modelT); // New table || Nova Tabela
        JScrollPane scrollPane = new JScrollPane(tabela);

        // Panel to filter by category
        // Painel pra filtrar por categoria
        JPanel filterPanel = new JPanel();
        JLabel filterLabel = new JLabel("Filtrar por Categoria:");
        filtroDeCategorias = new JComboBox<>(new String[]{"Todos", "Amigo", "Trabalho", "Família"}); //ComboBox with the categories || ComboBox com as categorias
        JLabel searchLabel = new JLabel("Buscar:");
        campoPesquisa = new JTextField(15);

        // Add more things of the JPanel and JLabel
        // Adiciona mais coisas do JPanel e JLabel
        filterPanel.add(filterLabel);
        filterPanel.add(filtroDeCategorias);
        filterPanel.add(searchLabel);
        filterPanel.add(campoPesquisa);

        // Action for buttons
        // Ação para os botões
        filtroDeCategorias.addActionListener(e -> filterContacts());
        campoPesquisa.addActionListener(e -> filterContacts());
        saveButton.addActionListener(e -> saveContactsToFile());

        // Setting layout and add
        j.setLayout(new BorderLayout());
        j.add(toolBar, BorderLayout.NORTH);
        j.add(scrollPane, BorderLayout.CENTER);
        j.add(filterPanel, BorderLayout.SOUTH);
        j.setJMenuBar(menuBar);

        // Action for Adicionar button
        // Ação para o botão de Adicionar
        addButton.addActionListener(e -> showAddEditDialog(j, null, -1));
        
        ajudaAction.addActionListener(e -> showAjuda());
        // Action for Edit button
        // Ação para o botão de Editar
        editButton.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();
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
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow != -1) {
            modelT.removeRow(selectedRow);
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
            jTxNome.setText((String) modelT.getValueAt(rowIndex, 0));
            jTxTelefone.setText((String) modelT.getValueAt(rowIndex, 1));
            jTxEmail.setText((String) modelT.getValueAt(rowIndex, 2));
            jTxEndereco.setText((String) modelT.getValueAt(rowIndex, 3));
            jTxCategoria.setText((String) modelT.getValueAt(rowIndex, 4));
        }

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            String nome = jTxNome.getText();
            String telefone = jTxTelefone.getText();
            String email = jTxEmail.getText();
            String endereco = jTxEndereco.getText();
            String categoria = jTxCategoria.getText();

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(d, "E-mail inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!isValidPhone(telefone)) {
                JOptionPane.showMessageDialog(d, "Telefone inválido. Formato esperado: (XX) XXXXX-XXXX", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] rowData = {nome, telefone, email, endereco, categoria};

            if (rowIndex == null) {
                modelT.addRow(rowData);  // Adiciona na tabela, mas não no arquivo
            } else {
                for (int i = 0; i < rowData.length; i++) {
                    modelT.setValueAt(rowData[i], rowIndex, i);  // Edita na tabela, mas não no arquivo
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
    
    static void showAjuda() {
        
        // Setting JFrame definitions
        // Configurando definições do JFrame
        JFrame ajudaFrame = new JFrame("Ajuda");
        ajudaFrame.setSize(400, 300);
        ajudaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ajudaFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelAjuda = new JLabel("Ajuda");
        labelAjuda.setHorizontalAlignment(SwingConstants.LEFT);
        labelAjuda.setFont(new Font("Arial", Font.PLAIN, 24));
        panel.add(labelAjuda);

        JLabel labelContato = new JLabel("Contate-nos em (xx) xxxxx-xxxx");
        labelContato.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(labelContato);

        JLabel labelLink = new JLabel("<html><a href=''>Consulte nosso repositório para mais informações</a></html>");
        //labelLink.setHorizontalAlignment(SwingConstants.CENTER);
        
        /* 
        botar o labelLink no rodapé, isto é, deixar ele bem para baixo na tela, ainda centralizado
        */
        labelLink.setVerticalAlignment(SwingConstants.BOTTOM);

        labelLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/Mathiack/TDS-2023/tree/main/Modulo%202/Hercio/Contatos"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(labelLink);

        ajudaFrame.add(panel);

        ajudaFrame.setVisible(true);
    }


    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private static boolean isValidPhone(String phone) {
        String phoneRegex = "^\\(\\d{2}\\) \\d{5}-\\d{4}$"; // Format: (XX) XXXXX-XXXX || Formato: (XX) XXXXX-XXXX
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phone).matches();
    }


    // Function to update the output file (saida.txt)
    // Função para atualizar o arquivo de saída (saida.txt)
    private static void updateOutputFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"))) {
            for (int i = 0; i < modelT.getRowCount(); i++) {
                for (int j = 0; j < modelT.getColumnCount(); j++) {
                    writer.write(modelT.getColumnName(j) + ": " + modelT.getValueAt(i, j));
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
                        modelT.addRow(contactData);
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
                modelT.addRow(contactData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to save contacts in output file
    // Função para salvar contatos no arquivo de saída
    private static void saveContactsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"))) {
            for (int i = 0; i < modelT.getRowCount(); i++) {
                for (int j = 0; j < modelT.getColumnCount(); j++) {
                    writer.write(modelT.getColumnName(j) + ": " + modelT.getValueAt(i, j));
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
    // Função para filtrar contatos do arquivo de saída
    private static void filterContacts() {
        String selectedCategory = (String) filtroDeCategorias.getSelectedItem();
        String searchTerm = campoPesquisa.getText().toLowerCase();

        modelT.setRowCount(0);

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
                            modelT.addRow(contactData);
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
                    modelT.addRow(contactData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main function that calls framePrincipal, the main frame
    // Função principal que chama o framePrincipal, a janela principal
    public static void main(String[] args) {
        // DON'T REMOVE THE FUNCTION BELLOW! ELSE OUR CODE WON'T WORK CORRECTLY 
        framePrincipal(); // NÃO REMOVA! SENÃO NÃO VOSSO CÓDIGO NÃO RODARÁ
        
    }
}
