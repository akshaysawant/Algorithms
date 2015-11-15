import java.util.Scanner;

/**
 * Created by akshaysawant on 01/09/15.
 */
public class MaxProductRopeCut {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        System.out.println("MaxProductRopeCut(" + length + ") : " + maxProductRopeCut(length)) ;
        System.out.println("MaxProductRopeCutPowerFunction(" + length + ") : " + maxProductRopeCutPowerFunction(length)) ;
    }

    private static int maxProductRopeCut(int length) {

        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int[] products = new int[length+1];

        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int curProd, maxProd = 0;

        for (int i = 4; i < length+1; i++) {

            for (int j = 1; j < i; j++) {
                curProd = products[j] * products[i-j];

                if (curProd > maxProd) {
                    maxProd = curProd;
                }
            }

            products[i] = maxProd;
        }

        return products[length];
    }

    private static int maxProductRopeCutPowerFunction(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int times3 = length / 3;

        if ((length - times3*3) % 2 == 1) {
            times3--;
        }

        int times2 = (length - times3*3) / 2;

        return (int)(Math.pow(3, times3) * (int)Math.pow(2, times2));
    }
}
