package arrays;

import java.util.Arrays;

public class PascalMain {   
    public static void main(String[] args) {
        int n = 5;
        int[][] pascal = new int[n][];
        for (int row = 0; row < pascal.length; row++) {
            pascal[row] = new int[row + 1];
            pascal[row][0] = 1;
                for (int col = 1; col < row; col++) {
                    pascal[row][col] = pascal[row - 1][col - 1] + pascal[row - 1][col];
                }
            pascal[row][row] = 1;
        System.out.println(Arrays.toString(pascal[row]));
        }
    }
}
