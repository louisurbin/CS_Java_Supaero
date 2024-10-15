package persons;

public class Teacher extends Person {
    private String specialty;

    //cconstructor
    public Teacher (String name, int age, String specialty) {
        super(name,age);
        this.specialty = specialty;
    }

    //methods
    public String getSpecialty() {
        return this.specialty;
    }

    public String toString() {
        return "Prof. " + super.getName() + ", " + this.specialty;
    }

    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Teacher)){
            return false;
        }
        Teacher t = (Teacher) obj;
        return this.getName().equals(t.getName()) && this.getAge() == t.getAge() && this.specialty.equals(t.specialty);
    }
}
