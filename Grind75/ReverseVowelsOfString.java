package Grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 345
public class ReverseVowelsOfString {

    public static final List<Character> vowels = new ArrayList<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
    ));

    public String reverseVowels(String s) {
        StringBuffer sb = new StringBuffer(s);
        int i = 0;
        int j = s.length()-1;

        while (i<j){
            while (i < s.length()-1 && !vowels.contains(s.charAt(i))){
                i++;
            }
            while (j >0 && !vowels.contains(s.charAt(j))){
                j--;
            }

            if (i<j){
                sb.setCharAt(i, s.charAt(j));
                sb.setCharAt(j, s.charAt(i));
                i++;
                j--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = ".,";
        ReverseVowelsOfString sol = new ReverseVowelsOfString();
        System.out.println(sol.reverseVowels(s));
    }
}
