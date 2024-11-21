package anomalies;

public class Pixel10 {
    private int red;
    private int green;
    private int blue;

    public Pixel10(int red, int green, int blue) {
        if(!(red >= 0 && red <= 1023)||!(green >= 0 && green <= 1023)||!(blue >= 0 && blue <= 1023)){
            throw new IllegalArgumentException("Invalid color value");
        }
        
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String toString() {
        return "red: " + this.red + " green: " + this.green + " blue: " + this.blue;
    }
}
