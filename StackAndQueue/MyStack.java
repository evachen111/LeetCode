package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

//225
public class MyStack {

    Queue<Integer> myQue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        Queue<Integer> que2 = new LinkedList<>();
        while (!myQue.isEmpty()){
            que2.add(myQue.remove());
        }
        myQue.add(x);
        while (!que2.isEmpty()){
            myQue.add(que2.remove());
        }
    }

    public int pop() {
        return myQue.remove();
    }

    public int top() {
        return myQue.peek();
    }

    public boolean empty() {
        return myQue.isEmpty();
    }

}
