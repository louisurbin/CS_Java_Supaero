package persons;

public class Student extends Person {
    private String promo;

    //constructor
    public Student (String name, int age , String promo) {
        super(name,age);
        this.promo = promo;
    }

    //mathods
    public String getPromo() {
        return promo;
    }

    public String toString() {
        return super.toString() + ", " + promo;
    }

}
