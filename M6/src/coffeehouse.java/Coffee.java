package coffeehouse.java;

public class Coffee extends Beverage {
    private boolean sugar;
    private boolean milk;

    public Coffee(boolean sugar, boolean milk){
        super(true);
        this.sugar = sugar;
        this.milk = milk;
    }

    protected void brew(){
        System.err.println("Dripping coffee through filter");
    }

    protected void addExtras(){
        if(sugar){
            System.err.println("Adding sugar");
        }
        if(milk){
            System.err.println("Adding milk");
        }
    }
    
}
