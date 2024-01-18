package Grind75;

// 1137
public class N_thTribonacciNumber {
    public int[] t;

//    public int dyn(int n) {
//        if (n == 0 || t[n] != 0){
//            return t[n];
//        }
//        return dyn(n-1)+dyn(n-2)+dyn(n-3);
//    }

    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n==2){
            return 1;
        }
        t = new int[n+1];
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;
        for (int i = 3; i<=n; i++){
            t[i] = t[i-1]+t[i-2]+t[i-3];
        }
        return t[n];
    }

    public static void main(String[] args) {
        N_thTribonacciNumber sol = new N_thTribonacciNumber();
        System.out.println(sol.tribonacci(35));
    }
}
