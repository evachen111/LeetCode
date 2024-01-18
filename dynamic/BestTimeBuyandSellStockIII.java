package dynamic;

//123
public class BestTimeBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }
//        int[] dp = new int[prices.length];
//        // 1
//        dp[0] = -prices[0];
//        for (int i = 1; i<prices.length; i++){
//            dp[i] = Math.max(dp[i-1], dp[i]-prices[i]);
//        }
//        // 2
//        for (int i = 1; i<prices.length; i++){
//            dp[i] = Math.max(dp[i-1], dp[i]+prices[i]);
//        }
//        // 3
//        dp[0] = -prices[0];
//        for (int i = 1; i<prices.length; i++){
//            dp[i] = Math.max(dp[i-1], dp[i]-prices[i]);
//        }
//        // 4
//        for (int i = 1; i<prices.length; i++){
//            dp[i] = Math.max(dp[i-1], dp[i]+prices[i]);
//        }
//        return dp[prices.length-1];

        // simplified
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = -prices[0];
        for (int i = 1; i<prices.length; i++){
            dp[1] = Math.max(dp[1], dp[0]-prices[i]);
            dp[2] = Math.max(dp[2], dp[1]+prices[i]);
            dp[3] = Math.max(dp[3], dp[2]-prices[i]);
            dp[4] = Math.max(dp[4], dp[3]+prices[i]);
        }
        return dp[4];
    }

    public static void main(String[] args) {
        BestTimeBuyandSellStockIII sol = new BestTimeBuyandSellStockIII();
        int[] a = {3,3,5,0,0,3,1,4};
        System.out.println(sol.maxProfit(a));
    }
}
