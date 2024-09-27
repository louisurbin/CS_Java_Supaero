package vscodegen;

public class Student extends Person {
    private String promo;

    // constructor
    public Student(String name, int age, String promo) { 
        super(name, age);
        this.promo = promo;
    }   

    // methods
    public String getPromo() {
        return this.promo;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + promo;
    }

}
