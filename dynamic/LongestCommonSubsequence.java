package dynamic;

//1143
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length()+1][text2.length()+1];
//
//        for (int i = 0; i<text1.length(); i++){
//            for (int j = 0; j<text2.length(); j++){
//                if (text1.charAt(i) == text2.charAt(j)){
//                    dp[i+1][j+1] = dp[i][j] +1;
//                }
//                else{
//                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
//                }
//            }
//        }
//        return dp[text1.length()][text2.length()];
        int[] dp = new int[text2.length()+1];

        for (int i = 0; i<text1.length(); i++){
            int pre = dp[0];
            for (int j = 0; j<text2.length(); j++){
                int cur = dp[j+1];
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[j+1] = pre +1;
                }
                else{
                    dp[j+1] = Math.max(dp[j], dp[j+1]);
                }
                pre = cur;
            }
        }
        return dp[text2.length()];
    }

    public static void main(String[] args) {
//        String a = "asd";
//        String b = "as";
//        System.out.println(a.charAt(0) == b.charAt(0)); // true
    }
}
