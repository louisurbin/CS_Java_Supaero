package generic;

// Eviter problemes d'importation
class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y + '}';
    }
}

public class MyLisatMain {
    public static void main(String[] args) {
        MyList<Position> dl1 = new MyList<>();
        dl1.display();
        dl1.insertElement(0, new Position(0.0, 0.0));
        dl1.display();
        dl1.insertElement(1, new Position(1.1, 1.1));
        dl1.display();
        
        // call some other methods
        int sz = dl1.size();
        boolean e = dl1.isEmpty();
        System.out.println("size = " + sz + ", empty = " + e);
        dl1.removeElement(0);
        dl1.display();
        
        // create other lists
        MyList<Position> dl2 = new MyList<>();
        dl2.insertElement(0, new Position(11.1, 11.1));
        dl2.insertElement(0, new Position(22.2, 22.2));
        MyList<Position> dl3 = new MyList<>();
        dl3.insertElement(0, new Position(111.1, 111.1));
        dl3.insertElement(0, new Position(222.2, 222.2));
        dl3.insertElement(0, new Position(333.3, 333.3));
        
        // display the 3 lists
        dl1.display();
        dl2.display();
        dl3.display();
    }
    }

