package trips;

import java.util.ArrayList;

public class Trip {
    private ArrayList<Flight> flights;

    public Trip(){
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

    public String toString(){
        String str = "";
        if(flights.isEmpty()){
            return "No flight yet";
        }
        else {
            str += flights.get(0).getDepartureAirport().getIata();
            str += " - ";
            str += flights.get(flights.size()-1).getArrivalAirport().getIata();
        }
        if (flights.size() == 1){
            str += " (direct) ";
        }
        else {
            str += " (";
            str += flights.size();
            str += ")";
        }
        return str;
    }
}
