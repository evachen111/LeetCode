package Top150;

import java.util.Scanner;

public class OPPO01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stones = new int[n+2];
        stones[0] = 1;
        stones[n+1] = 1;
        for(int i = 0; i < n; i++){
            stones[i+1] = sc.nextInt();
        }
        int max = 1;
        int step = 1;
        for (int i = 0; i < n+2; i++) {
            if (stones[i] == 0) {
                step++;
            }
            else{
                 step = 1;
            }
            if (max < step) {
                max = step;
            }
        }
        System.out.println(max);
    }

}
