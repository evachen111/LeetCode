package HashTable;


//242
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // sanity check
        if (s.length() != t.length()) {
            return false;
        }

        // go through s
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-97]++;
        }
        // go through t
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)-97]--;
        }

        //check
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";
        String s = "rat";
        String t = "cat";
        System.out.println(isAnagram(s,t));
    }
}