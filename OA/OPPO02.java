package OA;

import java.util.Scanner;

// a|b>=a
public class OPPO02 {
//    public static int bitOr(int[] a, int x, int y){
//        int res = 0;
//        for (int i = x; i <= y; i++){
//            res |= a[i];
//        }
//        return res;
//    }
//    public static int minSeg(int[] a, int k){
//        int ans = 1;
//        int[][] res = new int[a.length][a.length];
//        for (int i = 0; i < a.length; i++){
//            for (int j = 0; j < a.length; j++){
//                res[i][j] = bitOr(a,i,j);
//            }
//        }
//        int i = 0;
//        while (i >=0 && i<res.length){
//            int tmp = 0;
//            int j = i;
//            while(j < res.length){
//                if (res[j][i] >k){
//                    return -1;
//                }
//                tmp += res[i][j];
//                if (tmp >k){
//                    ans++;
////                    i=j;
//                    break;
//                }
//                j++;
//            }
//            i = j;
//        }
//
//        return ans;
//    }

    public static int minSeg(int[] a, int k){
        int cnt = 1;
        int i = 0;
        int r = a.length;
        int cur = 0;
        while (i < r){
            System.out.println(i);
            if (a[i] > k){
                return -1;
            }
            cur |= a[i];
            if (cur > k){
                cnt++;
                cur = 0;
                continue; // 重新处理当前i
            }
            i++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int k = sc.nextInt();
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        System.out.println(minSeg(a,k));
//        System.out.println(bitOr(a,3,3));

    }
}
