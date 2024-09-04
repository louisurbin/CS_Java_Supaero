public class FactorielleMain {
        public static void main(String[] args) throws Exception {
            int n = 5 ;
            int fact = 1 ;
            int i = 1 ;
            while (i<=n) {
                fact = fact * i ;
                i++ ;
            }
            System.out.println(fact);

            fact = 1 ;

            for (int j = 1; j <= n; j++) {
                fact = fact * j ;
            }
            System.out.println(fact);
        }
}
