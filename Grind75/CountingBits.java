package Grind75;

// 338
public class CountingBits {
    public int[] re;
    public int[] countBits(int n) {
        re = new int[n+1];
        re[0] = 0;

        for (int i = 0; Math.pow(2,i)<=n; i++){
            int idx = (int)Math.pow(2,i);
            for (int j = 0; j<=idx; j++){
                if (idx+j>n){
                    return re;
                }
                re[idx+j] = re[j] + 1;
            }
        }

        return re;
    }

    public static void main(String[] args) {

    }
}
