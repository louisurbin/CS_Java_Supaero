public class ExecBug1Main {
    public static void main(String[] args) throws Exception {
        double x = 2.0;
        double y = 3.0 / 4.0;
        double z = x / y;
        System.out.println(x + "/" + y + " = " + z);
    }
}
