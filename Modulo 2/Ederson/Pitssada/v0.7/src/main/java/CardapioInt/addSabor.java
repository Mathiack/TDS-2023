package CardapioInt;

import DB.Database;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class addSabor extends javax.swing.JFrame {

    public addSabor() {
        JFrame j = new JFrame();
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
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

        inputPrecoB2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAddSabor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inputSabor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputPrecoS = new javax.swing.JTextField();

        inputPrecoB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPrecoB2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Quantidade");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddSabor.setBackground(new java.awt.Color(204, 0, 0));
        btnAddSabor.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSabor.setText("Adicionar Sabor");
        btnAddSabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaborActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Novo Sabor");

        inputSabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSaborActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Preço");

        inputPrecoS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPrecoSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddSabor, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(inputPrecoS))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputPrecoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnAddSabor)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputSaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSaborActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSaborActionPerformed

    private void btnAddSaborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaborActionPerformed
        Integer print = JOptionPane.showConfirmDialog(rootPane,
            "Deseja adicionar esse sabor?"
        );
        if (print == JOptionPane.YES_OPTION ) {
            JOptionPane.showMessageDialog(rootPane, "Sabor Adicionado");
            inserirSabor();

        } else if (print == JOptionPane.NO_OPTION || print == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(rootPane, "Sabor Não Adicionado");
        }
    }//GEN-LAST:event_btnAddSaborActionPerformed

    private void inputPrecoSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPrecoSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPrecoSActionPerformed

    private void inputPrecoB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPrecoB2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPrecoB2ActionPerformed

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
            java.util.logging.Logger.getLogger(addSabor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addSabor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addSabor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addSabor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addSabor().setVisible(true);
            }
        });
    }
    
    public void inserirSabor() {
        String sabor = inputSabor.getText();
        
        String precoSa = inputPrecoS.getText();
        double precoS = Double.parseDouble(precoSa);
        
        Connection conn = Database.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO sabor(sabor, precoSabor) VALUES (?, ?)");
            
            stmt.setString(1, sabor);
            stmt.setDouble(2, precoS);
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(addSabor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSabor;
    private javax.swing.JTextField inputPrecoB2;
    private javax.swing.JTextField inputPrecoS;
    private javax.swing.JTextField inputSabor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}