package OA;

import java.util.Scanner;

// check ACM mode
public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i<n; i++){
            String s = sc.next();
            System.out.println(s + '1');
        }
    }
}
