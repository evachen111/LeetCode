package StackAndQueue;

import java.util.Stack;

// 1047
public class RemoveAllAdjacentDuplicates {

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        s.toCharArray();
        for (int i =0; i<len; i++){
            if (!st.isEmpty() && s.charAt(i) == st.peek()){
                int tmp = st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }

        char[] newS = new char[st.size()];

        for (int i = st.size()-1; i>=0; i--){
            newS[i] = st.pop();
        }

        return new String(newS);
    }

    public static void main(String[] args) {
        String s = new String("azxxzy");
        System.out.println(removeDuplicates(s));
    }

}
