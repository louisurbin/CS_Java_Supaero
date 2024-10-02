package controller;

public class Thermostat {
    private String location;
    private double nominal;
    public static final double MAX_TEMPERATURE = 25.0;
    public static final double MIN_TEMPERATURE = 17.0;
    public static final double STANDARD_TEMPERATURE = 21.0;

    //constructor
    public Thermostat(String location){
        this.location = location;
        this.nominal = STANDARD_TEMPERATURE;
    }

    //methods
    public void setNominal(double nominal){
        if (nominal > MAX_TEMPERATURE){
            this.nominal = MAX_TEMPERATURE;
        }

        else if (nominal < MIN_TEMPERATURE){
            this.nominal = MIN_TEMPERATURE;
        }
        else{
            this.nominal = nominal;
        }
    }

    public double getNominal(){
        return this.nominal;
    }

    public String toString(){
        return(this.location + " : " + this.nominal + "°");
    }
}
