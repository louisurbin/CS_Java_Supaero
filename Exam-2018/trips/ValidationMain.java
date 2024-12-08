package trips;

public class ValidationMain {
    public static void main(String[] args) {
        Airport airport1 = new Airport("Toulouse Blagnac", "TLS");
        Airport airport2 = new Airport("Roissy Charles de Gaulle", "CDG");
        Airport airport3 = new Airport("Toulouse Blagnac", "TLS");

        System.out.println(airport1.isSameAs(airport3));
        System.out.println(airport1.isSameAs(airport2));

        Flight flight1 = new Flight("AF1234", airport1, airport2);
        Flight flight2 = new Flight("BB1234", airport2, airport3);
        System.out.println(flight1.isConnectedTo(flight2));

        Trip trip = new Trip();
        trip.addFlight(flight1);
        trip.addFlight(flight2);
        System.out.println(trip.isValid());
    }
}
