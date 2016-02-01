package nl.hanze.web.rmi;

import java.util.Arrays;

/**
 * Created by Andre on 17-12-2015.
 */
public class run {
    public static void main(String[] args) {
        coinChange(25, new int[]{ 5, 10, 15, 20 }, new int[]{ 2, 1, 1, 1 });
    }

    public static void coinChange(int max_value, int coins[], int count[]) {
        int coins_sz = coins.length;
        int dp[] = new int[max_value + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int partial_sum = 0;

        for (int i = 0; i < coins_sz; i++) {
            partial_sum += coins[i] * count[i];
            for (int j = coins[i]; j <= partial_sum && j <= max_value; j++) {
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }

        for (int i = 1; i <= max_value; i++) {
            System.out.println("Coin value = " + i + ", Minimum number of coins = " + dp[i]);
        }
    }
}
