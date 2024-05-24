package Grind75;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 394
public class DecodeString {
    private Stack<Integer> number = new Stack<>();
    private Stack<StringBuffer> content = new Stack<>();

    public String decodeString(String s) {
        StringBuffer sb = new StringBuffer();


        Queue<Integer> times = new LinkedList<>();
        for (int i = 0; i<s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                times.add(s.charAt(i) - '0');
            }

            else if (s.charAt(i) == '['){
                int repeat = 0;
                for (int j = times.size()-1; j >=0; j--){
                    repeat+= times.remove()*Math.pow(10,j);
                }
                number.add(repeat);
                StringBuffer ss = new StringBuffer();
                content.push(ss);
            }

            else if (Character.isLowerCase(s.charAt(i))){
                if (content.isEmpty()){
                    sb.append(s.charAt(i));
                }
                else{
                    content.push(content.pop().append(s.charAt(i)));
                }
            }

            else if (s.charAt(i) == ']'){
                int repeat = number.pop();
                StringBuffer tmp  = content.pop();
                StringBuffer ss2 = new StringBuffer();
                for (int x = 0; x< repeat; x++){
                    ss2.append(tmp);
                }
                if (content.isEmpty()){
                    sb.append(ss2);
                }
                else{
                    content.push(content.pop().append(ss2));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString sol = new DecodeString();
        System.out.println(sol.decodeString(s));

    }
}
