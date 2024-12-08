package coffeehouse;

public abstract class Beverage {
    private boolean extras;

    public Beverage(boolean extras) {
        this.extras = extras;
    }

    public void prepareRecipe() {
        System.out.println("Preparing new beverage");
        boilWater();
        brew();
        pourInCup();
        if (extras)
            addExtras();
        System.out.println();
    }

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void brew();

    protected abstract void addExtras();
}
