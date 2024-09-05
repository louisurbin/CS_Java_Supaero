import java.util.Locale;
import java.util.Scanner;

public class RGBMain {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
            
        System.out.println("red");
        double r = sc.nextDouble();
            
        System.out.println("blue");
        double b = sc.nextDouble();

        System.out.println("green");
        double g = sc.nextDouble();

        RGB color1 = new RGB(r, g, b);
        color1.display();

        sc.close();
    }
}
