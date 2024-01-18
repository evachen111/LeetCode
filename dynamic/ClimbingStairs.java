package dynamic;

//70
// ways[n] = ways[n-1] + ways[n-2]
public class ClimbingStairs {
    public int climbStairs(int n) {
//        int[] ways = new int[n+1];
//        ways[0] = 1;
//        ways[1] = 1;
//        for (int i = 2; i<=n; i++){
//            ways[i] = ways[i-1] + ways[i-2];
//        }
//        return ways[n];
        if (n ==1){
            return 1;
        }
        int f = 1;
        int s = 1;
        for (int i = 2; i<=n; i++){
            int tmp = s;
            s = s+f;
            f = tmp;
        }
        return s;
    }

    public static void main(String[] args) {

    }
}
