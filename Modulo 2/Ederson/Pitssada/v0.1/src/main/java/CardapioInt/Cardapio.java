package CardapioInt;

import javax.swing.JFrame;

public class Cardapio extends JFrame{
    
    public static void main(String[] args) {
        Cardapio c = new Cardapio();
        c.setExtendedState(JFrame.MAXIMIZED_BOTH);
        c.setUndecorated(true);
        c.setVisible(true);
        c.setLocationRelativeTo(null);
        c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
