package dynamic;

// 718
public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int max = 0;
//        for(int i = 0; i<nums1.length; i++){
//            if (nums1[i] == nums2[0]){
//                dp[i][0] = 1;
//                max = 1;
//            }
//        }
//        for(int j = 0; j<nums2.length; j++){
//            if (nums1[0] == nums2[j]){
//                dp[0][j] = 1;
//                max = 1;
//            }
//        }
        for(int i = 0; i<nums1.length; i++){
            for (int j = 0; j<nums2.length; j++){
                if (nums1[i] == nums2[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i+1][j+1]);
                }
                else{
                    dp[i+1][j+1] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
