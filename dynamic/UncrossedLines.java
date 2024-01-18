package dynamic;

// 1035
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length+1];

        for (int i = 0; i<nums1.length; i++){
            int pre = dp[0];
            for (int j = 0; j<nums2.length; j++){
                int cur = dp[j+1];
                if (nums1[i] == nums2[j]){
                    dp[j+1] = pre +1;
                }
                else{
                    dp[j+1] = Math.max(dp[j], dp[j+1]);
                }
                pre = cur;
            }
        }
        return dp[nums2.length];
    }

    public static void main(String[] args) {

    }
}
