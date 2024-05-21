package Java.Domino_Ederson; // package do jogo 

public class Peca {
    int num_Esq;
    int num_Dir;
    boolean oculta;
    
    public int getNum_Esq() {
        return num_Esq;
    }
    public void setNum_Esq(int num_Esq) {
        this.num_Esq = num_Esq;
    }
    public int getNum_Dir() {
        return num_Dir;
    }
    public void setNum_Dir(int num_Dir) {
        this.num_Dir = num_Dir;
    }
    public boolean isOculta() {
        return oculta;
    }
    public void setOculta(boolean oculta) {
        this.oculta = oculta;
    }
    
}