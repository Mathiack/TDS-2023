/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package janela;

/**
 *
 * @author Suporte
 */
public class janela2 extends javax.swing.JFrame {

    /**
     * Creates new form janela2
     */
    public janela2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        bemV = new java.awt.Label();
        fieldIdade = new javax.swing.JTextField();
        fieldNome = new javax.swing.JTextField();
        idade = new java.awt.Label();
        nome = new java.awt.Label();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        bemV.setAlignment(java.awt.Label.CENTER);
        bemV.setText("Bem-Vindo");
        bemV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bemVMouseClicked(evt);
            }
        });

        fieldIdade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldIdadeMouseClicked(evt);
            }
        });
        fieldIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdadeActionPerformed(evt);
            }
        });

        fieldNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldNomeMouseClicked(evt);
            }
        });
        fieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeActionPerformed(evt);
            }
        });

        idade.setText("Idade:");
        idade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idadeMouseClicked(evt);
            }
        });

        nome.setText("Nome Completo:");
        nome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomeMouseClicked(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                btnEnviarMouseWheelMoved(evt);
            }
        });
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
        });
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idade, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bemV, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(btnEnviar)))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(bemV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnEnviar)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    
    // FIELD NOME
    private void fieldNomeActionPerformed(java.awt.event.ActionEvent evt) {                                          
        System.out.println("Ação no Campo do Nome");
    }                                         

    
    // FIELD IDADE
    private void fieldIdadeActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.out.println("Ação no Campo da Idade");
    }                                          

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {                                       
        System.out.println("Clicou no Botão de Enviar");
    }                                      

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        System.out.println("Ação no Botão de Enviar");
    }                                         

    private void nomeMouseClicked(java.awt.event.MouseEvent evt) {                                  
        System.out.println("Clicou no Nome");
    }                                 

    private void fieldNomeMouseClicked(java.awt.event.MouseEvent evt) {                                       
        System.out.println("Clicou no Campo do Nome");
    }                                      

    private void fieldIdadeMouseClicked(java.awt.event.MouseEvent evt) {                                        
        System.out.println("Clicou no Campo da Idade");
    }                                       

    private void idadeMouseClicked(java.awt.event.MouseEvent evt) {                                   
        System.out.println("Clicou na Idade");
    }                                  

    private void btnEnviarMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                          
        System.out.println("Roda do Mouse no btn Enviar");
    }                                         

    private void bemVMouseClicked(java.awt.event.MouseEvent evt) {                                  
        System.out.println("Bem-Vindo");
    }                                 

    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        System.out.println("Clicou no Fundo");
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
            java.util.logging.Logger.getLogger(janela2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janela2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janela2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janela2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janela2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private java.awt.Label bemV;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JTextField fieldIdade;
    private javax.swing.JTextField fieldNome;
    private java.awt.Label idade;
    private java.awt.Label nome;
    // End of variables declaration                   
}