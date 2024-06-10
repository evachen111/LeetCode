package Grind75;

import java.util.LinkedList;
import java.util.Queue;

// 649
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Character> q1 = new LinkedList<>();
        Queue<Character> q2 = new LinkedList<>();

        for (int i = 0; i<senate.length(); i++){
            q1.add(senate.charAt(i));
        }

        char tmp;
        while (!q1.isEmpty()){
            tmp = q1.remove();
            if (q2.isEmpty() || tmp == q2.peek()){
                q2.add(tmp);
            }
            else{
                q1.add(q2.remove());
            }
        }

        if(q2.remove() == 'R'){
            return "Radiant";
        }
        return "Dire";
    }

    public static void main(String[] args) {
//        char a= 'a';
//        char b = 'a';
//        System.out.println(a==b);

        String s = "DDRRR";
        Dota2Senate sol = new Dota2Senate();
        System.out.println(sol.predictPartyVictory(s));
    }
}
