package Grind75;

import java.util.HashSet;

// 1456
public class MaxiNumVowels {
    public int maxVowels(String s, int k) {
        int i = 0;
        int j = k-1;
        int cnt = 0;
//        HashSet<Character> v = new HashSet<>();
//        v.add('a');
//        v.add('e');
//        v.add('i');
//        v.add('o');
//        v.add('u');
        String v = "aeiou";

        // init
        for (int x = i; x<=j; x++){
            if (v.contains(s.substring(x,x+1))){
                cnt++;
            }
        }
        int max = cnt;
        // slide
        while (j+1<s.length()){
            if (v.contains(s.substring(j+1,j+2)) && !v.contains(s.substring(i,i+1))){
                cnt++;
            }
            else if (!v.contains(s.substring(j+1,j+2)) && v.contains(s.substring(i,i+1))){
                cnt--;
            }
            max = Math.max(max,cnt);
            i++;
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
//        String s = "abc";
//        System.out.println(s.contains("d"));
//        System.out.println(s.substring(2,3)); // c

        MaxiNumVowels sol = new MaxiNumVowels();
        String s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb";
        System.out.println(sol.maxVowels(s,33));
    }
}
