public class Ex2 {
    public static void main(String[] args) {
        System.out.println(circonference(1));
        System.out.println(surface(1));
    }
    public static double circonference(double r) {
        return 2 * Math.PI * r;
    }
    public static double surface(double r) {
        return Math.PI * r * r;
    }
}
