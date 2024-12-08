package coffeehouse;

public class Tea extends Beverage {

    public Tea(boolean extras) {
        super(extras);
    }

    protected void brew() {
        System.out.println("Putting tea bag into cup");
    }

    protected void addExtras() {
        System.out.println("Adding lemon");
    }
}