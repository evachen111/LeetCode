package StackAndQueue;

import java.util.Stack;


//20
public class ValidParentheses {
    private static char findClose(char c){
        if (c == '('){
            return ')';
        }
        else{
            return (char)((int)c+2);
        }
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        int len = s.length();
        s.toCharArray();
        for (int i = 0; i<len; i++){
            if (!stack.isEmpty() && findClose(stack.peek())==s.charAt(i)){
                char tmp = stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = new String("()[]{}");
        System.out.println(isValid(s));
    }
}
