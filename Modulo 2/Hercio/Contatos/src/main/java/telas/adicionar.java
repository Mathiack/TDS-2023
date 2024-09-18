package telas;

import javax.swing.*;
import java.awt.*;

public class adicionar extends JFrame {
    
    static void telaAdicionar() {
        JFrame j = new JFrame("Adicionar Contato");
        j.setSize(400, 350);
        j.setLocationRelativeTo(j);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        
        GridLayout layout = new GridLayout(0, 2, 20, 20);
        p.setLayout(layout);
    }
}
