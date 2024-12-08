package coffeehouse;

public class CoffeeHouseMain {
    public static void main(String[] args) {
        Barista barista = new Barista();
        Beverage beverage = barista.takeOrder("coffee");
        beverage.prepareRecipe();
        beverage = barista.takeOrder("coffee, extras");
        beverage.prepareRecipe();
        beverage = barista.takeOrder("tea");
        beverage.prepareRecipe();
        beverage = barista.takeOrder("tea, extras");
        beverage.prepareRecipe();
    }
}
