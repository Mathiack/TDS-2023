import java.util.Locale;

public class idioma {
    
    public static void main (String [] args) {

        Locale local = Locale.getDefault();
        System.out.println(local.getDisplayLanguage());
    }
}
