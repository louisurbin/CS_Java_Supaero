package coffeehouse;

public class Barista {
    public Beverage takeorder(String str){
        if(str.equals("coffee")){
            Beverage coffee1 = new Coffee(false);
            return coffee1;
        }
        else if(str.equals("tea")){
            Beverage tea1 = new Tea(false);
            return tea1;
        }
        else if(str.equals("coffee, extras")){
            Beverage coffee2 = new Coffee(true);
            return coffee2;
        }
        else if(str.equals("tea, extras")){
            Beverage tea2 = new Tea(true);
            return tea2;
        }
        else{
            return null;
        }
    }
}
