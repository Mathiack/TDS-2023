package PedidoInt;

import InicioInt.homee;
import DB.Database;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;

public class IntPizza extends javax.swing.JFrame {

    public double precoSabor = 0;
    public double precoTamanho = 0;
    public double precoBebida = 0;
    public double precoFinal;

    public IntPizza() {
        super("Pedido");
        JFrame j = new JFrame();
        j.setLocationRelativeTo(null);
        j.setUndecorated(true);
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        listaSabores();
        listaTamanhos();
        listaBebidas();
        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        comboTamanho = new javax.swing.JComboBox<>();
        comboSabor = new javax.swing.JComboBox<>();
        comboBebida = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();
        clienteNome = new javax.swing.JLabel();
        rua = new javax.swing.JLabel();
        bairro = new javax.swing.JLabel();
        nCasa = new javax.swing.JLabel();
        inputNumeroCasa = new javax.swing.JTextField();
        inputBairro = new javax.swing.JTextField();
        inputRua = new javax.swing.JTextField();
        inputNome = new javax.swing.JTextField();
        hora = new javax.swing.JLabel();
        inputHora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboTamanho.setSelectedItem(null);

        comboSabor.setSelectedItem(null);

        comboBebida.setSelectedItem(null);

        jLabel1.setText("Tamanho");

        jLabel2.setText("Bebidas");

        jLabel3.setText("Sabor");

        enviar.setBackground(new java.awt.Color(255, 51, 51));
        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        clienteNome.setText("Cliente");

        rua.setText("Rua");

        bairro.setText("Bairro");

        nCasa.setText("Nº");

        hora.setText("Hora");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setText("Fazer Pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clienteNome)
                            .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(rua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(inputRua, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bairro)
                                .addGap(165, 165, 165))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(inputBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboSabor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(comboBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputHora, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(179, 179, 179)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteNome)
                    .addComponent(rua)
                    .addComponent(bairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nCasa)
                    .addComponent(hora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        print();
    }//GEN-LAST:event_enviarActionPerformed

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
            java.util.logging.Logger.getLogger(IntPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntPizza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bairro;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel clienteNome;
    private javax.swing.JComboBox<String> comboBebida;
    private javax.swing.JComboBox<String> comboSabor;
    private javax.swing.JComboBox<String> comboTamanho;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel hora;
    private javax.swing.JTextField inputBairro;
    private javax.swing.JTextField inputHora;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputNumeroCasa;
    private javax.swing.JTextField inputRua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel nCasa;
    private javax.swing.JLabel rua;
    // End of variables declaration//GEN-END:variables

    public void print() {
        String tamanho = comboTamanho.getSelectedItem().toString();
        String sabor = comboSabor.getSelectedItem().toString();
        String bebida = comboBebida.getSelectedItem().toString();

        //    NOMEC PARA NOME_CLIENTE
        String nomeC = inputNome.getText();
        String nome_Cliente = nomeC;

        //    RUA PARA ENDERÇO
        String rua = inputRua.getText();
        String endereco = rua;

        String bairro = inputBairro.getText();
        int nCasa = Integer.parseInt(inputNumeroCasa.getText());
        String horaP = inputHora.getText();
        precoFinal = precoTamanho + precoSabor + precoBebida;

        Integer print = JOptionPane.showConfirmDialog(rootPane,
                "-------------------------------\n"
                + "Cliente: " + nomeC + "\n"
                + "Rua: " + rua + "\n"
                + "Bairro: " + bairro + "\n"
                + "Número Casa: " + nCasa + "\n"
                + "Hora: " + horaP + "\n"
                + "-------------------------------\n"
                + "PEDIDOS\n"
                + "Sabor: " + sabor + "\n"
                + "Tamanho: " + tamanho + "\n"
                + "Bebida: " + bebida + "\n"
                + "-------------------------------\n"
                + "PREÇO\n"
                + "Total: " + precoFinal + "\n"
                + "-------------------------------\n"
        );

        if (print == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(rootPane, "Fasido");
            enviarPedido();
        } else if (print == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(rootPane, "Beta");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Beta");
        }
    }

    public void listaSabores() {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id_sabor, sabor, precoSabor FROM sabor";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboSabor.getModel();

            model.removeAllElements();

            while (rs.next()) {
                String sabor = rs.getString("sabor");
                precoSabor = rs.getDouble("precoSabor");
                model.addElement(sabor);
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
            String sql = "SELECT id_tamanho, tamanho, precoTamanho FROM tamanho";  // Agora, vamos pegar apenas o tamanho
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Obtém o modelo do combo box
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboTamanho.getModel();

            // Remove todos os itens atuais do combo box
            model.removeAllElements();

            // Adiciona os itens ao combo box
            while (rs.next()) {
                String tamanho = rs.getString("tamanho");
                precoTamanho = rs.getDouble("precoTamanho");
                model.addElement(tamanho);
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
            String sql = "SELECT id_bebida, bebida, precoBebida FROM bebida";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Obtém o modelo do combo box
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBebida.getModel();
            // Remove todos os itens atuais do combo box
            model.removeAllElements();

            // Adiciona os itens ao combo box
            while (rs.next()) {
                String bebida = rs.getString("bebida");
                precoBebida = rs.getDouble("precoBebida");
                model.addElement(bebida);
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

    public void enviarPedido() {
    Connection conn = Database.getConnection();

    String tamanho = comboTamanho.getSelectedItem().toString();
    String sabor = comboSabor.getSelectedItem().toString();
    String bebida = comboBebida.getSelectedItem().toString();

    String nome_Cliente = inputNome.getText();
    String endereco = inputRua.getText();

    String bairro = inputBairro.getText();
    int nCasa = Integer.parseInt(inputNumeroCasa.getText());
    String horaP = inputHora.getText();
    double precoFinal = precoTamanho + precoSabor + precoBebida;

    try {
        // Query de inserção sem o `id_pedido` (auto-incremento)
        String sql = "INSERT INTO `pedido`(`sabor`, `tamanho`, `bebida`, `nomeCliente`, `rua`, `bairro`, `numero`, `hora`, `precoFinal`) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, sabor);
        stmt.setString(2, tamanho);
        stmt.setString(3, bebida);
        stmt.setString(4, nome_Cliente);
        stmt.setString(5, endereco);
        stmt.setString(6, bairro);
        stmt.setInt(7, nCasa);
        stmt.setString(8, horaP);
        stmt.setDouble(9, precoFinal);

        stmt.executeUpdate();

        // Recupera o id gerado
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            long idPedido = generatedKeys.getLong(1);  // Aqui você tem o id_pedido gerado
            System.out.println("Pedido enviado com sucesso. ID do Pedido: " + idPedido);
        }

        // Atualiza a tabela com os pedidos
        homee h = new homee();
        h.listaPedidos();

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao enviar o pedido: " + ex.getMessage());
    }
}

}