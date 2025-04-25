package Top150;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWORepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int cnt = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (j < s.length()) {
            if(hm.containsKey(s.charAt(j)) && hm.get(s.charAt(j)) >= i){
                i = hm.get(s.charAt(j)) + 1;
            }
            hm.put(s.charAt(j), j);
            cnt = j-i+1;
            max = Math.max(max, cnt);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        LongestSubstringWORepeatingCharacters sol = new LongestSubstringWORepeatingCharacters();
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}
