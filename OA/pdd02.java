package OA;

import java.util.Scanner;

public class pdd02 {
    public static int minCp(int n, long m, int k){
        int min;
        if (k%2 == 0){
            min = k/2-1;
        }
        else{
            min = k/2;
        }
        int i = 0;
        int cnt = (i*k + min)*n;
        int mincp = 0;
        while (cnt <m){
            i++;
            for (int j = 1; j <= n; j++){
                cnt-=((i-1)*k + min);
                cnt+=(i*k + min);
                mincp++;
                if (cnt >=m){
                    return mincp;
                }
            }
        }
        return mincp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();
        int[] n = new int[lines];
        long[] m = new long[lines];
        int[] k = new int[lines];
        for (int i = 0; i < lines; i++) {
            n[i] = in.nextInt();
            m[i] = in.nextLong();
            k[i] = in.nextInt();
        }
        for (int i = 0; i < lines; i++) {
            System.out.println(minCp(n[i],m[i],k[i]));
        }
    }
}
