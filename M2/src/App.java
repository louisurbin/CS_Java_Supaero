public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Dummy World!");  
        RGB color1 = new RGB(0, 1, 0);
        RGB color2 = new RGB(0, 0, 2);
        System.out.println(color1.hasValuesInRange());
        System.out.println(color2.hasValuesInRange());
        System.out.println(isValueInRange(1.5));
    }
    public static boolean isValueInRange(double value) {
        return value>=0 && value<=1;    
    }
}
