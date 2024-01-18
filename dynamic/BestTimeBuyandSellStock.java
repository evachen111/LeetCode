package dynamic;

import java.util.Map;

//121
public class BestTimeBuyandSellStock {
    public int maxProfit(int[] prices) {
        //greedy
//        int min = prices[0];
//        int max = 0;
//        for (int i = 1; i<prices.length; i++){
//            if (prices[i] < min){
//                min = prices[i];
//            }
//            if (prices[i] - min > max){
//                max = prices[i] - min;
//            }
//        }
//        return max;

        // dynamic
//        int[][] dp =  new int[prices.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        for (int i = 1; i<prices.length; i++){
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
//        }
//        return dp[prices.length-1][0];

        // improved
        int[] dp =  new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i<prices.length; i++){
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}
