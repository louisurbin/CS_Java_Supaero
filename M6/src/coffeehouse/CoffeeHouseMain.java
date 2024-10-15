package coffeehouse;

public class CoffeeHouseMain {
    public static void main(String[] args) {
        /* 
        Beverage coffee1 = new Coffee(true);
        coffee1.prepareRecipe();

        Beverage coffee2 = new Coffee(false);
        coffee2.prepareRecipe();

        Beverage tea1 = new Tea(true);
        tea1.prepareRecipe();

        Beverage tea2 = new Tea(false);
        tea2.prepareRecipe();
        */

        Barista barista = new Barista();
        barista.takeorder("coffee").prepareRecipe();
        barista.takeorder("tea").prepareRecipe();
        barista.takeorder("coffee, extras").prepareRecipe();
        barista.takeorder("tea, extras").prepareRecipe();
    }
}
