package com.mycompany.primeirajanela;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ExemploLabel extends JFrame {
    JLabel rotulo1, rotulo2, rotulo3, rotulo4;
    JTextField texto1, texto2, texto3, texto4;
    JButton botao, botaoCadastro, botaoSair, botaoCalculadora, botaoEstados;
    JButton botaoDialogo, botaoArquivo, botaoTabela;

    // Painéis para exibir
    JPanel panelMain, panelCadastro;

    public ExemploLabel() {
        super("Exemplo com Label");
       
        Container panelMain = getContentPane();
        panelMain.setLayout(null);
        
        rotulo1 = new JLabel("Nome");
        rotulo2 = new JLabel("Idade");
        rotulo3 = new JLabel("Telefone");
        rotulo4 = new JLabel("Celular");

        botao = new JButton("Procurar");
        botaoCadastro = new JButton("Cadastro");
        botaoSair = new JButton("Sair");
        botaoCalculadora = new JButton("Calculadora");
        botaoEstados = new JButton("Estados");
        botaoDialogo = new JButton("Dialogar");
        botaoArquivo = new JButton("Arquivo");
        botaoTabela = new JButton("Tabela");

        texto1 = new JTextField(50);
        texto2 = new JTextField(3);
        texto3 = new JTextField(14);
        texto4 = new JTextField(14);

        rotulo1.setBounds(50, 20, 120, 20);
        rotulo2.setBounds(50, 60, 120, 20);
        rotulo3.setBounds(50, 100, 120, 20);
        rotulo4.setBounds(50, 140, 120, 20);

        texto1.setBounds(150, 20, 200, 20);
        texto2.setBounds(150, 60, 20, 20);
        texto3.setBounds(150, 100, 80, 20);
        texto4.setBounds(150, 140, 80, 20);

        botao.setBounds(35, 180, 100, 20);
        botaoSair.setBounds(35, 210, 100, 20);
        botaoCadastro.setBounds(35, 240, 100, 20);
        botaoCalculadora.setBounds(35, 270, 100, 20);
        botaoEstados.setBounds(190, 180, 100, 20);
        botaoDialogo.setBounds(190, 210, 100, 20);
        botaoArquivo.setBounds(190, 240, 100, 20);
        botaoTabela.setBounds(190, 270, 100, 20);

        rotulo1.setForeground(Color.red);
        rotulo2.setForeground(Color.blue);
        rotulo3.setForeground(new Color(190, 152, 142));
        rotulo4.setForeground(new Color(201, 200, 100));

        rotulo1.setFont(new Font("Arial", Font.BOLD, 14));
        rotulo2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        rotulo3.setFont(new Font("Courier New", Font.BOLD, 18));
        rotulo4.setFont(new Font("Times New Roman", Font.BOLD, 20));

        panelMain.add(rotulo1);
        panelMain.add(rotulo2);
        panelMain.add(rotulo3);
        panelMain.add(rotulo4);
        panelMain.add(texto1);
        panelMain.add(texto2);
        panelMain.add(texto3);
        panelMain.add(texto4);
        
        panelMain.add(botao);
        panelMain.add(botaoCadastro);
        panelMain.add(botaoSair);
        panelMain.add(botaoCalculadora);
        panelMain.add(botaoEstados);
        panelMain.add(botaoDialogo);
        panelMain.add(botaoArquivo);
        panelMain.add(botaoTabela);

        // Define o comportamento dos botões
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janCad();
            }
        });
        
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        botaoCalculadora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janCalc();
            }
        });
        
        botaoEstados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janEst();
            }
        });
        
        botaoDialogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janDia();
            }
        });
        
        botaoArquivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janArq();
            }
        });
        
        botaoTabela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janTab();
            }
        });
        
        
        
        setSize(400, 430);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    //            JANELA DO CADASTRO            //
    static void janCad() {
        JFrame j = new JFrame("CADASTRO");
        j.setSize(400, 350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        
        GridLayout layout = new GridLayout(0, 2, 20, 20);
        p.setLayout(layout);
        
        JLabel JLnome = new JLabel("Nome:");
        JLnome.setHorizontalAlignment(JLabel.CENTER);
        JLnome.setHorizontalTextPosition(JLabel.CENTER);
        JTextField JTnome = new JTextField();
        JTnome.setPreferredSize(new Dimension(50, 24));
        
        JLabel JLemail = new JLabel("E-mail:");
        JTextField JTemail = new JTextField();
        
        JLabel JLidade = new JLabel("Idade:");
        JTextField JTidade = new JTextField();
        
        JLabel JLtelefone = new JLabel("Telefone:");
        JTextField JTtelefone = new JTextField();
        
        JLabel JLcpf = new JLabel("CPF:");
        JTextField JTcpf = new JTextField();
        
        JLabel JLdata = new JLabel("Data de Nascimento:");
        JTextField JTdata = new JTextField();
        
        JLabel JLendereco = new JLabel("Endereço:");
        JTextField JTendereco = new JTextField();
        
        JLabel JLcep = new JLabel("CEP:");
        JTextField JTcep = new JTextField();
        
        JLabel JLsenha = new JLabel("Senha:");
        JTextField JTsenha = new JTextField();
        
        JButton JBenviar = new JButton("Enviar");
        
        p.add(JLemail);
        p.add(JTemail);
        
        p.add(JLidade);  
        p.add(JTidade);
        
        p.add(JLtelefone);
        p.add(JTtelefone);
        
        p.add(JLcpf);
        p.add(JTcpf);
        
        p.add(JLdata);
        p.add(JTdata);
        
        p.add(JLendereco);
        p.add(JTendereco);
        
        p.add(JLcep);
        p.add(JTcep);
        
        p.add(JLsenha);
        p.add(JTsenha);
        
        p.add(JBenviar);
        
        String nome = JTnome.getText();
        String email = JTemail.getText();
        String idade = JTidade.getText();
        String telefone = JTtelefone.getText();
        String data = JTdata.getText();
        String endereco = JTendereco.getText();
        String cep = JTcep.getText();
        String senha = JTsenha.getText();
        
       
        
        //JBenviar.setHorizontalAlignment(JButton.CENTER);
        //JBenviar.setHorizontalTextPosition(JButton.CENTER);
        
        j.add(p);
        j.pack();
        j.setVisible(true);
        
        JBenviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int print = JOptionPane.showConfirmDialog(j, 
                    "-------------------------------\n" +
                    "Nome: " + nome + "\n" +
                    "Idade: " + idade + "\n" + 
                    "E-mail: " + email + "\n" +
                    "Senha: " + senha + "\n" +
                    "Telefone: " + telefone + "\n" +
                    "-------------------------------\n" +
                    "Endereço: " + endereco + "\n" +
                    "CEP: " + cep + "\n" +
                    "Data: " + data + "\n" +
                    "-------------------------------\n"
                    );

                if (print == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(j, "Fasido");
                } else if (print == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(j, "Beta");
                } else {
                        JOptionPane.showMessageDialog(j, "Beta");
                }
            }
        });
    }
    
    //            JANELA DA CALCULADORA            //
    static void janCalc() {
        JFrame j = new JFrame("CALCULADORA");
        j.setSize(400,350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        
        GridLayout layout = new GridLayout(0,2,20,20);
        p.setLayout(layout);
        
        
        JLabel jLbnum1 = new JLabel("Número 1:");       
        jLbnum1.setHorizontalAlignment(JLabel.CENTER);
        jLbnum1.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxnum1 = new JTextField();
        jTxnum1.setPreferredSize(new Dimension( 50, 24 ));
        
        
        JLabel jLbnum2 = new JLabel("Número 2:");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxnum2 = new JTextField();
        jTxnum2.setPreferredSize(new Dimension( 50, 24 ));
        
        
        JLabel jLbresultado = new JLabel("RESULTADO");
        jLbresultado.setHorizontalAlignment(JLabel.CENTER);
        jLbresultado.setHorizontalTextPosition(JLabel.CENTER);
        JLabel jLbVazio = new JLabel("");

        
        jLbresultado.setBounds(50,100,95,30);
        
        JButton jBtSoma=new JButton("Somar");  
        JButton jBtSubtrair=new JButton("Subtrair"); 
        JButton jBtMultiplicar=new JButton("Multiplicar"); 
        JButton jBtDividir=new JButton("Dividir"); 
        
        JButton jBtLimpar=new JButton("Limpar");  
        jBtLimpar.setBounds(50,100,95,30);
        
        jBtSoma.setBounds(50,100,95,30);
        
        jBtSoma.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {
                   Calculos c = new Calculos();   
                   c.setNumero1(Double.parseDouble(jTxnum1.getText()));
                   c.setNumero2(Double.parseDouble(jTxnum2.getText()));
                   c.soma();
                   jLbresultado.setText(c.getCalculo().toString());

                }
        });
        
        
        jBtSubtrair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {
                   Calculos c = new Calculos();   
                   c.setNumero1(Double.parseDouble(jTxnum1.getText()));
                   c.setNumero2(Double.parseDouble(jTxnum2.getText()));
                   c.subtracao();
                   jLbresultado.setText(c.getCalculo().toString());

                }
        });
        
        jBtMultiplicar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {
                   Calculos c = new Calculos();   
                   c.setNumero1(Double.parseDouble(jTxnum1.getText()));
                   c.setNumero2(Double.parseDouble(jTxnum2.getText()));
                   c.multiplicacao();
                   jLbresultado.setText(c.getCalculo().toString());

                }
        });
        
        jBtDividir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {
                   Calculos c = new Calculos();   
                   c.setNumero1(Double.parseDouble(jTxnum1.getText()));
                   c.setNumero2(Double.parseDouble(jTxnum2.getText()));
                   c.divisao();
                   jLbresultado.setText(c.getCalculo().toString());

                }
        });
        
        
        jBtLimpar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
                  {

                   jTxnum1.setText("");
                  jTxnum2.setText("");

                   jLbresultado.setText("");

                }
        });
        
        p.add(jLbnum1);
        p.add(jTxnum1);        
        p.add(jLbnum2);
        p.add(jTxnum2);
        p.add(jLbVazio);
        
        p.add(jLbresultado);
        p.add(jBtSoma);
        p.add(jBtSubtrair);
        p.add(jBtMultiplicar);
        p.add(jBtDividir);
        p.add(jBtLimpar);
        j.add(p);
        j.pack();
        j.setVisible(true);
    }
    
    //            JANELA DOS ESTADOS            //
    //               FAZER DEPOIS               //
    static void janEst() {
        JFrame j = new JFrame("ESTADOS");
        j.setSize(400, 350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        
        GridLayout layout = new GridLayout(0, 2, 20, 20);
        p.setLayout(layout);
        
        j.setVisible(true);
    }
    
    //               JANELA DO DIALOGO               //
    static void janDia() {
        JFrame j = new JFrame("Dialogo");
        j.setSize(400, 350);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        p.setLayout(null);

        JButton JBdialogo = new JButton("Sair");
        JButton JBnome = new JButton("Nome");
        
        JBdialogo.setBounds(35, 10, 100, 20);
        JBnome.setBounds(35, 50, 100, 20);

        p.add(JBdialogo); // Adiciona os botões ao painel
        p.add(JBnome);

        j.add(p); // Adiciona o painel ao JFrame

        JBdialogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int caixa = JOptionPane.showConfirmDialog(j, "Certeza?");
                if (caixa == JOptionPane.YES_OPTION) {
                    j.dispose();
                } else if (caixa == JOptionPane.NO_OPTION || caixa == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(j, "Não quiseste fechar");
                }
            }
        });
        
        JBnome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janNome();
            }
        });
        j.setVisible(true);  
    }
    
    //               JANELA DO NOME               //
    static void janNome() {
        JFrame j = new JFrame("Nome");
        j.setSize(400, 350);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        JTextField inputNome = new JTextField();
        JButton JBenvia = new JButton("Enviar");
        
        inputNome.setBounds(35, 10, 100, 20);
        JBenvia.setBounds(35, 50, 100, 20);
        
        p.add(inputNome);
        p.add(JBenvia);
        
        j.add(p);
        
        j.setVisible(true);
    }
    
    //               JANELA DO ARQUIVO               //
    static void janArq() {
        JFrame j = new JFrame("CALCULADORA");
        j.setSize(400,350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        GridLayout layout = new GridLayout(0,2,20,20);
        p.setLayout(layout);
        
        JLabel jLbnum1 = new JLabel("Nome:");       
        jLbnum1.setHorizontalAlignment(JLabel.CENTER);
        jLbnum1.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxnome = new JTextField();
        jTxnome.setPreferredSize(new Dimension( 50, 24 ));
        
        
        JLabel jLbnum2 = new JLabel("E-mail");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxemail = new JTextField();
        jTxemail.setPreferredSize(new Dimension( 50, 24 ));
        
        JLabel jLbnum3 = new JLabel("Telefone");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxtel = new JTextField();
        jTxtel.setPreferredSize(new Dimension( 50, 24 ));
        
        JLabel jLbnum4 = new JLabel("Sexo");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxsexo = new JTextField();
        jTxsexo.setPreferredSize(new Dimension( 50, 24 ));
        
        JLabel jLbnum5 = new JLabel("Cidade");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxcidade = new JTextField();
        jTxcidade.setPreferredSize(new Dimension( 50, 24 ));
        
        JLabel jLbnum6 = new JLabel("Estado");
        jLbnum2.setHorizontalAlignment(JLabel.CENTER);
        jLbnum2.setHorizontalTextPosition(JLabel.CENTER);
        JTextField jTxestado = new JTextField();
        jTxestado.setPreferredSize(new Dimension( 50, 24 ));
        
        JButton jBtEscrever = new JButton("Escrever");  
        JButton jBtLer = new JButton("Ler ");  
        
        jBtEscrever.setBounds(50,100,95,30);
        jBtLer.setBounds(50,100,95,30);
        
        jBtEscrever.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"))) {
                    String nome = jTxnome.getText();
                    String email = jTxsexo.getText();
                    String tel = jTxtel.getText();
                    String sexo = jTxsexo.getText();
                    String cidade = jTxcidade.getText();
                    String estado = jTxestado.getText();
                    
                    writer.write("Nome: " + nome);
                    writer.newLine();
                    writer.write("E-mail: " + email);
                    writer.newLine();
                    writer.write("Telefone: " + tel);
                    writer.newLine();
                    writer.write("Sexo: " + sexo);
                    writer.newLine();
                    writer.write("Cidade: " + cidade);
                    writer.newLine();
                    writer.write("Estado: " + estado);
                    writer.newLine();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
        jBtLer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                try (BufferedReader reader = new
                    BufferedReader(new FileReader("saida.txt"))) {
                    String linha;
                    
                    while ((linha = reader.readLine()) != null) {
                        System.out.println(linha);
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                } 
            } 
        });
        
        p.add(jLbnum1);
        p.add(jTxnome);
        
        p.add(jLbnum2);
        p.add(jTxemail);
        
        p.add(jLbnum3);
        p.add(jTxtel);
        
        p.add(jLbnum4);
        p.add(jTxsexo);
        
        p.add(jLbnum5);
        p.add(jTxcidade);
        
        p.add(jLbnum6);
        p.add(jTxestado);
        
        p.add(jBtEscrever);
        p.add(jBtLer);
        
        j.add(p);
        j.pack();
        j.setVisible(true);
    }    
    
    static void janTab() {
        JFrame j = new JFrame("TABELA");
        j.setSize(400,350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        GridLayout layout = new GridLayout(0,2,20,20);
        p.setLayout(layout);
        
        j.setVisible(true);
    }
}