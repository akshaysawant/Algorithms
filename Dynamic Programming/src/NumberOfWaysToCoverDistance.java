/**
 * Created by akshaysawant on 15/11/15.
 */
public class NumberOfWaysToCoverDistance {

    public static void main(String[] args) {
        int distance = 6;
        System.out.println("Number of Ways to Cover Distance : " + distance + " with steos 1, 2 and 3 are : " + countWaysToDistance(distance));
    }

    private static int countWaysToDistance(int distance) {
        int[] steps = new int[]{1, 2, 3};
        int[] countDistance = new int[distance+1];
        int count, diff;

        countDistance[0] = 0;
        countDistance[1] = 1;

        for (int i = 2; i < distance+1; i++) {
            count = 0;
            for (int j = 0; j < steps.length; j++) {
                if (i >= steps[j]) {
                    count += countDistance[i - steps[j]];
                }
            }

            countDistance[i] = count;
            System.out.println("distance : " + i + " | ways : " + countDistance[i]);
        }

        return countDistance[distance];
    }
}
