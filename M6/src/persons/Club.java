package persons;

import java.util.HashMap;

public class Club {
    //attributes
    private HashMap<String, Person> members;
    private String name;
    
    //constructor
    public Club(String name){
        this.name = name;
        this.members = new HashMap<>();
    }

    //methods
    public void enroll(Person p){
        this.members.put(p.getName(),p);
    }

    public double meanAge(){
        int s = 0;
        for(Person p : members.values()){
            s += p.getAge();
        }
        return s/members.size();
    }

    public void display(){
        System.out.println("Club " + this.name + " has " + this.members.size() + " members:");
        for(Person p : members.values()){
            System.out.println(p.getName());
        }
        System.out.println("Mean age: " + this.meanAge());
    }
}
