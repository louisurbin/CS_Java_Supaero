package controller;

import java.util.ArrayList;

public class HouseController {
   
    private ArrayList<Thermostat> devices;

    //constructor
    public HouseController(){
        this.devices = new ArrayList<>();
    }
    //methods
    public void adjustAll(double delta){
        for (Thermostat thermo : devices){
            thermo.setNominal(thermo.getNominal() + delta);
        }
    }

    public String toString(){
        return this.devices.toString();
    }

    public void addThermostat(Thermostat t){
        this.devices.add(t);
    }
}
