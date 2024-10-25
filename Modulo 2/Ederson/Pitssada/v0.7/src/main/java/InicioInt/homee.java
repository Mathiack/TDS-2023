package InicioInt;

import PedidoInt.IntPizza;
import java.awt.*;
import javax.swing.*;
import CardapioInt.*;
import Pedido.Database;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.table.*;

public class homee extends javax.swing.JFrame {

    private static DefaultTableModel tableModel;
    private DefaultTableModel tabelaPedidos = new DefaultTableModel(new Object[]{"ID", "Sabor", "Tamanho", "Bebida", "Cliente", "Rua", "Bairro", "Nº", "Hora", "Preço"}, 0);

    public homee() {
        //super("Início");
        initComponents();
        setStyles();
        Connection conn = Database.getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(rootPane, "Ative o Apache e o MySQL");

        }
        listaPedidos();
        setKeyboardShortcuts();

        fazP.setText("Fazer Pedido");
        fazP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));

        verCardapio.setText("Ver Cardápio");
        verCardapio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_DOWN_MASK));

        menuTamanho.setText("Novo Tamanho");
        menuTamanho.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_DOWN_MASK));

        menuSabor.setText("Novo Sabor");
        menuSabor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));

        jMenuItem2.setText("Nova Bebida");
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_DOWN_MASK));

        // Atualiza diretamente pela tabela
        tabelaPedidos.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int id = Integer.parseInt(tabelaPedidos.getValueAt(row, 0).toString());  // ID do pedido
                    String sabor = (String) tabelaPedidos.getValueAt(row, 1);
                    String tamanho = (String) tabelaPedidos.getValueAt(row, 2);
                    String bebida = (String) tabelaPedidos.getValueAt(row, 3);
                    String cliente = (String) tabelaPedidos.getValueAt(row, 4);
                    String rua = (String) tabelaPedidos.getValueAt(row, 5);
                    String bairro = (String) tabelaPedidos.getValueAt(row, 6);
                    int numero = Integer.parseInt(tabelaPedidos.getValueAt(row, 7).toString());
                    String hora = (String) tabelaPedidos.getValueAt(row, 8);
                    double preco = Double.parseDouble(tabelaPedidos.getValueAt(row, 9).toString());

                    atualizarPelaTabelaP(id, sabor, tamanho, bebida, cliente, rua, bairro, numero, hora, preco);  // Atualiza no banco
                }
            }
        });

        // Exclui linhas selecionadas
        JTpedidos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    int selectedRow = JTpedidos.getSelectedRow(); // Obtém a linha selecionada
                    if (selectedRow != -1) {
                        int id = Integer.parseInt(JTpedidos.getValueAt(selectedRow, 0).toString());  // Obtém o ID do pedido
                        excluirPelaTabelaP(id);  // Exclui do banco de dados

                        DefaultTableModel model = (DefaultTableModel) JTpedidos.getModel();
                        model.removeRow(selectedRow);  // Remove a linha da tabela

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

    private void setStyles() {
        // Define cores neutras em tons de cinza
        Color backgroundColor = new Color(245, 245, 245); // Cinza claro para o fundo principal
        Color panelBackgroundColor = new Color(230, 230, 230); // Cinza médio para os painéis
        Color tableBackgroundColor = new Color(255, 255, 255); // Branco para a tabela
        Color headerColor = new Color(200, 200, 200); // Cinza suave para o cabeçalho

        // Define fonte para títulos e conteúdo
        Font titleFont = new Font("SansSerif", Font.BOLD, 14);
        Font tableFont = new Font("SansSerif", Font.PLAIN, 12);

        // Configura painel principal e borda
        this.getContentPane().setBackground(backgroundColor);
        jPanel1.setBackground(panelBackgroundColor);
        jPanel2.setBackground(panelBackgroundColor);
        jPanel1.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Configura a tabela
        JTpedidos.setFont(tableFont);
        JTpedidos.setBackground(tableBackgroundColor);
        JTpedidos.setGridColor(new Color(210, 210, 210)); // Cinza claro para a grade da tabela
        JTpedidos.getTableHeader().setFont(titleFont);
        JTpedidos.getTableHeader().setBackground(headerColor);
        JTpedidos.getTableHeader().setForeground(Color.DARK_GRAY);

        // Barra de menu estilizada
        jMenuBar1.setBackground(headerColor);
        jMenuBar1.setBorderPainted(false);
        jMenu1.setFont(titleFont);
        jMenu3.setFont(titleFont);
    }

    private void setKeyboardShortcuts() {
        // Shortcut Alt+S para "Sabores"
        JRootPane rootPane = this.getRootPane();
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.ALT_DOWN_MASK), "openSabor");
        rootPane.getActionMap().put("openSabor", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSaborActionPerformed(e);
            }
        });

        // Shortcut Alt+T para "Tamanho"
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.ALT_DOWN_MASK), "openTamanho");
        rootPane.getActionMap().put("openTamanho", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuTamanhoActionPerformed(e);
            }
        });

        // Shortcut Alt+B para "Bebidas"
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.ALT_DOWN_MASK), "openBebida");
        rootPane.getActionMap().put("openBebida", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItem2ActionPerformed(e);
            }
        });
    }

    private static void atualizarPelaTabelaP(int id, String sabor, String tamanho, String bebida, String cliente, String rua, String bairro, int numero, String hora, double preco) {
        try (Connection conn = Database.getConnection()) {  // Obtém conexão com o banco
            String query = "UPDATE pedido SET sabor = ?, tamanho = ?, bebida = ?, nomeCliente = ?, rua = ?, bairro = ?, numero = ?, hora = ?, precoFinal = ? WHERE id_pedido = ?";  // SQL com placeholders
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, sabor);
            stmt.setString(2, tamanho);
            stmt.setString(3, bebida);
            stmt.setString(4, cliente);
            stmt.setString(5, rua);
            stmt.setString(6, bairro);
            stmt.setInt(7, numero);
            stmt.setString(8, hora);
            stmt.setDouble(9, preco);
            stmt.setInt(10, id);
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + ex.getMessage());
        }
    }

    // EXCLUI DA TABELA E DELETE NO BANCO
    private static void excluirPelaTabelaP(int id) {
        try (Connection conn = Database.getConnection()) {  // Obtém conexão com o banco
            String query = "DELETE FROM pedido WHERE id_pedido = ?";  // SQL com placeholders
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);  // Apenas o id é necessário para a exclusão
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir do banco de dados: " + ex.getMessage());
        }
    }

    public void listaPedidos() {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id_pedido, sabor, tamanho, bebida, nomeCliente, rua, bairro, numero, hora, precoFinal FROM pedido";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Limpa a tabela antes de adicionar novos dados
            tabelaPedidos.setRowCount(0);

            while (rs.next()) {
                // Recupera os dados do pedido e adiciona à tabela
                Object[] row = {
                    rs.getInt("id_pedido"),
                    rs.getString("sabor"),
                    rs.getString("tamanho"),
                    rs.getString("bebida"),
                    rs.getString("nomeCliente"),
                    rs.getString("rua"),
                    rs.getString("bairro"),
                    rs.getInt("numero"),
                    rs.getString("hora"),
                    rs.getDouble("precoFinal")
                };
                tabelaPedidos.addRow(row);  // Adiciona cada linha à tabela
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao listar pedidos: " + e.getMessage());
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTpedidos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        fazP = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        verCardapio = new javax.swing.JMenuItem();
        menuTamanho = new javax.swing.JMenuItem();
        menuSabor = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTpedidos.setModel(tabelaPedidos);
        jScrollPane1.setViewportView(JTpedidos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jMenuBar1.setBackground(new java.awt.Color(204, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("Ações");

        fazP.setText("Fazer Pedido");
        fazP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fazPActionPerformed(evt);
            }
        });
        jMenu1.add(fazP);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Cardápio");

        verCardapio.setText("Ver Cardápio");
        verCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCardapioActionPerformed(evt);
            }
        });
        jMenu3.add(verCardapio);

        menuTamanho.setText("Novo Tamanho");
        menuTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTamanhoActionPerformed(evt);
            }
        });
        jMenu3.add(menuTamanho);

        menuSabor.setText("Novo Sabor");
        menuSabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaborActionPerformed(evt);
            }
        });
        jMenu3.add(menuSabor);

        jMenuItem2.setText("Nova Bebida");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fazPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fazPActionPerformed
        JFrame j = new IntPizza();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
    }//GEN-LAST:event_fazPActionPerformed

    private void menuTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTamanhoActionPerformed
        JFrame j = new addTamanho();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
    }//GEN-LAST:event_menuTamanhoActionPerformed

    private void menuSaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaborActionPerformed
        JFrame j = new addSabor();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
    }//GEN-LAST:event_menuSaborActionPerformed

    private void verCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCardapioActionPerformed
        JFrame j = new JCardapio();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
    }//GEN-LAST:event_verCardapioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFrame j = new addBebida();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(homee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTpedidos;
    private javax.swing.JMenuItem fazP;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuSabor;
    private javax.swing.JMenuItem menuTamanho;
    private javax.swing.JMenuItem verCardapio;
    // End of variables declaration//GEN-END:variables
}
