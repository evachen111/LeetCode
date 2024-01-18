package string;

//459
public class RepeatedSubstringPattern {
    private static void getNext(int[] next, String s){
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++){
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] next = new int[len];
        getNext(next,s);

        System.out.println(len);
        System.out.println(len - next[len-1]);
        if (next[len-1]!=0 && len % (len - next[len-1]) == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = new String("abac");
        System.out.println(repeatedSubstringPattern(s));
    }

}
