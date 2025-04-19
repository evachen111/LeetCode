package OA;

import java.util.Scanner;

public class pdd01 {

    public static String isLucky(char[] ch){
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1'){
                cnt++;
                if (cnt > max){
                    max = cnt;
                }
            }
            else{
                cnt = 0;
            }
        }
        if (max == 9){
            return "lucky";
        }
        return "unlucky";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int b = in.nextInt();
            char[] ch = in.next().toCharArray();
            System.out.println(isLucky(ch));
        }
    }
}
