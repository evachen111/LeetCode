package Grind75;

import java.util.HashMap;
import java.util.HashSet;

// 2352
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int cnt = 0;
        HashMap<String,Integer> hm = new HashMap<>();

        for (int i = 0; i<n; i++){
            StringBuffer val = new StringBuffer();
            for (int j = 0; j<n; j++){
                val.append(grid[i][j]);
                val.append(',');
            }

            if (hm.containsKey(val.toString())){
                hm.put(val.toString(),hm.get(val.toString())+1);
            }
            else{
                hm.put(val.toString(),1);
            }
        }

        for (int i = 0; i<n; i++){
            StringBuffer val = new StringBuffer();
            for (int j = 0; j<n; j++){
                val.append(grid[j][i]);
                val.append(',');
            }
            if (hm.containsKey(val.toString())){
                cnt+=hm.get(val.toString());
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
//        String a = new String("as");
//        String b = new String("as");
//        HashMap<String, Integer> hm = new HashMap<>();
//        hm.put(a, 1);
//        if (hm.containsKey(b)){
//            System.out.printf("yes");
//        }
//        else{
//            System.out.println("no");
//        }

        int[][] grid = {{3,2,1}, {1,7,6}, {2,7,7}};
        EqualRowAndColumnPairs sol = new EqualRowAndColumnPairs();
        System.out.println(sol.equalPairs(grid));
    }
}
