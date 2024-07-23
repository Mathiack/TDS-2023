import java.awt.Dimension;
import java.awt.Toolkit;
public class resolucao {

    public static void main (String [] args) {

        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();

        int largura = (int) tela.getWidth();
        int altura  = (int) tela.getHeight();

        System.out.println("O tamanho é de : " + largura + " X " + altura );
    }
}
/*não terminado*/