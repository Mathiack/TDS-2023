package PedidoInt;

import javax.swing.JFrame;

public class Pitzzaria extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pitzzaria p = new Pitzzaria();
        p.setExtendedState(JFrame.MAXIMIZED_BOTH);
        p.setUndecorated(true);
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
