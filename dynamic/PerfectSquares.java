package dynamic;

import java.util.Arrays;

// 279
// dp[j] = min(dp[j], dp[j-nums[i]]+1)
public class PerfectSquares {
    public int numSquares(int n) {
        int[] nums = new int[(int)Math.sqrt(n)];
        for (int i = 0; i<nums.length; i++){
            nums[i] = (i+1)*(i+1);
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,10000);
        dp[0] = 0;
        for (int i = 0; i<nums.length; i++){
            for (int j = 0; j<=n; j++){
                if (j>=nums[i]){
                    dp[j] = Math.min(dp[j], dp[j-nums[i]]+1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares sol = new PerfectSquares();
        System.out.println(sol.numSquares(12));
    }
}
