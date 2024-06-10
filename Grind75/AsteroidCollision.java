package Grind75;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 735
public class AsteroidCollision {

    public void check(Stack<Integer> st, int i){
        if (st.isEmpty()){
            st.push(i);
        }
        else{
            int top = st.pop();
            if (i<0 && top*i < 0){
                if (Math.abs(top)>Math.abs(i)){
                    check(st,top);
                }
                else if (Math.abs(top)<Math.abs(i)){
                    check(st,i);
                }
            }
            else{
                st.push(top);
                st.push(i);
            }
        }
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i : asteroids){
            check(st,i);
        }

        int[] re = new int[st.size()];
        for (int i = re.length-1; i>=0; i--){
            re[i] = st.pop();
        }
        return re;
    }
}
