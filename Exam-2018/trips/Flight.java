package trips;

public class Flight {
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;

    public Flight(String flightNumber, Airport departureAirport, Airport arrivalAirport) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public Airport getDepartureAirport() {
        return this.departureAirport;
    }

    public Airport getArrivalAirport() {
        return this.arrivalAirport;
    }

    @Override
    public String toString() {
        return getFlightNumber() + " : " + getDepartureAirport().getIata() + " - " + getArrivalAirport().getIata();
    }

    public boolean isConnectedTo(Flight next) {
        return getArrivalAirport().equals(next.getDepartureAirport());
    }
}
