/**
 * Created by akshaysawant on 14/11/15.
 */
public class CoinChange {
    public static void main(String args[]) {

        int[] v = new int[]{1, 5, 10, 25, 50, 100};

        int money = 892;
        System.out.println("Minimum Coins for money : " + money + " is : " + coinChange(v, money));
    }

    private static int coinChange(int[] vi, int money) {
        int maxCoin = 0, countSize;
        // Get max coin value.
        for (int v : vi) {
            if (v > maxCoin) {
                maxCoin = v;
            }
        }

        // Determine size of the count[] array.
        if (maxCoin > money) {
            countSize = maxCoin;
        } else {
            countSize = money;
        }

        int[] count = new int[countSize+1];
        int curCount, minCount;

        // Initialize all counts to index of count.
        // This is because for any amount, max coins will be amount number of coins.
        for (int i = 0; i < money+1; i++) {
            count[i] = i;
        }

        // Initiialize count for each Vi to 1.
        for (int v : vi) {
            count[v] = 1;
        }

        for (int i = 1; i < money+1; i++) {
            if (count[i] == 1) {
                continue;
            } else {
                minCount = count[i];
                for (int v : vi) {
                    if (v > i)
                        break;

                    curCount = count[i-v] + 1;

                    if (curCount < minCount) {
                        minCount = curCount;
                    }
                }
                count[i] = minCount;
            }
        }

        return count[money];
    }
}
