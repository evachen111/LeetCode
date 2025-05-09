package OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class mt02 {
    public static long[] result;
    public static long back(long x){
        return x & (-x);
    }

    public static long allCost(long x, long cost){
        long b = back(x);
        if (b == 0){
            return cost;
        }

        return allCost(x-b, cost | Math.max(0,b-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] qs = new long[n];
        long[] as = new long[n];
        long max = 0;
        for(int i = 0; i < n; i++){
            qs[i] = sc.nextLong();
            max = Math.max(max,qs[i]);
        }

        result = new long[(int) (max+1)];
        for(int i = 0; i < n; i++){
            for (int j = 1; j <= qs[i]; j++){
                if (result[j] != 0){
                    as[i] += result[j];
                }
                else{
                    long allcost = allCost(j,j);
                    as[i] += allcost;
                    result[j] = allcost;
                }
            }
        }
        for(int i = 0; i < n-1; i++){
            System.out.print(as[i]);
            System.out.print(' ');
        }
        System.out.print(as[n-1]);
    }
}

