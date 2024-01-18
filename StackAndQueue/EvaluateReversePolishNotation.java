package StackAndQueue;

import java.util.Stack;

//150
public class EvaluateReversePolishNotation {

//    public static boolean isChar(String element){
//        try {
//            int intValue = Integer.parseInt(element);
//        } catch (NumberFormatException e) {
//            if (element.length() == 1) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack();
        // push
        for (int i = 0; i<tokens.length; i++){
            // 写复杂了
//            // check operator
//            if (isChar(tokens[i])){
//                int result = 0;
//                int operand2 = st.pop();
//                int operand1 = st.pop();
////                if (tokens[i] == "*"){
////                    result = operand1*operand2;
////                }
////                else if (tokens[i] == "/"){
////                    result = operand1/operand2;
////                }
////                else if (tokens[i] == "+"){
////                    result = operand1+operand2;
////                }
////                else {
////                    result = operand1-operand2;
////                }
//                // the comparison of string !!!
//                if (tokens[i].equals("*")) {
//                    result = operand1 * operand2;
//                } else if (tokens[i].equals("/")) {
//                    result = operand1 / operand2;
//                } else if (tokens[i].equals("+")) {
//                    result = operand1 + operand2;
//                } else if (tokens[i].equals("-")) {
//                    result = operand1 - operand2;
//                }
//
//                st.push(result);
//            }

            // check operator

            if (tokens[i].equals("*")) {
                int result = st.pop() * st.pop();
                st.push(result);
            } else if (tokens[i].equals("/")) {
                int operand2 = st.pop();
                int operand1 = st.pop();
                st.push(operand1 / operand2);
            } else if (tokens[i].equals("+")) {
                int result = st.pop() + st.pop();
                st.push(result);
            } else if (tokens[i].equals("-")) {
                int result = -(st.pop() - st.pop());
                st.push(result);
            }

            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String[] s = {"4","3","-"};

        System.out.println(evalRPN(s));

    }
}
