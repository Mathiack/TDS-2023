package InicioInt;

import PedidoInt.IntPizza;
import java.awt.*;
import javax.swing.*;
import CardapioInt.*;
import Pedido.Database;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class homee extends javax.swing.JFrame {

    private static DefaultTableModel tableModel;
    private DefaultTableModel tabelaPedidos = new DefaultTableModel(new Object[]{"ID", "Sabor", "Tamanho", "Bebida", "Cliente", "Rua", "Bairro", "Nº", "Hora", "Preço"}, 0);
    
    public homee() {
        super("Início");
        initComponents();
        //setSize(700, 600);
        //setExtendedState(MAXIMIZED_BOTH); //<< --- Maximiza
        Connection conn = Database.getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(rootPane,
                    "Vosso XAMPP não encontra-se ativo no momento presente.\n"
                    + "Tua aplicação pode não funcionar de acordo com\n"
                    + "às especificações incluídas na documentação.");

        }
        listaPedidos();

        // Atualiza diretamente pela tabela
        tabelaPedidos.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int id = Integer.parseInt(tabelaPedidos.getValueAt(row, 0).toString());
                    String sabor = (String) tabelaPedidos.getValueAt(row, 1);
                    String tamanho = (String) tabelaPedidos.getValueAt(row, 2);
                    String bebida = (String) tabelaPedidos.getValueAt(row, 3);
                    String cliente = (String) tabelaPedidos.getValueAt(row, 4);
                    String rua = (String) tabelaPedidos.getValueAt(row, 5);
                    String bairro = (String) tabelaPedidos.getValueAt(row, 6);
                    int numero = (int) tabelaPedidos.getValueAt(row, 7);
                    String hora = (String) tabelaPedidos.getValueAt(row, 8);
                    double preco = (double) tabelaPedidos.getValueAt(row, 9);

                    atualizarPelaTabelaP(id, sabor, tamanho, bebida, cliente, rua, bairro, numero, hora, preco);
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
                        // Pegando o ID da linha selecionada (assumindo que o ID esteja na primeira coluna)
                        int id = Integer.parseInt(JTpedidos.getValueAt(selectedRow, 0).toString());
                        String sabor = (String) JTpedidos.getValueAt(selectedRow, 1);
                        String tamanho = (String) JTpedidos.getValueAt(selectedRow, 2);
                        String bebida = (String) JTpedidos.getValueAt(selectedRow, 3);
                        String cliente = (String) JTpedidos.getValueAt(selectedRow, 4);
                        String rua = (String) JTpedidos.getValueAt(selectedRow, 5);
                        String bairro = (String) JTpedidos.getValueAt(selectedRow, 6);
                        int numero = (int) JTpedidos.getValueAt(selectedRow, 7);
                        String hora = (String) JTpedidos.getValueAt(selectedRow, 8);
                        double preco = (double) JTpedidos.getValueAt(selectedRow, 9);

                        // Excluindo o item do banco de dados
                        excluirPelaTabelaP(id, sabor, tamanho, bebida, cliente, rua, bairro, numero, hora, preco);

                        // Removendo a linha da tabela
                        DefaultTableModel model = (DefaultTableModel) JTpedidos.getModel();
                        model.removeRow(selectedRow);

                        // Exibir uma mensagem de sucesso ou atualizar a interface
                        JOptionPane.showMessageDialog(null, "Item excluído com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
                    }
                }
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
    private static void excluirPelaTabelaP(int id, String sabor, String tamanho, String bebida, String cliente, String rua, String bairro, int numero, String hora, double preco) {
        try (Connection conn = Database.getConnection()) {  // Obtém conexão com o banco
            String query = "DELETE FROM pedido WHERE id_pedido = ?";  // SQL com placeholders
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            stmt.setString(2, sabor);
            stmt.setString(3, tamanho);
            stmt.setString(4, bebida);
            stmt.setString(5, cliente);
            stmt.setString(6, rua);
            stmt.setString(7, bairro);
            stmt.setInt(8, numero);
            stmt.setString(9, hora);
            stmt.setDouble(10, preco);
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + ex.getMessage());
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

            // Use o modelo tabelaPedidos diretamente
            tabelaPedidos.setRowCount(0);  // Limpa a tabela antes de adicionar novos dados

            while (rs.next()) {
                // Recupera os dados da consulta
                String id = rs.getString("id_pedido");
                String sabor = rs.getString("sabor");
                String tamanho = rs.getString("tamanho");
                String bebida = rs.getString("bebida");
                String cliente = rs.getString("nomeCliente");
                String rua = rs.getString("rua");
                String bairro = rs.getString("bairro");
                int numero = rs.getInt("numero");
                String hora = rs.getString("hora");
                Double preco = rs.getDouble("precoFinal");

                // Adiciona a linha ao modelo da tabela
                tabelaPedidos.addRow(new Object[]{id, sabor, tamanho, bebida, cliente, rua, bairro, numero, hora, preco});
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 674, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

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
