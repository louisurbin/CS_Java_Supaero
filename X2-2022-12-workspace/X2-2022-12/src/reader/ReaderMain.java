package reader;

import java.util.List;

public class ReaderMain {

   public static void main(String[] args) throws Exception {
      List<Double> doubles = new DoubleReader().read("X2-2022-12/data/doubles.txt");
      System.out.println(doubles);

      List<Position> positions = new PositionCSVReader().read("X2-2022-12/data/positions.csv");
      System.out.println(positions);
   }
   
}
