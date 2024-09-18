package lists;

import java.util.ArrayList;

public class FindMinStringMain {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("i");
        list.add("jgtkl");
    
        String min = null;

        for(String s : list){
            if(min == null || s.compareTo(min) < 0){
                min = s;
            }
        }
        System.out.println(min);
    }
}
