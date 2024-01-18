package basic;


import java.util.Scanner;

public class inputAndOutput {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input an integer: ");
        int num = scanner.nextInt();
        System.out.println("the integer you input is: " + num);
}

}
