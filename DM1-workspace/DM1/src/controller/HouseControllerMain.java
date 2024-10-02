package controller;

public class HouseControllerMain {
    public static void main(String[] args) {
        
        Thermostat kitchen = new Thermostat("Kitchen");
        Thermostat bathroom = new Thermostat("Bathroom");
        Thermostat bedroom = new Thermostat("Bedroom");
        Thermostat living = new Thermostat("Living room");
        System.out.println(kitchen);
        System.out.println(bathroom);
        System.out.println(bedroom);
        System.out.println(living);

        bathroom.setNominal(18);
        bedroom.setNominal(0);
        living.setNominal(20);
        System.out.println(kitchen);
        System.out.println(bathroom);
        System.out.println(bedroom);
        System.out.println(living);
        

        
        HouseController controller = new HouseController();
        controller.addThermostat(kitchen);
        controller.addThermostat(bathroom);
        controller.addThermostat(bedroom);
        controller.addThermostat(living);
        System.out.println(controller);

        controller.adjustAll(-4);
        System.out.println(controller);

        controller.adjustAll(1);
        System.out.println(controller);

        controller.adjustAll(100);
        System.out.println(controller);
        
    }
}
