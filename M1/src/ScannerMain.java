import java.util.Locale;
import java.util.Scanner;

public class ScannerMain {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            sc.useLocale(Locale.US);
            
            System.out.println("ecrire un réel");
            double r = sc.nextDouble();
            System.out.printf("%f %n",r);
            
            System.out.println("true or false ?");
            boolean b = sc.nextBoolean();
            System.out.printf("%b %n",b);
        }
    }
}
