package trips;

public class Airport {
    private String name;
    private String iata;

    public Airport(String name, String iata) {
        this.name = name;
        this.iata = iata;
    }

    @Override
    public String toString() {
        return getName() + "(" + getIata() + ")";
    }

    public String getName() {
        return this.name;
    }

    public String getIata() {
        return this.iata;
    }

    public boolean isSameAs(Airport other) {
        return getIata().equals(other.getIata());
    }
}