package datapool;

public class DataPoolMain {
    public static void main(String[] args) {
        DataPool<String> datapool1 = new DataPool(3);
        datapool1.add("A");
        datapool1.add("B");
        datapool1.add("C");
        datapool1.add("D");
        System.out.println(datapool1.toString());

        DataPool<String> datapool2 = new DataPool(3);

        datapool2.add("A");
        datapool2.add("B");
        datapool2.add("C");
        datapool2.remove(2);
        datapool2.add("D");
        System.out.println(datapool2.toString());

        System.out.println(datapool2.isFull());
        System.out.println(datapool2.occupancyPercentage());
        System.out.println(datapool2.get(2));
    }
}
