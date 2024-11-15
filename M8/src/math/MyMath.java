package math;

public class MyMath {
    public static double epsilon = 1e-6;
   
    public static double heron(double x){
        double xold = 1;
        double xnew = 0.5 * (xold + x/xold);
        while (Math.abs(xnew-xold) > epsilon){ 
            xold = xnew;
            xnew = 0.5 * (xold + x/xold);
        }
        return xnew;
    }

    public static double sqrt(double x) {
        if (x<0) {
            throw new IllegalArgumentException("x must be non-negative");
        }
        
        double result = heron(x);

        if (result < 0 || Math.abs(1-result*result/x) > epsilon){
            throw new ArithmeticException("Unexpected result in sqrt: " + result);
        }

        return result;
    }
}
