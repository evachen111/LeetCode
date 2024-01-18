package dynamic;

//583
public class DeleteOperationforTwoStrings {
    public int LCS(String text1, String text2) {
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
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length()-2*LCS(word1, word2);
    }

    public static void main(String[] args) {

    }
}
