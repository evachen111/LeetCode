package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//763
public class PartitionLabels {
    public List<Integer> result = new ArrayList<>();
    public List<Integer> partitionLabels(String s) {
        int[] lastAppear = new int[26];
        for (int i =0; i<s.length(); i++){
            lastAppear[s.charAt(i)-97] = i;
        }

        int last = -1;
        int right = lastAppear[s.charAt(0)-97];
        for (int i = 0; i<= right && i<s.length(); i++){
            if (i == right){
                if (result.isEmpty()){
                    result.add(i-last);
                    last = i;
                }
                else{
                    result.add(i - last);
                    last = i;
                }
                if (i<s.length()-1){
                    right = lastAppear[s.charAt(i+1)-97];
                }
            }
            if (lastAppear[s.charAt(i)-97] > right){
                right = lastAppear[s.charAt(i)-97];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "caedbdedda";
        System.out.println(s.length());
        PartitionLabels sol = new PartitionLabels();
        System.out.println(sol.partitionLabels(s));
    }
}
