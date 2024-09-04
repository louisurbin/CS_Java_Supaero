public class ExecBug2Main {
    public static void main(String[] args) throws Exception {
        Position p = new Position(1, 2);
        p.display();
        p.moveTo(4, 2);
        p.display();
    }
}
