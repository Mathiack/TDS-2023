package main;

import javax.swing.*;

import quartos.quartosL;
import quartos.quartosO;
import servicos.servico;
import servicos.pagamento;
import servicos.reserva;
import hospedes.hospedes;

public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main() {
        super("Hotelaria");
        JFrame j = new JFrame();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        j.setUndecorated(true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnReservar = new javax.swing.JCheckBoxMenuItem();
        btnQuartosO = new javax.swing.JCheckBoxMenuItem();
        jMenu5 = new javax.swing.JMenu();
        btnVerH = new javax.swing.JCheckBoxMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu2.setText("jMenu2");

        jMenu6.setText("jMenu6");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Quarto");

        btnReservar.setSelected(true);
        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        jMenu1.add(btnReservar);

        btnQuartosO.setSelected(true);
        btnQuartosO.setText("Quartos Reservados");
        btnQuartosO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuartosOActionPerformed(evt);
            }
        });
        jMenu1.add(btnQuartosO);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Hospedes");

        btnVerH.setSelected(true);
        btnVerH.setText("Ver");
        btnVerH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerHActionPerformed(evt);
            }
        });
        jMenu5.add(btnVerH);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        reserva();
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnQuartosOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuartosOActionPerformed
        quartosO();
    }//GEN-LAST:event_btnQuartosOActionPerformed

    private void btnVerHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHActionPerformed
        verH();
    }//GEN-LAST:event_btnVerHActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }
    
    public static void quartosL() {
        JFrame j = new quartosL();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public static void quartosO() {
        JFrame j = new quartosO();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public static void verH() {
        JFrame j = new hospedes();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public static void servicos() {
        JFrame j = new servico();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public static void pagamento() {
        JFrame j = new pagamento();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public static void reserva() {
        JFrame j = new reserva();
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem btnQuartosO;
    private javax.swing.JCheckBoxMenuItem btnReservar;
    private javax.swing.JCheckBoxMenuItem btnVerH;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
