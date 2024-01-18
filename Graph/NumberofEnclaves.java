package Graph;

import java.util.LinkedList;
import java.util.Queue;

//1020
public class NumberofEnclaves {
    public int[][] fourD = {{0,1},{0,-1},{1,0},{-1,0}};
    public int num = 0;
    public int re = 0;
    public boolean can = false;
    public void BFS(int[][] g, int i, int j){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        g[i][j] = 2;

        while (!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k<fourD.length; k++){
                if (x+fourD[k][0] <0 || x+fourD[k][0]>= g.length || y+fourD[k][1] <0 || y+fourD[k][1]>=g[0].length){
                    can = true;
                }
                else if (g[x+fourD[k][0]][y+fourD[k][1]] == 1){
                    q.add(x+fourD[k][0]);
                    q.add(y+fourD[k][1]);
                    g[x+fourD[k][0]][y+fourD[k][1]] = 2;
                    num++;
                }
            }
        }
        if(!can){
            re+=num;
        }
        num = 0;
        can = false;
    }

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i<grid.length; i++){
            for (int j =0; j<grid[0].length; j++){
                if (grid[i][j] == 1){
                    num++;
                    BFS(grid, i, j);
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {

    }
}
