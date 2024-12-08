package trips;

import java.util.ArrayList;

public class Trip {
    private ArrayList<Flight> flights;

    public Trip() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public String toString() {
        if (flights.size() > 1) {
            return flights.get(0).getDepartureAirport().getIata() + " - "
                    + flights.get(flights.size() - 1).getArrivalAirport().getIata() + " (" + flights.size()
                    + " flights)";
        }
        if (flights.size() == 1) {
            return flights.get(0).getDepartureAirport().getIata() + " - "
                    + flights.get(0).getArrivalAirport().getIata() + " (direct)";
        }
        return "No flight yet";
    }

    public boolean isValid() {
        if (flights.size() > 1) {
            for (int i = 0; i < flights.size() - 1; i++) {
                if (!flights.get(i).isConnectedTo(flights.get(i + 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}
