import java.util.Scanner;

/**
 * Created by akshaysawant on 31/08/15.
 */
public class Fibonacci {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println("Fibonacci(" + n + ") : " + fibonacci(n)) ;
        System.out.println("FibonacciMatrix(" + n + ") : " + fibonacciMatrix(n)) ;
        System.out.println("FibonacciLogN(" + n + ") : " + fibonacciLogN(n)) ;
    }

    private static int fibonacci(int n) {
        int prevPrev = 0, prev = 1, current = 0;

        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return prevPrev;
        } else if (n == 1) {
            return prev;
        } else {
            for (int i = 2; i <= n; i++) {
                current = prevPrev + prev;
                prevPrev = prev;
                prev = current;
            }
            return current;
        }
    }

    private static int fibonacciMatrix(int n) {
        int[][] F = {{1,1},{1,0}};

        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else {
            F = power(F, n-1);
            return F[0][0];
        }
    }

    private static int fibonacciLogN(int n) {
        int[][] F = {{1,1},{1,0}};

        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else {
            F = powerLogN(F, n-1);
            return F[0][0];
        }
    }

    private static int[][] power(int[][] F, int power) {
        int[][] M = {{1,1},{1,0}};

        for (int i = 2; i <= power; i++) {
            F = multiply(F, M);
        }
        return F;
    }

    private static int[][] powerLogN(int[][] F, int power) {
        int[][] M = {{1,1},{1,0}};

        if (power == 0 || power == 1) {
            return M;
        }
        F = powerLogN(F, power/2);
        F = multiply(F, F);

        if (power % 2 != 0) {
            F = multiply(F, M);
        }

        return F;
    }

    private static int[][] multiply(int[][] M1, int[][] M2) {
        int[][] result = new int[2][2];

        result[0][0] = M1[0][0] * M2[0][0] + M1[0][1] * M2[1][0];
        result[0][1] = M1[0][0] * M2[0][1] + M1[0][1] * M2[1][1];
        result[1][0] = M1[1][0] * M2[0][0] + M1[1][1] * M2[1][0];
        result[1][1] = M1[1][0] * M2[0][1] + M1[1][1] * M2[1][1];

        return result;
    }
}
