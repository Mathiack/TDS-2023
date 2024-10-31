

import javax.swing.*;

public class InicioL extends javax.swing.JFrame {

    /**
     * Cria uma nova janela de boas-vindas.
     * @param username o nome do usuário para exibir na mensagem de boas-vindas
     */
    public InicioL(String username) {
        initComponents();
        setWelcomeMessage(username);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Define a mensagem de boas-vindas.
     * @param username o nome do usuário a ser exibido
     */
    private void setWelcomeMessage(String username) {
        msgBoaLbl.setText("Olá, " + username + "!");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        msgBoaLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msgBoaLbl.setFont(new java.awt.Font("Segoe UI", 0, 36));
        msgBoaLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msgBoaLbl.setText("Olá");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(msgBoaLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(msgBoaLbl)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Método principal para inicializar a tela.
     * @param args argumentos da linha de comando
     */
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

        java.awt.EventQueue.invokeLater(() -> {
            new InicioL("Usuário").setVisible(true);  // Exemplo com "Usuário" como padrão
        });
    }

    // Declaração de variáveis
    private javax.swing.JLabel msgBoaLbl;
    // Fim da declaração de variáveis
}
