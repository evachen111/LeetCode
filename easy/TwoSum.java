package easy;

import java.lang.reflect.Array;
import java.util.Scanner;

/*
输入：Scanner class
 */
public class TwoSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();

        String[] nums = str.split(","); // '' for char, "" for string??
        System.out.println(nums[2]);
        //System.out.println(str); //[1,2,3]
        //System.out.println(nums); //[Ljava.lang.String;@119d7047
        System.out.println(target);


    }

}
