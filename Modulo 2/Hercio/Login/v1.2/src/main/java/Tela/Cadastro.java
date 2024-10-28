package Tela;

import java.sql.*;
import java.util.regex.*;
import javax.swing.*;

public class Cadastro extends javax.swing.JFrame {

    public Cadastro() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        labelLogin = new javax.swing.JLabel();
        usuarioJtx = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomeJtx = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emailJtx = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        senhaJtx = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cadastrarBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        entreLog = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelLogin.setFont(new java.awt.Font("Segoe UI", 0, 36));
        labelLogin.setText("Cadastro");

        jLabel1.setText("Usuário");
        jLabel2.setText("Nome");
        jLabel3.setText("E-mail");
        jLabel4.setText("Senha");

        cadastrarBtn.setBackground(new java.awt.Color(153, 102, 255));
        cadastrarBtn.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarBtn.setText("Cadastrar");
        cadastrarBtn.addActionListener(evt -> cadastrarBtnActionPerformed());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Já tem uma conta?");
        
        entreLog.setBackground(new java.awt.Color(153, 102, 255));
        entreLog.setForeground(new java.awt.Color(255, 255, 255));
        entreLog.setText("Entre");
        entreLog.addActionListener(evt -> entreLogActionPerformed());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(entreLog)
                    .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(43, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(entreLog))
                    .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usuarioJtx, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nomeJtx, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailJtx, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(senhaJtx, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(cadastrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(168, 168, 168)
                            .addComponent(labelLogin)))
                    .addContainerGap(168, Short.MAX_VALUE))
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(usuarioJtx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nomeJtx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(emailJtx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(senhaJtx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(cadastrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void cadastrarBtnActionPerformed() {
        String usuario = usuarioJtx.getText();
        String nome = nomeJtx.getText();
        String email = emailJtx.getText();
        String senha = senhaJtx.getText();

        if (!verificarCamposPreenchidos(usuario, nome, email, senha)) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos!");
            return;
        }

        if (!validarEmail(email)) return;
        if (!validarSenha(senha)) return;

        if (cadastrar(usuario, nome, email, senha)) {
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
            this.dispose();
        }
    }

    private void entreLogActionPerformed() {
        JFrame loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.setLocationRelativeTo(null);
    }

    private static boolean cadastrar(String usuario, String nome, String email, String senha) {
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO cadastro(usuario, nome, email, senha) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, usuario);
            stmt.setString(2, nome);
            stmt.setString(3, email);
            stmt.setString(4, senha);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex.getMessage());
            return false;
        }
    }

    private boolean verificarCamposPreenchidos(String usuario, String nome, String email, String senha) {
        return !usuario.isEmpty() && !nome.isEmpty() && !email.isEmpty() && !senha.isEmpty();
    }

    private boolean validarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!Pattern.compile(emailRegex).matcher(email).matches()) {
            JOptionPane.showMessageDialog(this, "Formato de email inválido. Use o formato: exemplo@dominio.com");
            return false;
        }
        return true;
    }

    private boolean validarSenha(String senha) {
        if (senha.length() < 8 || !Pattern.compile("[A-Za-z]").matcher(senha).find() ||
            !Pattern.compile("[0-9]").matcher(senha).find()) {
            JOptionPane.showMessageDialog(this, "A senha deve ter pelo menos 8 caracteres, com letras e números.");
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new Cadastro().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton cadastrarBtn;
    private javax.swing.JTextField emailJtx;
    private javax.swing.JButton entreLog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JTextField nomeJtx;
    private javax.swing.JTextField senhaJtx;
    private javax.swing.JTextField usuarioJtx;
    // End of variables declaration
}
