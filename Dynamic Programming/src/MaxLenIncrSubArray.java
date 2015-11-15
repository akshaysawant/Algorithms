import java.util.HashMap;

/**
 * Created by akshaysawant on 31/08/15.
 * Test Input : 7 2 3 1 5 8 9 6
 */
public class MaxLenIncrSubArray {
    public static void main(String args[]) {

        //String array = "1 -2 3 10 -4 7 2 -5 10";
        String array = "7 2 3 1 5 8 9 6";
        String[] a = array.split(" ");

        int[] n = new int[a.length];

        int i = 0;
        for (String num : a) {
            n[i++] = Integer.parseInt(num);
        }

        System.out.println("MaxLenIncrSubArray(" + array + ") : " + maxLenIncrSubArray(n));
    }

    private static int maxLenIncrSubArray(int[] array) {
        int prevLen = 1, curLen = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                // Start a new sequence.
                curLen = 1;
            } else if (array[i] >= array[i-1]) {
                // Increment current sequence.
                curLen++;

                if (curLen > prevLen) {
                    prevLen = curLen;
                }
            }
        }

        return (prevLen > curLen) ? prevLen : curLen;
    }
}
