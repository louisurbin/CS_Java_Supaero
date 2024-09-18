package maps;

import geometry.Position;
import java.util.ArrayList;
import java.util.HashMap;

public class MapListMain {
    public static void main(String[] args) {
        HashMap<String,ArrayList<Position>> maplist = new HashMap<>();
        
        ArrayList<Position> list1 = new ArrayList<>();
        list1.add(new Position(1, 2));
        list1.add(new Position(3, 4));
        list1.add(new Position(5, 6));
        
        ArrayList<Position> list2 = new ArrayList<>();
        list2.add(new Position(7, 8));
        list2.add(new Position(9, 10));
        list2.add(new Position(11, 12));
        
        ArrayList<Position> list3 = new ArrayList<>();
        list3.add(new Position(13, 14));
        list3.add(new Position(15, 16));
        list3.add(new Position(17, 18));
        
        maplist.put("list1", list1);
        maplist.put("list2", list2);
        maplist.put("list3", list3);

        System.out.println(maplist);
    }
}
