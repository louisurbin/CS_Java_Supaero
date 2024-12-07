package rationals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class RationalReader  {
    
    public static List<Rational> read(String filename) throws IOException {
        List<Rational> list = new ArrayList<>();
        try (FileReader in = new FileReader(filename);
             BufferedReader bin = new BufferedReader(in)) {
            String line;
            while ((line = bin.readLine()) != null) {
                String[] tokens = line.split(" ");
				for (String token : tokens) {
                    Rational r = Rational.parseRational(token);
                    list.add(r);
                }
            }
        }
        return list;
    }
}
