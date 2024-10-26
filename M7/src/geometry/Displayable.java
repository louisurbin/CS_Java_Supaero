package geometry;

public interface Displayable {
    default void display(){
        System.out.println(toString());
    };
}

