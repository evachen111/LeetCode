package OA;

import java.util.HashMap;
import java.util.Map;

public class tianyi02 {
    public int countStr (String str) {
        // change the string to lowercase
        String s = str.toLowerCase();
        // setup hashmap
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('d', 0);
        hm.put('i', 0);
        hm.put('a', 0);
        hm.put('n', 0);
        hm.put('x', 0);
        hm.put('i', 0);
        hm.put('n', 0);
        // go through the string
        for (char c : s.toCharArray()){
            if (hm.containsKey(c)){
                hm.put(c, hm.get(c)+1);
            }
        }
        // find the minimum
        int min = s.length();
        for (Map.Entry<Character, Integer> entry : hm.entrySet()){
            if (entry.getValue()<min){
                min = entry.getValue();
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
