package Tela;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        checkDatabaseConnection();
        setWindowIcon();
    }

    private void checkDatabaseConnection() {
        Connection conn = Database.getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Ligue o XAMPP");
            System.exit(0);
        }
    }

    private void setWindowIcon() {
        // Future icon implementation, if needed
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 24));
        lblTitle.setText("Vamos lá!");

        lblSubtitle.setText("Faça seu cadastro ou login para iniciar");

        btnLogin.setBackground(new java.awt.Color(0, 153, 102));
        btnLogin.setText("Login");
        btnLogin.addActionListener(evt -> openLogin());

        btnCadastro.setBackground(new java.awt.Color(0, 153, 102));
        btnCadastro.setText("Cadastro");
        btnCadastro.addActionListener(evt -> openCadastro());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(142, 142, 142)
                    .addComponent(lblTitle))
                .addGroup(layout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addComponent(btnCadastro)
                    .addGap(44, 44, 44)
                    .addComponent(btnLogin))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(lblSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(71, 71, 71)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }

    private void openLogin() {
        JFrame loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.setLocationRelativeTo(null);
    }

    private void openCadastro() {
        JFrame cadastroFrame = new Cadastro();
        cadastroFrame.setVisible(true);
        cadastroFrame.setLocationRelativeTo(null);
    }

    /**
     * Main method to start the application with FlatLaf theme
     */
    public static void main(String args[]) {
        setLookAndFeel("light");  // Change to "dark" for FlatDarkLaf

        java.awt.EventQueue.invokeLater(() -> new Inicio().setVisible(true));
    }

    /**
     * Configures the Look and Feel for the application.
     * @param theme the theme to set ("light" for FlatLightLaf, "dark" for FlatDarkLaf)
     */
    private static void setLookAndFeel(String theme) {
        try {
            if ("dark".equalsIgnoreCase(theme)) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration                     
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration                   
}
