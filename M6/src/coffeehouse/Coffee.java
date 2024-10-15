package coffeehouse;

public class Coffee extends Beverage {

    public Coffee(boolean extras){
        super(extras);
    }

    protected void brew(){
        System.err.println("Putting coffee powder into cup");
    }

    protected void addExtras(){
        System.err.println("Adding milk and sugar");
    }
    
}
