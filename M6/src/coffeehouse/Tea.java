package coffeehouse;

public class Tea extends Beverage {
    
    public Tea(boolean extras){
        super(extras);
    }

    protected void brew(){
        System.err.println("Putting Tea bag into cup");
    }

    protected void addExtras(){
        System.err.println("Adding lemon");
    }
    
}
