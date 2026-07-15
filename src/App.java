public class App {
    public static void main(String[] args) throws Exception {
        runFibonaci();
        runFibonaciRecursivePD();
        runFibonaciIter();
        runFibonaciIter2();
    }
    
    private static void runFibonaciRecursivePD() {
        long startTime = System.nanoTime();
        int num = 48;
        long [] memo = new long[num + 1];
        long i = fibonacci(num, memo);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private
    private static long getFibonacciRecursivePD(int num, long[] cache) {
        return 0;
        
    }

    private static void runFibonaci() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciPD(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private static long getFibonacciPD(int i) {
        if (i <= 1) {
            return i;
        }
        return getFibonacciPD(i - 1) + getFibonacciPD(i - 2);
    }

    public static long fibonacci(int n , long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }
    public static long fibonaci2(int n){
        if (n <= 1) {
            return n;
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    private static long getFibonacciIter(int num) {
        if (num <= 1) {
            return num;
        }
        long [] memo = new long[num + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= num; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[num];
            
    }
   private static void runFibonaciIter() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciIter(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }
    private static void runFibonaciIter2() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciIter2(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }
    private static long getFibonacciIter2(int num) {
        if (num <= 1) {
            return num;
        }
        long a = 0;
        long b = 1;
        long res = 0;
        for (int i = 2; i <= num; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;


}
    
}