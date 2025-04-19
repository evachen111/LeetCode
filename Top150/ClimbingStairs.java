package Top150;

import java.util.ArrayList;

// 70
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        ArrayList<Integer> list = new ArrayList<>();


        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();
        System.out.println(sol.climbStairs(3));
    }
}
