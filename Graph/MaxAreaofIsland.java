package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 695
//BFS
public class MaxAreaofIsland {
    public int max = 0;
    public int num = 0;
    public int[][] fourD = {{0,1},{0,-1},{1,0},{-1,0}};
    public void BFS(int[][] g, int i, int j){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        g[i][j] = 2;

        while (!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k<fourD.length; k++){
                if (x+fourD[k][0] >=0 && x+fourD[k][0]< g.length && y+fourD[k][1] >=0 && y+fourD[k][1] <g[0].length && g[x+fourD[k][0]][y+fourD[k][1]] == 1){
                    q.add(x+fourD[k][0]);
                    q.add(y+fourD[k][1]);
                    g[x+fourD[k][0]][y+fourD[k][1]] = 2;
                    num++;
                }
            }
        }
        max = Math.max(max,num);
        num = 0;
    }

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if (grid[i][j] == 1){
                    num++;
                    BFS(grid,i,j);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxAreaofIsland sol = new MaxAreaofIsland();
        int[][] g = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};

        System.out.println(sol.maxAreaOfIsland(g));

    }
}
