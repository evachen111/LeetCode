package dynamic;

// 72
public class EditDistance {
    public int minDistance(String word1, String word2) {
//        if (word1.length() == 0){
//            return word2.length();
//        }
//        if (word2.length() == 0){
//            return word1.length();
//        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];

//        if (word1.charAt(0) == word2.charAt(0)){
//            dp[0][0] = 0;
//        }
//        else{
//            dp[0][0] = 1;
//        }
//        for (int i = 1; i<word1.length(); i++){
//            if (word1.charAt(i) == word2.charAt(0)){
//                dp[i][0] = dp[i-1][0];
//            }
//            else{
//                dp[i][0] = dp[i-1][0] + 1;
//            }
//        }
//        for (int j = 1; j<word2.length(); j++){
//            if (word1.charAt(0) == word2.charAt(j)){
//                dp[0][j] = dp[0][j-1];
//            }
//            else{
//                dp[0][j] = dp[0][j-1] + 1;
//            }
//        }

        for (int i = 0; i<=word1.length(); i++){
            dp[i][0] = i;
        }

        for (int j = 1; j<=word2.length(); j++){
            dp[0][j] = j;
        }

        for (int i = 1; i<=word1.length(); i++){
            for (int j = 1; j<=word2.length(); j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+ 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

        EditDistance sol = new EditDistance();
        String a = "mmicroscopicsilic";
        String b = "microscopically";
        System.out.println(sol.minDistance(a,b));

    }
}
