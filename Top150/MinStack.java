package Top150;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class MinStack {

    public Stack<Integer> st;
    public Stack<Integer> stOrd;
    public MinStack() {
        st = new Stack<>();
        stOrd = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (stOrd.isEmpty() || stOrd.peek()>=val){
            stOrd.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty()){
            return;
        }
        if (st.peek() == stOrd.peek()){
            stOrd.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return stOrd.peek();
    }



    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(412);
        minStack.push(-99);
        minStack.push(-99);
        minStack.push(412);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
