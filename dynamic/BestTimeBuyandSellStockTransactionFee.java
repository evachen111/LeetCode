package dynamic;

// 714
public class BestTimeBuyandSellStockTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1){
            return 0;
        }
        int[][] dp = new int[2][prices.length];
        dp[0][0] = -prices[0];
        for (int i = 1; i<prices.length; i++){
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] - prices[i]);
            dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + prices[i] - fee);
        }
        return dp[1][prices.length-1];
    }
    public static void main(String[] args) {

    }
}
