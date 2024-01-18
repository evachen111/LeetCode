package dynamic;

//122
public class BestTimeBuyandSellStockII {
    public int maxProfit(int[] prices) {
//        int[] dp = new int[prices.length];
//        dp[0] = 0;
//        for (int i = 1; i<prices.length; i++){
//            dp[i] = Math.max(dp[i-1], dp[i-1]+prices[i]-prices[i-1]);
//        }
//        return dp[prices.length-1];
        int max = 0;
        for (int i = 1; i<prices.length; i++){
            max = Math.max(max, max+prices[i]-prices[i-1]);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
