package coffeehouse.java;

abstract public class Beverage {
    private boolean extras;

    protected Beverage(boolean extras){
        this.extras = extras;
    }

    abstract protected void brew();
    
    abstract protected void addExtras();
    
    protected void boilWater(){
        System.err.println("Boiling water");
    };

    protected void pourInCup(){
        System.err.println("Pouring into cup");
    };

    public void prepareRecipe(){
        System.out.println("Preparing new beverage");
        boilWater();
        brew();
        pourInCup();
        if(extras){
            addExtras();
        }
        System.out.println();
    }
}
