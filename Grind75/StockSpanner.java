package Grind75;

import java.util.Hashtable;
import java.util.Stack;

// 901
public class StockSpanner {
    public Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int[] span = new int[2];
        span[0] = price;
        span[1] = 1;
        while (!st.isEmpty() && st.peek()[0] <= price){
                span[1] += st.pop()[1];
        }
        st.push(span);
        return span[1];
    }
}