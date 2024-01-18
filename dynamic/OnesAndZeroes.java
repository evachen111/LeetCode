package dynamic;

///474
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] ones = new int[strs.length];
        int[] zeros = new int[strs.length];
        for(int j = 0; j<strs.length; j++){
            for (int i = 0; i<strs[j].length(); i++){
                if (strs[j].charAt(i) == '1'){
                    ones[j] += 1;
                }
                else{
                    zeros[j] += 1;
                }
            }
        }
        // seperate 0 and 1, wrong
//        // 0
//        int[] dp1 = new int[m+1];
//        int[] dp2 = new int[n+1];
//        for (int i = 0; i<strs.length; i++){
//            for (int j = m; j>0; j--){
//                if (j>=zeros[i]){
//                    dp1[j] = Math.max(dp1[j], dp1[j-zeros[i]]+1);
//                }
//            }
//        }
//        // 1
//        for (int i = 0; i<strs.length; i++){
//            for (int j = n; j>0; j--){
//                if (j>=ones[i]){
//                    dp2[j] = Math.max(dp2[j], dp2[j-ones[i]]+1);
//                }
//            }
//        }
//        // return min
//        return Math.min(dp1[m], dp2[n]);

        int[][] dp = new int[n+1][m+1];
        for (int x = 0; x<strs.length; x++){
            for (int i = n; i>=0; i--){
                for (int j = m; j>=0; j--){
                    if (i>=ones[x] && j>= zeros[x]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-ones[x]][j-zeros[x]]+1);
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        OnesAndZeroes sol = new OnesAndZeroes();
        String[] ss = {"10","0","1"};
        System.out.println(sol.findMaxForm(ss, 1,1));
    }
}
