package HashTable;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> hm = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if(hm.containsKey(magazine.charAt(i))){
                hm.put(magazine.charAt(i),hm.get(magazine.charAt(i))+1);
            }
            else{
                hm.put(magazine.charAt(i),1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char value = ransomNote.charAt(i);
            if (!hm.containsKey(value) || hm.get(value)<1){
                return false;
            }
            else {
                hm.put(value,hm.get(value)-1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
