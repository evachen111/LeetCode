package backTracking;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//93
public class RestoreIPAddresses {
    public List<String> result = new ArrayList<>();
    List<String> deque = new ArrayList<>();

    public void helper(String s, int StartIdx){
        if (deque.size() > 4){
            return;
        }
        if (StartIdx == s.length()){
            if (deque.size() == 4){
                StringBuffer sb = new StringBuffer(deque.get(0));
                for (int i = 1; i<deque.size(); i++){
                    sb.append('.');
                    sb.append(deque.get(i));
                }
                result.add(sb.toString());
            }
            return;
        }

        for (int i=StartIdx+1; i<=s.length(); i++){
            String sub = s.substring(StartIdx,i);
            if ((sub.length() >1 && sub.charAt(0) == '0') ||  sub.length() >3 || Integer.valueOf(sub) > 255){
                continue;
            }
            deque.add(sub);
            helper(s,i);
            deque.remove(deque.size()-1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        helper(s,0);
        return result;
    }

    public static void main(String[] args) {

    }
}
