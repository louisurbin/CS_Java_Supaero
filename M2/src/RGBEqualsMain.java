public class RGBEqualsMain {
    public static void main(String[] args) throws Exception {
        RGB color1 = new RGB(0, 0, 0);
        RGB color2 = new RGB(0, 0, 1);
        RGB color3 = color2;
        RGB color4 = new RGB(0, 0, 1);

        System.out.println(color1.equals(color2)); 
        System.out.println(color2.equals(color3));
        System.out.println(color2.equals(color4));
    }
}
