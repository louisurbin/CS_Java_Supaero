package lists;

import java.util.ArrayList;

public class FindMinDoubleMain {
    public static void main(String[] args){
        ArrayList<Double> list = new ArrayList<>();
        list.add(2.0);
        list.add(4.0);
        list.add(1.0);
        list.add(3.0);
    
        double min =  Double.POSITIVE_INFINITY;

        for(double d : list){
            if(d<min){
                min = d;
            }
        }
        System.out.println(min);
    }
}

