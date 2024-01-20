package Grind75;

// 746
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i<=cost.length; i++){
            dp[2] = Math.min(dp[0] + cost[i-1], dp[1] + cost[i-2]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }

    public static void main(String[] args) {

    }

}
