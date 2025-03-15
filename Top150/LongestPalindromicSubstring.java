package Top150;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (i + 1 == j){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j] == 1 && j-i+1 > max){
                    max = j-i+1;
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cddb";
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        System.out.println(sol.longestPalindrome(s));
    }
}
