package Top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 118
public class PascalTriangle {
    List<List<Integer>> result = new ArrayList<>();
    public static List<Integer> addRow(List<Integer> list){
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < list.size()-1; i++){
            res.add(list.get(i)+list.get(i+1));
        }
        res.add(1);
        return res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < numRows; i++){
            result.add(addRow(result.get(i - 1)));
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
