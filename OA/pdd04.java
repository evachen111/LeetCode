package OA;

import java.util.Scanner;

public class pdd04 {
    public static int maxDiscount(int n, int m, int[] prices, int[] min, int[] max) {
        int[][] discount = new int[n][m];
        for (int i = 0; i < m; i++) { // coupons
            for (int j = 0; j < n; j++) { //objects
                if (prices[j] > min[i]) {
                    discount[i][j] = max[i];
                }
            }
        }
        for (int j = 0; j < n; j++) { //objects
            for (int i = 0; i < m; i++) { // coupons

            }
        }

        return 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] prices = new int[n];
        int[] min = new int[m];
        int[] reduce = new int[m];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            min[i] = in.nextInt();
            reduce[i] = in.nextInt();
        }
        System.out.println(maxDiscount(n,m,prices,min,reduce));
    }
}