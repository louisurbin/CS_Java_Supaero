package coffeehouse;

public class Coffee extends Beverage {

    public Coffee(boolean extras) {
        super(extras);
    }

    protected void brew() {
        System.out.println("Putting coffee powder into cup");
    }

    protected void addExtras() {
        System.out.println("Adding milk and sugar");
    }
}
