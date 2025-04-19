package OA;

import java.util.Scanner;

// 先不要去考虑复杂度
public class aq36001 {

    public static String checkStr(String s1, String s2){

        for (int i = 0; i < s1.length(); i++) {
            for (int j = i; j < s1.length(); j++) {
                StringBuffer sb1 = new StringBuffer(s1);
                StringBuffer sb2 = new StringBuffer(s2);
                String add = s1.substring(i, j+1);
                if (sb2.append(add).toString().equals(sb1.delete(i,j+1).toString())){
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {

        String s1 = "acddcd";
        String s2 = "ad";
        System.out.println(checkStr(s1, s2));

//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        for (int i = 0; i < num; i++) {
//            int m = sc.nextInt();
//            int n = sc.nextInt();
//            String s1 = sc.next();
//            String s2 = sc.next();
//            System.out.println(checkStr(s1, s2));
//        }
    }
}
