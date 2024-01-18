package backTracking;

import java.util.ArrayList;
import java.util.List;

//131
public class PalindromePartitioning {
    public List<List<String>> result = new ArrayList<>();
    public List<String> re = new ArrayList<>();

    public boolean isP(String s){
        int i = 0;
        int j = s.length()-1;
        while (i<j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void helper(String s, int startIdx){
        if(startIdx == s.length()){
            result.add(new ArrayList<>(re));
            return;
        }
        for (int i = startIdx+1; i<=s.length(); i++){
            String sub = s.substring(startIdx,i);
            if (isP(sub)){
                re.add(sub);
                helper(s, i);
                re.remove(re.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        helper(s,0);
        return result;
    }

    public static void main(String[] args) {

    }
}
