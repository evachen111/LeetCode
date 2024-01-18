package dynamic;

// 309
public class BestTimeBuyandSellStockCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }
        int[][] dp = new int[2][prices.length+1];
        dp[0][1] = -prices[0];
        for (int i = 2; i<=prices.length; i++){
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-2] - prices[i-1]);
            dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + prices[i-1]);
        }
        return dp[1][prices.length];
    }

    public static void main(String[] args) {

    }
}
