package dynamic;

// 647
public class PalindromicSubstrings {
    public boolean isPa(String s){
        int i = 0;
        while (i<=(s.length())/2){
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
            i++;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i<s.length(); i++){
            dp[i][i] = 1;
        }

        for (int i = s.length()-2; i>=0; i--){
            for (int j = i+1; j<s.length(); j++){
                dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                if (isPa(s.substring(i,j+1))){
                    dp[i][j]++;
                }
            }
        }

        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
//        char s = 'a';
//        char b = 'a';
//        System.out.println(s==b);
        PalindromicSubstrings sol = new PalindromicSubstrings();
        String s = "aba";
        System.out.println(sol.isPa(s));
        System.out.println(s.substring(0,1));
    }
}
