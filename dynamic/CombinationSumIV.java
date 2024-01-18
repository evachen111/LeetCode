package dynamic;

//377
// permutation?
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int j = 1; j<=target; j++){
            for (int i = 0; i<nums.length; i++){
                if (j>=nums[i]){
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        CombinationSumIV sol = new CombinationSumIV();
        System.out.println(sol.combinationSum4(a,4));
    }
}
