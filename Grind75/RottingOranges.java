package Grind75;

import java.util.LinkedList;
import java.util.Queue;

// 994
// determine the largest distance
public class RottingOranges {
    public int[][] fourD = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] col;
    public void BFS(int[][] g, int i, int j){
        col[i][j] = 1;
        int max = col[i][j];
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        while(!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            for(int k =0; k<4; k++){
                if (x+fourD[k][0]>=0 && x+fourD[k][0]<g.length &&
                        y+fourD[k][1]>=0 && y+fourD[k][1]<g[0].length&&
                        g[x+fourD[k][0]][y+fourD[k][1]] == 1&&
                        (col[x+fourD[k][0]][y+fourD[k][1]] == 0||
                                col[x+fourD[k][0]][y+fourD[k][1]] >col[x][y]+1)
                ){
                    col[x+fourD[k][0]][y+fourD[k][1]] = col[x][y]+1;
                    q.add(x+fourD[k][0]);
                    q.add(y+fourD[k][1]);
                    max = Math.max(max,col[x+fourD[k][0]][y+fourD[k][1]]);
                }
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        col = new int[grid.length][grid[0].length];
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 2){
                    BFS(grid, i,j);
                }
            }
        }
        int min = 1;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 1  && col[i][j] == 0){
                    return -1;
                }
                min = Math.max(min,col[i][j]);
            }
        }
        return min-1;
    }

    public static void main(String[] args) {
        RottingOranges sol = new RottingOranges();
        int[][] g = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(sol.orangesRotting(g));
    }
}
