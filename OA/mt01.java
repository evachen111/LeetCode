package OA;

import java.util.Scanner;

public class mt01 {
    public static int countPack(String s, int k){
        int[] arr = new int[26];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++){
            if (arr[s.charAt(i) - 'a'] < k){
                arr[s.charAt(i) - 'a']++;
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        System.out.println(countPack(s,k));
    }
}
