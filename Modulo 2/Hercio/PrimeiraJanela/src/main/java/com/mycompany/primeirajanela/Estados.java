package com.mycompany.primeirajanela;

import javax.swing.*;
import java.awt.*;

public class Estados extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> jList;
    private JTextField itemField;
    
    JButton btnEnviar;
    
    JLabel JLestado;
    
    
    public Estados() {
        super("Estados");
        
        listModel = new DefaultListModel<>();
        jList = new JList<>(listModel);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setVisibleRowCount(10);
        
        Container tela = getContentPane();
        setLayout(null);
        
        
        JLestado = new JLabel("Selecione um Estado");
        
    }
}
