package string;

public class ReverseString {
    public static void reverseString(char[] s) {
//        for (int i = 0; i<s.length/2; i++){
//
//        }
        int i = 0;
        int j = s.length-1;
        while(i<j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e', 'l', 'l', 'o'};
        for (char i: s){
            System.out.print(i);
        }
        reverseString(s);

        System.out.println("\n======");
        for (char i: s){
            System.out.print(i);
        }
    }
}
