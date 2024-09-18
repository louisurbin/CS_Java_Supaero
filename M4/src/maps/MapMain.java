package maps;

import geometry.Position;
import java.util.HashMap;

public class MapMain {
    public static void main(String[] args) {
    HashMap<String,Position> map = new HashMap<>();
    map.put("pos1", new Position(1,2));
    map.put("pos2", new Position(3,4));
    map.put("pos3", new Position(5,6));

    System.out.println(map);
    }
}
