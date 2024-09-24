package arrays;

public class FindMinMain {
    public static void main(String[] args) {
        int[] array = { 6, 3, 14, 2, 8, 6, 9 };
        int min = Integer.MAX_VALUE;
        for(int value : array) {
            if(value < min) {
            min = value;
            }
        }
        System.out.println(min);
    }   
 }
    
