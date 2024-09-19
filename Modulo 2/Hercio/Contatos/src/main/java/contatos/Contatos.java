package contatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Contatos {

    private static DefaultTableModel tableModel;
    private static JTable contactTable;
    private static JComboBox<String> filtroCategoria;

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

        // JPanel for filtering
        JPanel filterPanel = new JPanel();
        JLabel filterLabel = new JLabel("Filtrar por Categoria:");
        filtroCategoria = new JComboBox<>(new String[]{});

        filterPanel.add(filterLabel);
        filterPanel.add(filtroCategoria);

        // Filter functionality (pode ser implementada mais tarde se necessário)
        filtroCategoria.addActionListener(e -> filterContacts());

        // Adicionando componentes ao frame
        j.setLayout(new BorderLayout());
        j.add(toolBar, BorderLayout.NORTH);
        j.add(scrollPane, BorderLayout.CENTER);
        j.add(filterPanel, BorderLayout.SOUTH);
        j.setJMenuBar(menuBar);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddEditDialog(j, null, -1);
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    showAddEditDialog(j, selectedRow, selectedRow);
                } else {
                    JOptionPane.showMessageDialog(j, "Selecione um contato para editar.");
                }
            }
        });

        // Carregar contatos do arquivo ao iniciar
        loadContactsFromFile();

        j.setVisible(true);
    }

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
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                updateCategoryFilter(); // Atualiza as categorias no combo box
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
        d.setLocationRelativeTo(parent);
        d.setResizable(false);
        d.setVisible(true);
    }

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
                        int colIndex = -1;
                        switch (parts[0]) {
                            case "Nome":
                                colIndex = 0;
                                break;
                            case "Telefone":
                                colIndex = 1;
                                break;
                            case "E-mail":
                                colIndex = 2;
                                break;
                            case "Endereço":
                                colIndex = 3;
                                break;
                            case "Categoria":
                                colIndex = 4;
                                break;
                        }
                        if (colIndex != -1) {
                            contactData[colIndex] = parts[1];
                            index++;
                        }
                    }
                }
            }
            // Adiciona o último contato se necessário
            if (index > 0) {
                tableModel.addRow(contactData);
            }
            updateCategoryFilter(); // Atualiza as categorias no combo box
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateCategoryFilter() {
        filtroCategoria.removeAllItems(); // Limpa todas as categorias anteriores
        Set<String> categorias = new HashSet<>(); // Usamos um Set para evitar duplicatas

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String categoria = (String) tableModel.getValueAt(i, 4); // Categoria está na 5ª coluna
            if (categoria != null && !categoria.isEmpty()) {
                categorias.add(categoria); // Adiciona a categoria ao Set
            }
        }

        // Adiciona as categorias únicas ao combo box
        for (String categoria : categorias) {
            filtroCategoria.addItem(categoria);
        }
    }

    private static void filterContacts() {
        String selectedCategory = (String) filtroCategoria.getSelectedItem();
        // Aqui você pode implementar a lógica de filtragem se necessário
    }

    public static void main(String[] args) {
        framePrincipal();
    }
}
