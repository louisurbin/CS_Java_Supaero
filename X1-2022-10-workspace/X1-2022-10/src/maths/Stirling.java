package maths;

public class Stirling {
    public static double factorial(int n){
        return Math.sqrt(2*Math.PI*n)*Math.pow(n/Math.E,n)*(1+1./(12*n));
    }
}
