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

    public String toString() {
        return this.flightNumber + " : " + this.departureAirport.getName() + " - " + this.arrivalAirport.getName();
    }

}