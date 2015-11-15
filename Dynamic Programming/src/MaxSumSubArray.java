
/**
 * Created by akshaysawant on 31/08/15.
 * Test Input : 1 -2 3 10 -4 7 2 -5
 */
public class MaxSumSubArray {
    public static void main(String args[]) {

        String array = "1 -2 3 10 -4 7 2 -5 10";
        String[] a = array.split(" ");

        int[] n = new int[a.length];

        int i = 0;
        for (String num : a) {
            n[i++] = Integer.parseInt(num);
        }

        System.out.println("MaxSumSubArray(" + array + ") : " + maxSumSubArray(n));
    }

    private static int maxSumSubArray(int[] array) {
        int prevSum = 0, sum = 0;

        for (int num : array) {
            sum += num;

            if (sum < num) {
                // Start a new sequence.
                sum = num;
            } else if (sum > prevSum) {
                // Increment current sequence.
                prevSum = sum;
            }
        }

        return (prevSum > sum) ? prevSum : sum;
    }
}
