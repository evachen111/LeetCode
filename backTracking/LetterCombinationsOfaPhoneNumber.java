package backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//17
public class LetterCombinationsOfaPhoneNumber {
    private Map<Character, String> sm = new HashMap<>();

    public List<String> result = new ArrayList<>();
    public StringBuffer sb = new StringBuffer();
//    public int[] idxTable;        // could be deleted
    public void helper(String digits, int idx){
        if (idx == digits.length()){
            result.add(sb.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letters = sm.get(digit);
//        for (int i = idxTable[idx]; i>0; i--){
        for (int i = letters.length(); i>0; i--){
            // add state
            sb.append(letters.charAt(letters.length()-i));

            helper(digits, idx+1);

            // remove
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        sm.put('2',"abc");
        sm.put('3',"def");
        sm.put('4',"ghi");
        sm.put('5',"jkl");
        sm.put('6',"mno");
        sm.put('7',"pqrs");
        sm.put('8',"tuv");
        sm.put('9',"wxyz");
        System.out.println(sm.get('2'));
        // sanity check
        if (digits.length() == 0){
            return result;
        }

        // idx table
//        idxTable = new int[digits.length()];
//        for (int i = 0; i<digits.length(); i++){
//            idxTable[i] = sm.get(digits.charAt(i)).length();
//        }
        //call helper
        helper(digits,0);
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsOfaPhoneNumber sol = new LetterCombinationsOfaPhoneNumber();
        List<String> re = sol.letterCombinations("23");

        System.out.println(re);
//        String s = new String("asd");
//        System.out.println(s.charAt(0));
//        System.out.println(s.length()); //3
//
//        int[] array = {1,2,3};
//        array[0]--;
//        System.out.println(array[0]); //0
    }
}
