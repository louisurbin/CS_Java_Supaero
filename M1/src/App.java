public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Dummy World!");
        
        Position position1 = new Position(0, 0);
        position1.display();
        position1.moveTo(3, 4); 
        position1.display();
        position1.moveTo(6, 8);
        position1.display();
        System.out.println(position1.distanceToOrigin());

        Position position2 = new Position(1,0);
        position2.moveTo(2,4);
        position2.display();

        Position position3 = new Position(0, 1);
        position3.moveTo(4, 2);
        position3.display();

        RGB color1 = new RGB(0, 0.3, 1);
        color1.turnToGrey();
        color1.display();
    }
}
