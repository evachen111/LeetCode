package string;

public class leftRotateString {
    public static String reverseLeftWords(String s, int n) {
        // sanity check

        int len = s.length();
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(n, len));
        sb.append(s.substring(0,n));

        return sb.toString();

    }

    public static void main(String[] args) {
        String s = new String("abcdefg");
        System.out.println(s);
        System.out.println(reverseLeftWords(s,2));
    }
}
