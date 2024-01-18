package dynamic;

import java.util.Arrays;

//322
// dp[j] = min(dp[j], dp[j-coins[i]] + 1);
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        // no need to sort coins[]
        for (int i = 0; i<coins.length; i++){
            for (int j = 1; j<=amount; j++){
                if (j>=coins[i]){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]] + 1);
                }
            }
        }
        if (amount >0 && dp[amount] == 10001){
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {

    }
}
