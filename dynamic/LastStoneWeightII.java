package dynamic;


import java.util.Arrays;
import java.util.stream.Stream;

//1049
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int[] dp = new int[sum/2+1];      // "+1"
        for (int i = 0; i < stones.length; i++){
            for (int j = sum/2; j>=stones[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        int max = 0;
        for (int j = 0; j<=sum/2; j++){
            if (dp[j] > max){
                max = dp[j];
            }
        }

        return sum-max;
    }

    public static void main(String[] args) {

    }
}
