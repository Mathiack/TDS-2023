public class Heranca00{
    public static void main(String[] args) {
        System.out.println("Aoba!");

        Cachorro a  = new Cachorro("Jairsaodamecanica", "vira-lata", "negão", 12);
        System.out.println(a);

        Cachorro cao1 = new Cachorro("clóvis", "chiuaua", "caramelo", 4);
        System.out.println(cao1);

        Cachorro cao2 = new Cachorro("Mandioca", "pastor alemão", "branco", 7);
        System.out.println(cao2);
            
        Cachorro cao3 = new Cachorro("Lupita", "chitzo", "marrom", 10);
        System.out.println(cao3);
    }
}
abstract class Animal {
    String nome;
    String onomatopeia;
    String cor;
    String raca;
    Integer idade;
    
    public String toString () {
        return 
        "Raça:" + this.raca + "\n" +
        "Nome:" + this.nome + "\n" + 
        "Cor:" + this.cor + "\n" +
        "Idade:" + this.idade + "\n" +
        "Som:" + this.onomatopeia + "\n";
    }

}
class Cachorro extends Animal {
    Cachorro (String nome, String raca, String cor, Integer idade) {
        this.nome = nome;
        this.onomatopeia = "auauau";
        this.cor = cor;
        this.raca = raca;
        this.idade = idade;
    }
}
