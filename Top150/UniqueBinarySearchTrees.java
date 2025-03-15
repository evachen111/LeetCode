package Top150;

// 96
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i<=n; i++){
            int l = 0, r = i-1;
            while (l <= r){
                if (l == r){
                    dp[i] += dp[l];
                }
                else{
                    dp[i] += 2*dp[l]*dp[r];
                }
                l++;
                r--;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees sol = new UniqueBinarySearchTrees();
        System.out.println(sol.numTrees(3));
    }
}
