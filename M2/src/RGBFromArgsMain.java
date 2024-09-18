public class RGBFromArgsMain {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("not enough arguments");
        }
        else {
            double r = Double.parseDouble(args[0]);
            double g = Double.parseDouble(args[1]);
            double b = Double.parseDouble(args[2]);

            RGB newcolor = new RGB(r, g, b);
            newcolor.display();	
        }
    }
}
