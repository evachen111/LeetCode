package Grind75;

// 392
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // sanity check // order matters
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }

        int j = 0;
        for (int i = 0; i<t.length(); i++){
            if (t.charAt(i) == s.charAt(j)){
                j++;
            }
            if (j == s.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        IsSubsequence sol = new IsSubsequence();
        System.out.println(sol.isSubsequence(s,t));
    }
}
