package dynamic;

//115
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()][s.length()+1];

        for (int j = 0; j<s.length(); j++){
            if (t.charAt(0) == s.charAt(j)){
                dp[0][j+1] = dp[0][j] + 1;
            }
            else{
                dp[0][j+1] = dp[0][j];
            }
        }

        for (int i = 1; i<t.length(); i++){
            for (int j = 0; j<s.length(); j++){
                if (t.charAt(i) == s.charAt(j)){
                    dp[i][j+1] = dp[i-1][j] + dp[i][j];
                }
                else {
                    dp[i][j+1] = dp[i][j];
                }
            }
        }
        return dp[t.length()-1][s.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        DistinctSubsequences sol = new DistinctSubsequences();
        System.out.println(sol.numDistinct(s,t));
    }
}
