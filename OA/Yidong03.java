package OA;public class Yidong03 {
    public int breakInteger(int n) {
        int[][] memo = new int[n+1][n+1];
        int cnt;
        for (int i = n; i >=1; i--) {
            memo[i][i] = 1;
            for (int j = i+1; j <=n; j++) {
                cnt = 1;
                for (int k = i; k <= j/2; k++) {
                    cnt += memo[k][j-k];
                }
                memo[i][j] = cnt;
            }
        }
        return memo[1][n];
    }
    public int breakInteger1d(int n) {
        int[][] memo = new int[n+1][n+1];
        int cnt;
        for (int i = n; i >=1; i--) {
            memo[i][i] = 1;
            for (int j = i+1; j <=n; j++) {
                cnt = 1;
                for (int k = i; k <= j/2; k++) {
                    cnt += memo[k][j-k];
                }
                memo[i][j] = cnt;
            }
        }
        return memo[1][n];
    }


    public static void main(String[] args) {
        Yidong03 sol = new Yidong03();
        System.out.println(sol.breakInteger(9));
    }
}
