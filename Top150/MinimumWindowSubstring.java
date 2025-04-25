package Top150;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

// 76
public class MinimumWindowSubstring {
    // repeated chars in t!!  the order doesn't matter!
//    public String minWindow(String s, String t) {
//        // sanity check
//        if (s.length() < t.length()) return "";
//
//        HashMap<Character, Integer> hm = new HashMap<>();
//        int n = t.length();
//        for (char i : t.toCharArray()) {
//            hm.put(i,-1);
//        }
//
//        int i = 0, j = 0;
//        int cnt = 0;
//        int min = s.length()+1;
//        String result = "";
//        while (j < s.length()) {
//            // in t,
//                // new in cnt
//                // already in cnt
//                    //if last appearance is at i, update i to the minimum value in hm
//            // not in t
//            // check cnt==n, update min, update i to the minimum value in hm
//            if (hm.containsKey(s.charAt(j))) {
//                if (hm.get(s.charAt(j)) == -1){
//                    if (cnt == 0){i = j;}
//                    cnt++;
//                }
//                else if (hm.get(s.charAt(j)) == i){
//                    hm.remove(s.charAt(j));
//                    i = Collections.min(hm.values());
//                }
//                hm.put(s.charAt(j), j);
//            }
//            if(cnt == n && j-i+1 < min){
//                min = j-i+1;
//                result = s.substring(i,i+min);
//            }
//            j++;
//        }
//
//        return result;
//    }


    public String minWindow(String s, String t) {
                // sanity check
        if (s.length() < t.length()) return "";
        HashMap <Character, Integer> mapt = new HashMap<>();
        HashMap <Character, Integer> maps = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapt.put(c, mapt.getOrDefault(c,0)+1);
        }

        int i = 0, j = 0;
        int n = mapt.size();
        int cnt = 0;
        int min = s.length()+1;
        String result = "";
        while (j < s.length()) {
            if(mapt.containsKey(s.charAt(j)) ){
                maps.put(s.charAt(j), maps.getOrDefault(s.charAt(j),0)+1);
                if (maps.get(s.charAt(j)).intValue() == mapt.get(s.charAt(j)).intValue()){
                    cnt++;
                }
            }

            // 怎么缩小窗口
            while(i<=j && cnt == n){
                if (min > j-i+1){
                    min = j-i+1;
                    result = s.substring(i,j+1);
                }

                if(mapt.containsKey(s.charAt(i))){
                    maps.put(s.charAt(i), maps.get(s.charAt(i))-1);
                    if (maps.get(s.charAt(i)).intValue() < mapt.get(s.charAt(i)).intValue()){
                        cnt--;
                    }
                }
                i++;
            }
            j++;
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {
//        String s = "A";
//        String t = "A";
//        MinimumWindowSubstring sol = new MinimumWindowSubstring();
//        System.out.println(sol.minWindow(s, t));

//        Integer a = 10000;
//        Integer b = 10000;
//        System.out.println(a==b); //false
    }
}
