package CardapioInt;

import DB.Database;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

public class JCardapio extends javax.swing.JFrame {

    private static DefaultTableModel tableModel;
    private DefaultTableModel tabelaSabor = new DefaultTableModel(new Object[]{"ID", "Sabor", "Preço"}, 0);
    private DefaultTableModel tabelaTamanho = new DefaultTableModel(new Object[]{"ID", "Tamanho", "Preço"}, 0);
    private DefaultTableModel tabelaBebidas = new DefaultTableModel(new Object[]{"ID", "Bebida", "Preço", "Quantidade"}, 0);

    public JCardapio() {
        initComponents();  // Inicializa os componentes
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        listaSabores();
        listaTamanhos();
        listaBebidas();

        // Atualiza diretamente pela tabela
        tabelaSabor.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int id = Integer.parseInt(tabelaSabor.getValueAt(row, 0).toString()); // Supondo que o ID esteja na primeira coluna
                    String nome = (String) tabelaSabor.getValueAt(row, 1);
                    String preco = tabelaSabor.getValueAt(row, 2).toString();

                    atualizarPelaTabelaS(id, nome, preco);
                }
            }
        });
        tabelaTamanho.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int id = Integer.parseInt(tabelaTamanho.getValueAt(row, 0).toString()); // ID na primeira coluna
                    String nome = (String) tabelaTamanho.getValueAt(row, 1);
                    String preco = tabelaTamanho.getValueAt(row, 2).toString();

                    atualizarPelaTabelaT(id, nome, preco);
                }
            }
        });
        tabelaBebidas.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int id = Integer.parseInt(tabelaBebidas.getValueAt(row, 0).toString()); // ID na primeira coluna
                    String nome = (String) tabelaBebidas.getValueAt(row, 1);
                    String preco = tabelaBebidas.getValueAt(row, 2).toString();
                    int qntBebida = Integer.parseInt(tabelaBebidas.getValueAt(row, 3).toString());

                    atualizarPelaTabelaB(id, nome, preco, qntBebida);
                }
            }
        });

        // Seleção de linhas nas tabelas
        JTsabores.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                // Desmarcar outras tabelas
                JTtamanho.clearSelection();
                JTbebida.clearSelection();
            }
        });
        JTtamanho.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                // Desmarcar outras tabelas
                JTsabores.clearSelection();
                JTbebida.clearSelection();
            }
        });
        JTbebida.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                // Desmarcar outras tabelas
                JTsabores.clearSelection();
                JTtamanho.clearSelection();
            }
        });

        // Exclui linhas selecionadas
        JTsabores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    int selectedRow = JTsabores.getSelectedRow(); // Obtém a linha selecionada
                    if (selectedRow != -1) {
                        // Pegando o ID da linha selecionada (assumindo que o ID esteja na primeira coluna)
                        int id = Integer.parseInt(JTsabores.getValueAt(selectedRow, 0).toString()); // ID na primeira coluna
                        String nome = (String) JTsabores.getValueAt(selectedRow, 1); // Nome na segunda coluna
                        String preco = JTsabores.getValueAt(selectedRow, 2).toString(); // Preço na terceira coluna

                        // Excluindo o item do banco de dados
                        excluirPelaTabelaS(id);

                        // Removendo a linha da tabela
                        DefaultTableModel model = (DefaultTableModel) JTsabores.getModel();
                        model.removeRow(selectedRow);

                        // Exibir uma mensagem de sucesso ou atualizar a interface
                        JOptionPane.showMessageDialog(null, "Item excluído com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
                    }
                }
            }
        });
        JTtamanho.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    int selectedRow = JTtamanho.getSelectedRow(); // Obtém a linha selecionada
                    if (selectedRow != -1) {
                        // Pegando o ID da linha selecionada (assumindo que o ID esteja na primeira coluna)
                        int id = Integer.parseInt(JTtamanho.getValueAt(selectedRow, 0).toString()); // ID na primeira coluna
                        String nome = (String) JTtamanho.getValueAt(selectedRow, 1); // Nome na segunda coluna
                        String preco = JTtamanho.getValueAt(selectedRow, 2).toString(); // Preço na terceira coluna

                        // Excluindo o item do banco de dados
                        excluirPelaTabelaT(id);

                        // Removendo a linha da tabela
                        DefaultTableModel model = (DefaultTableModel) JTtamanho.getModel();
                        model.removeRow(selectedRow);

                        // Exibir uma mensagem de sucesso ou atualizar a interface
                        JOptionPane.showMessageDialog(null, "Item excluído com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
                    }
                }
            }
        });
        JTbebida.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    int selectedRow = JTbebida.getSelectedRow(); // Obtém a linha selecionada
                    if (selectedRow != -1) {
                        // Pegando o ID da linha selecionada (assumindo que o ID esteja na primeira coluna)
                        int id = Integer.parseInt(JTbebida.getValueAt(selectedRow, 0).toString()); // ID na primeira coluna
                        String nome = (String) JTbebida.getValueAt(selectedRow, 1); // Nome na segunda coluna
                        String preco = JTbebida.getValueAt(selectedRow, 2).toString(); // Preço na terceira coluna
                        int qntBebida = Integer.parseInt(JTbebida.getValueAt(selectedRow, 3).toString());

                        // Excluindo o item do banco de dados
                        excluirPelaTabelaB(id);

                        // Removendo a linha da tabela
                        DefaultTableModel model = (DefaultTableModel) JTbebida.getModel();
                        model.removeRow(selectedRow);

                        // Exibir uma mensagem de sucesso ou atualizar a interface
                        JOptionPane.showMessageDialog(null, "Item excluído com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
                    }
                }
            }
        });

        // Atalho para fechar
        JRootPane rootPane = this.getRootPane();
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK), "closeProgram");
        rootPane.getActionMap().put("closeProgram", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha o programa
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        JTtamanho1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTsabores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTtamanho = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTbebida = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        JTtamanho1.setModel(tabelaTamanho);
        jScrollPane3.setViewportView(JTtamanho1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Tamanho");

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Tamanho");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Sabores");

        JTsabores.setModel(tabelaSabor);
        jScrollPane1.setViewportView(JTsabores);

        JTtamanho.setModel(tabelaTamanho);
        jScrollPane2.setViewportView(JTtamanho);

        JTbebida.setModel(tabelaBebidas);
        jScrollPane4.setViewportView(JTbebida);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Bebidas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setStyles() {
        // Define cores neutras em tons de cinza
        Color backgroundColor = new Color(245, 245, 245); // Cinza claro para o fundo principal
        Color panelBackgroundColor = new Color(230, 230, 230); // Cinza médio para os painéis
        Color tableBackgroundColor = new Color(255, 255, 255); // Branco para a tabela
        Color headerColor = new Color(200, 200, 200); // Cinza suave para o cabeçalho

        // Define fonte para títulos e conteúdo
        Font titleFont = new Font("SansSerif", Font.BOLD, 14);
        Font tableFont = new Font("SansSerif", Font.PLAIN, 12);

        // Configura a tabela Sabores
        JTsabores.setFont(tableFont);
        JTsabores.setBackground(tableBackgroundColor);
        JTsabores.setGridColor(new Color(210, 210, 210));
        JTsabores.getTableHeader().setFont(titleFont);
        JTsabores.getTableHeader().setBackground(headerColor);
        JTsabores.getTableHeader().setForeground(Color.DARK_GRAY);

        // Configura a tabela Tamanhos
        JTtamanho.setFont(tableFont);
        JTtamanho.setBackground(tableBackgroundColor);
        JTtamanho.setGridColor(new Color(210, 210, 210));
        JTtamanho.getTableHeader().setFont(titleFont);
        JTtamanho.getTableHeader().setBackground(headerColor);
        JTtamanho.getTableHeader().setForeground(Color.DARK_GRAY);

        // Configura a tabela Bebidas
        JTbebida.setFont(tableFont);
        JTbebida.setBackground(tableBackgroundColor);
        JTbebida.setGridColor(new Color(210, 210, 210));
        JTbebida.getTableHeader().setFont(titleFont);
        JTbebida.getTableHeader().setBackground(headerColor);
        JTbebida.getTableHeader().setForeground(Color.DARK_GRAY);
    }

    // ATUALIZAÇÕES DA TABELA E UPDATES NO BANCO
    private static void atualizarPelaTabelaS(int id, String nome, String preco) {
        try (Connection conn = Database.getConnection()) {  // Obtém conexão com o banco
            String query = "UPDATE sabor SET sabor = ?, precoSabor = ? WHERE id_sabor = ?";  // SQL com placeholders
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);  // Define o valor do primeiro placeholder (sabor)
            stmt.setDouble(2, Double.parseDouble(preco));  // Converte preco para double e define o segundo placeholder
            stmt.setInt(3, id);  // Define o valor do terceiro placeholder (id)

            stmt.executeUpdate();  // Executa a query
            System.out.println("Dados atualizados no banco de dados!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + ex.getMessage());
        }
    }

    private static void atualizarPelaTabelaT(int id, String nome, String preco) {
        try (Connection conn = Database.getConnection()) {
            String query = "UPDATE tamanho SET tamanho = ?, precoTamanho = ? WHERE id_tamanho = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setDouble(2, Double.parseDouble(preco));
            stmt.setInt(3, id);

            stmt.executeUpdate();
            System.out.println("Dados atualizados no banco de dados!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + ex.getMessage());
        }
    }

    private static void atualizarPelaTabelaB(int id, String nome, String preco, int qntBebida) {
        try (Connection conn = Database.getConnection()) {
            String query = "UPDATE bebida SET bebida = ?, precoBebida = ?, qntBebida = ? WHERE id_bebida = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setDouble(2, Double.parseDouble(preco));
            stmt.setInt(3, qntBebida);
            stmt.setInt(4, id);

            stmt.executeUpdate();
            System.out.println("Dados atualizados no banco de dados!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + ex.getMessage());
        }
    }

    // EXCLUSÕES NA TABELA E DELETES NO BANCO
    private static void excluirPelaTabelaS(int id) {
        try (Connection conn = Database.getConnection()) {  // Obtém conexão com o banco
            String query = "DELETE FROM sabor WHERE id_sabor = ?";  // SQL para excluir com base no id_sabor
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);  // Define o valor do placeholder (id)

            int rowsAffected = stmt.executeUpdate();  // Executa a query e retorna o número de linhas afetadas

            if (rowsAffected > 0) {
                System.out.println("Dados excluídos do banco de dados!");
            } else {
                System.out.println("Nenhum dado foi encontrado com o ID fornecido.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir do banco de dados: " + ex.getMessage());
        }
    }

    private static void excluirPelaTabelaT(int id) {
        try (Connection conn = Database.getConnection()) {
            String query = "DELETE FROM tamanho WHERE id_tamanho = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);  // Define o valor do placeholder (id)

            int rowsAffected = stmt.executeUpdate();  // Executa a query e retorna o número de linhas afetadas

            if (rowsAffected > 0) {
                System.out.println("Dados excluídos do banco de dados!");
            } else {
                System.out.println("Nenhum dado foi encontrado com o ID fornecido.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + ex.getMessage());
        }
    }

    private static void excluirPelaTabelaB(int id) {
        try (Connection conn = Database.getConnection()) {
            String query = "DELETE FROM bebida WHERE id_bebida = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);  // Define o valor do placeholder (id)

            int rowsAffected = stmt.executeUpdate();  // Executa a query e retorna o número de linhas afetadas

            if (rowsAffected > 0) {
                System.out.println("Dados excluídos do banco de dados!");
            } else {
                System.out.println("Nenhum dado foi encontrado com o ID fornecido.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCardapio().setVisible(true);
                JFrame j = new JFrame();
                j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });
    }

    public void listaSabores() {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id_sabor, sabor, precoSabor FROM sabor";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) JTsabores.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                String id = rs.getString("id_sabor");
                String sabor = rs.getString("sabor");
                double precoSabor = rs.getDouble("precoSabor");

                model.addRow(new Object[]{id, sabor, precoSabor});
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void listaTamanhos() {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT id_tamanho, tamanho, precoTamanho FROM tamanho";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) JTtamanho.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                String id = rs.getString("id_tamanho");
                String tamanho = rs.getString("tamanho");
                double precoTamanho = rs.getDouble("precoTamanho");

                model.addRow(new Object[]{id, tamanho, precoTamanho});
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void listaBebidas() {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT id_bebida, bebida, precoBebida, qntBebida FROM bebida";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) JTbebida.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                String id = rs.getString("id_bebida");
                String bebida = rs.getString("bebida");
                double precoBebida = rs.getDouble("precoBebida");
                int qntBebida = rs.getInt("qntBebida");

                model.addRow(new Object[]{id, bebida, precoBebida, qntBebida});
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTbebida;
    private javax.swing.JTable JTsabores;
    private javax.swing.JTable JTtamanho;
    private javax.swing.JTable JTtamanho1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
