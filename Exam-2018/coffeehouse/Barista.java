package coffeehouse;

public class Barista {
    public Beverage takeOrder(String order) {
        if (order.equals("coffee")) {
            return new Coffee(false);
        }
        if (order.equals("coffee, extras")) {
            return new Coffee(true);
        }
        if (order.equals("tea")) {
            return new Tea(false);
        }
        if (order.equals("tea, extras")) {
            return new Tea(true);
        }
        return null;
    }
}
