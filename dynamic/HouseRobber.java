package dynamic;

// 198
// dp[j] = max(dp[j-1], dp[j-2] + nums[j])
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length ==1){
            return nums[0];
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int j = 2; j<dp.length; j++){
            dp[j] = Math.max(dp[j-1], dp[j-2] + nums[j-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        
    }
}
