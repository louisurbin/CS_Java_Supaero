public class PrintMain {
    public static void main(String[] args) throws Exception {
        int k = 7;
        System.out.print(k); 
        System.out.println(k + k);

        int nbDwarfs = 7;
        System.out.println("Blanche-Neige et les " + nbDwarfs + " nains");
        System.out.println("Toto a "+ k + " ans");

        System.out.printf("Blanche-Neige et les %d nains%n", k);
        boolean b = true;
        System.out.printf("%b %n", b);
    }
}
