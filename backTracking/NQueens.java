package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//51
public class NQueens {
    public LinkedList<List<String>> result = new LinkedList<>();
    public List<String> re = new ArrayList<>();
    public boolean[][] used;

    public boolean isValid(boolean[][] used, int row, int col){
        if (used[row][col]){
            return false;
        }
        int n = used.length;
        for (int i = 1; i<=row; i++){
            if (col+i<n && used[row-i][col+i]){
                return false;
            }
            if (col-i>=0 && used[row-i][col-i]){
                return false;
            }
            if(used[row-i][col]){
                return false;
            }
        }
        return true;
    }

    public void helper(int n, int layer){
        if (re.size() == n){
            result.add(new ArrayList<>(re));
            return;
        }
        if (layer == n){
            return;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(".".repeat(n));

        for (int i = 0; i<n; i++){
            if (isValid(used,layer,i)){
                sb.setCharAt(i, 'Q');
                used[layer][i] = true;
                re.add(sb.toString());

                helper(n, layer+1);

                sb.setCharAt(i, '.');
                used[layer][i] = false;
                re.remove(re.size()-1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        used = new boolean[n][n];
        helper(n,0);
        return result;
    }

    public static void main(String[] args) {
        NQueens sol = new NQueens();
        System.out.println(sol.solveNQueens(4));

//        boolean[][] used = {{false, true, false},{false,false, false},{false,false, false}};
//        System.out.println(sol.isAva(used, 2,2));
    }
}
