package order;

import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
    private String color;
    private String name;

    public Fruit(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String toString() {
        return this.color + " " + this.name;
    }

    public int compareTo(Fruit another) {
        if (this.name.equals(another.name)) {
            return this.color.compareTo(another.color);
        }
        else {
            return this.name.compareTo(another.name);
        }
    }

    public int hashCode() {
        return Objects.hash(this.name, this.color);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Fruit) {
            Fruit other = (Fruit)obj;
            return this.name.equals(other.name) && this.color.equals(other.color);
        }
        return false;
    }

}
