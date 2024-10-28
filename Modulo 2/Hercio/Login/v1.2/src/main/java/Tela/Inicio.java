package Tela;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Inicio extends javax.swing.JFrame {

    /**
     * Cria um novo formulário de início.
     */
    public Inicio() {
        initComponents();
        checkDatabaseConnection();
    }

    /**
     * Verifica a conexão com o banco de dados.
     */
    private void checkDatabaseConnection() {
        try (Connection conn = Database.getConnection()) {
            if (conn == null || conn.isClosed()) {
                JOptionPane.showMessageDialog(this, "Falha na conexão com o banco de dados. Ligue o XAMPP.");
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage());
            System.exit(0);
        }
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
     * Método principal para iniciar a aplicação com o tema FlatLaf.
     */
    public static void main(String args[]) {
        // Solicita ao usuário que escolha o tema
        String theme = JOptionPane.showInputDialog(null, "Escolha o tema: 'light' ou 'dark'", "Configuração de Tema", JOptionPane.QUESTION_MESSAGE);
        setLookAndFeel(theme);

        java.awt.EventQueue.invokeLater(() -> new Inicio().setVisible(true));
    }

    /**
     * Configura o Look and Feel da aplicação.
     * @param theme o tema a ser definido ("light" para FlatLightLaf, "dark" para FlatDarkLaf)
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

    // Declaração de variáveis                     
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    // Fim da declaração de variáveis                   
}
