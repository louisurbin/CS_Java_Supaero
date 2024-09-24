package algos;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsAlgorithmsMain {
    public static void main (String[] args) {
        ArrayList<Double> list = new ArrayList();

        for (int i = 0; i<5 ; i++) {
            list.add(Math.random());
        }

        System.out.println(list);
        
        Collections.sort(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));

    }
}