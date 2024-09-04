public class RGBMain {
    
    public static void main(String[] args) throws Exception {
        RGB color1 = new RGB(0, 0.3, 1);
        color1.turnToGrey();
        color1.display();
        color1.set(0.5);
        color1.display();
        color1.set(0.1, 0.2, 0.3);
        color1.display();
    }
}
