package OA;

import java.util.Scanner;

public class OPPO03 {
    public static int findSubstrings(String s) {
        int[] for5 = new int[s.length()];
        int[] for45 = new int[s.length()];
        int res = 0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == '5') {
                if (i + 1<s.length()) {
                    for45[i] = for45[i+1];

                    for5[i] = for5[i+1]+1;
                }
                else{
                    for5[i] = 1;
                }
            }
            else if (s.charAt(i) == '4' && i + 1<s.length()) {
                for5[i] = for5[i+1];

                for45[i] = for5[i] + for45[i+1];
            }
            else if (s.charAt(i) == '1' && i + 1<s.length() && s.charAt(i+1) == '1') {
                for5[i] = for5[i+1];
                for45[i] = for45[i+1];

                res += for45[i];
            }
            else if (i + 1<s.length()){
                for5[i] = for5[i+1];
                for45[i] = for45[i+1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(findSubstrings(s));
    }

}
