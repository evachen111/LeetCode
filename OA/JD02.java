package OA;

import java.util.Arrays;
import java.util.Scanner;

public class JD02 {

    public static int maxFat(int[] arr, int K){
        int N = arr.length;
        for (int i = 0; i<N; i++){
            arr[i] = (arr[i] == 1) ? 4:2;
        }
        //sanity check
        if (arr.length <=K){
            return Arrays.stream(arr).sum();
        }

        // dp[i][j]: 到达第 i 个位置，当前是在跑第j步，最大消耗脂肪
        int[][] dp = new int[N+1][K+1];
        // 初始化
        dp[0][0] = 0; //只服务于dp[2][1]
        // 遍历方式
        // 递推dp
        for (int i = 1; i <= N; i++) {
            // j = 0
            for(int k = 0; k<=Math.min(i,K); k++) {
                dp[i][0] = Math.max(dp[i][0],dp[i-1][k]);
            }
            dp[i][0]++;
            // j = 1 开跑
            if (i == 1){
                dp[i][1] = arr[i-1];
                continue;
            }
                // i>=2
//            dp[i][1] = dp[i-2][0] + arr[i-1] + 1;
            for (int j = 2; j <= i; j++) {
                dp[i][1] = Math.max(dp[i][1], dp[i - j][0] + j-1 + arr[i - 1]);
            }
            //else 一直在跑
            for(int j = 2; j <= Math.min(i,K); j++){
                dp[i][j] = dp[i-1][j-1] + arr[i-1];
            }
        }
        // find max
        int max = 0;
        for (int i = 0; i <= K; i++) {
            max = Math.max(max,dp[N][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        JD02 sol = new JD02();
        int k = 5;
//        int[] arr = {1, 0, 1, 0, 0, 1, 1};
//        int[] arr = {0,0,1,1,0,0,0,0,0};
        int[] arr = {0,0,1,1,0,1,1,1,1};
        System.out.println(sol.maxFat(arr, k));

//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i<n; i++){
//            arr[i] = in.nextInt();
//        }
    }
}
