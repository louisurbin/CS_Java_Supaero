package geometry;

import java.util.ArrayList;

public class Polyline {
    
    private ArrayList<Position> vertices = new ArrayList<>();

    //constructor
    public Polyline() {
        this.vertices = new ArrayList<>();
    }

    //methods
    public void addVertex(Position p){
        vertices.add(p);
    }

    public void clearVertices(){
        if (vertices != null) {
            vertices.clear();
        }
    }

    public int size(){
        return vertices.size();
    }

    public double length(){
        double sum = 0;
        Position p_old = null;
        for (Position p : vertices){
            if (p_old != null){
                sum += Position.distance(p,p_old);
            }
            p_old = p;
        }
        return sum;
    }

    public void display(){
        System.out.print("[");
        for (Position p : vertices){
            System.out.print(p);
        }
        System.out.print("]");
    }

    
    public String toString(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("vertices = ["); 
        for (Position p : vertices) {
            strings.add(p.toString());
        }
        strings.add("] size =" + size() + " length = " + length());
        
        String str = "";
        for (String string : strings){
            str += string;
        }
        return str;
    }

    public double getX(int i){
        return this.vertices.get(i).getX();
    }

    public double getY(int i){
        return this.vertices.get(i).getY();
    }

}
