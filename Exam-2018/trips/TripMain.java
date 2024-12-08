package trips;

public class TripMain {
    public static void main(String[] args) {
        Airport airport1 = new Airport("Toulouse Blagnac", "TLS");
        Airport airport2 = new Airport("Roissy Charles de Gaulle", "CDG");
        Airport airport3 = new Airport("Reykjavik", "RKV");

        Flight flight1 = new Flight("AF1234", airport1, airport2);
        Flight flight2 = new Flight("BB1234", airport2, airport3);

        Trip trip = new Trip();
        trip.addFlight(flight1);
        trip.addFlight(flight2);
        System.out.println(trip.toString());
    }
}
