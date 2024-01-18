package string;

// 28
public class findSubstring {
    // prefix table
    private static void getNext(int[] next, String s){
        next[0] = 0;
        int j = 0;
        for (int i = 1; i<s.length(); i++){
            while(j > 0 && s.charAt(j)!=s.charAt(i)){
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    public static int strStr(String haystack, String needle) {
        // sanity check
        if (needle.length() == 0){
            return -1;
        }
        // using prefix table
        int[] pre = new int[needle.length()];
        getNext(pre, needle);
        int j = 0;
        for (int i = 0; i<haystack.length(); i++){
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = pre[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j == needle.length()){
                return i-j+1;
            }
        }

        return -1;

//        int len = needle.length();
//        int i = 0;
//        int j = 0;
//
//        while (i<haystack.length()){
//            if (j == len){
//                return i-needle.length();
//            }
//            if (haystack.charAt(i) == needle.charAt(j)){
//                j++;
//            }
//            else{
//                i = i-j;
//                j = 0;
//            }
//            i++;
//        }
//        if (j == len){
//            return i-needle.length();
//        }
//        return -1;
    }

    public static void main(String[] args) {
        String haystack = new String("sadbutsad");
        String needle = new String("sad");
        System.out.println(strStr(haystack, needle));
    }
}
