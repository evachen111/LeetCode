package monoStack;

import java.util.Stack;

// 84
// increasing mono stack element: idx
// int min
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int[] pre = new int[heights.length];
        int[] next = new int[heights.length];

        for(int i = 0; i<heights.length; i++){
            while (!s.isEmpty()&&heights[i]<=heights[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                pre[i] = -1;
            }
            else{
                pre[i] = s.peek();
            }
            s.push(i);
        }

        s.clear();
        for (int i = heights.length-1; i>=0; i--){
            while(!s.isEmpty()&&heights[i]<=heights[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                next[i] = heights.length;
            }
            else {
                next[i] = s.peek();
            }
            s.push(i);
        }

        int max = 0;
        for (int i = 0; i<heights.length; i++){
            max = Math.max(max, (next[i]-pre[i]-1)*heights[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
        int[] a = {2,4};
        System.out.println(sol.largestRectangleArea(a));
    }
}
