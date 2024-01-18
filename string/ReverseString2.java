package string;

// 541
// each "newS = newS + xx; " creates a new String object, which is memory consuming
    // stringbuffer: sb.appenc();
public class ReverseString2 {
    public static String reverseStr(String s, int k) {
        String newS = new String();

        // base case
        if (s.length() < k){
            for (int i = s.length()-1; i>=0; i--){
                newS = newS + s.charAt(i);
            }
            return newS;
        }

        // traverse every 2k recursively
        for (int i = 0; i < s.length(); i = i + 2 * k) {
            if (i+k > s.length()) {
                newS = newS + reverseStr(s.substring(i),k);
                return newS;
            }
            else if (i+2*k > s.length()){
                newS = newS + reverseStr(s.substring(i+1, i+k), k) + s.charAt(i) + s.substring(i+k);
                return newS;
            }
            else{
                newS = newS + reverseStr(s.substring(i+1, i+k), k) + s.charAt(i) + s.substring(i+k, i+2*k);
            }
        }
        return newS;
    }

    public static void main(String[] args) {
        String s = new String();
        s = "abcdefg";
        System.out.println(s);
        System.out.println(reverseStr(s,2));
    }
}
