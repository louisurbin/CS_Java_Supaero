package trips;

public class TripMain {
    public static void main(String[] args) {
        Airport a1 = new Airport("Toulouse Blagnac", "TLS");
        System.out.println(a1);
        
        Airport a2 = new Airport("Paris Charles de Gaulle", "CDG");
        Flight f1 = new Flight("AF1234", a1, a2);
        System.out.println(f1.toString());

        Flight f2 = new Flight("AF5678", a2, a1);
        Trip t1 = new Trip();
        t1.addFlight(f1);
        t1.addFlight(f2);
        System.out.println(t1.toString());
    }
}
