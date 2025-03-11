package Top150;

import java.util.HashMap;
import java.util.Map;

// 290
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hm1 = new HashMap<>();
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i<pattern.length()){
            while (j < s.length() && s.charAt(j) != ' '){
                sb.append(s.charAt(j));
                j++;
            };
            // #pattern > #s
            if (sb.isEmpty()){
                return false;
            }
            if (!hm1.containsKey(pattern.charAt(i))){
                // bijection
                if (hm1.containsValue(sb.toString())){
                    return false;
                }
                hm1.put(pattern.charAt(i), sb.toString());
            }
            else if (!hm1.get(pattern.charAt(i)).equals(sb.toString())){
                return false;
            }

            sb.delete(0,sb.length());
            i++;
            j++;
        }
        // #pattern < #s
        if (j<s.length()-1){
            return false;
        }
        return true;
    }

    //best solution
//    public boolean wordPattern(String pattern, String str) {
//        String[] words = str.split(" ");
//        if (words.length != pattern.length())
//            return false;
//        Map index = new HashMap();
//        for (Integer i=0; i<words.length; ++i)
//            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
//                return false;
//        return true;
//    }

    public static void main(String[] args) {
//        WordPattern sol = new WordPattern();
//        String pattern = "he";
//        String s = "unit";
//        System.out.println(sol.wordPattern(pattern, s));

        Map idx = new HashMap(); // equals to Map<Object, Object>
        System.out.println(idx.put('a', 1)); // return null
        System.out.println(idx.put('a', 2)); // return 1
    }
}
