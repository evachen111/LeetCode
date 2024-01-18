package dynamic;

// 188

public class BestTimeBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int[] dp = new int[2*k+1];
        for (int j = 1; j<dp.length; j = j+2){
            dp[j] = -prices[0];
        }
        for (int i = 1; i<prices.length; i++){
            int x = -1;
            for (int j = 1; j<dp.length; j++){
                dp[j] = Math.max(dp[j], dp[j-1] + x*prices[i]);
                x = -x;
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {

    }
}
