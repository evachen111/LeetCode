package StackAndQueue;

import java.util.Stack;


//232
public class MyQueue {
    public MyQueue() {

    }

    Stack<Integer> s1 = new Stack<>();

    public void push(int x) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.empty()){
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        if (s1.empty()){
            return true;
        }
        return false;
    }
}
