/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pitzzaria;

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
