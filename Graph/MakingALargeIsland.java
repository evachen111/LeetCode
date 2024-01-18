package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 827
public class MakingALargeIsland {
    public int idx = 2;
    public HashMap<Integer,Integer> hm = new HashMap<>();
    public int[][] fourD = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] twoHops = {{-2, 0}, {2,0}, {-1,1}, {1,1},{-1,-1},{1,-1},{0,2},{0,-2}};
    public void BFS(int[][] g, int i, int j){ // return the area of the island
        int num = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        g[i][j] = idx; // color
        while (!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k< fourD.length; k++){
                if(x+fourD[k][0] >=0 && x+fourD[k][0]<g[0].length
                        && y+fourD[k][1] >=0 && y+fourD[k][1]<g.length
                        && g[x+fourD[k][0]][y+fourD[k][1]] == 1){ // if color == W
                    num++;
                    g[x+fourD[k][0]][y+fourD[k][1]] = idx; //color
                    q.add(x+fourD[k][0]);
                    q.add(y+fourD[k][1]);
                }
            }
        }
        hm.put(idx,num);
        idx++;
    }
    public int largestIsland(int[][] grid) {
        for (int i = 0; i<grid.length; i++){
            for (int j =0; j<grid[0].length; j++){
                if (grid[i][j] == 1){
                    BFS(grid, i, j);
                }
            }
        }
        int max = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i<grid.length; i++){
            for (int j =0; j<grid[0].length; j++){
                if (grid[i][j] ==0 ){
                    int sum = 0;
                    for (int k = 0; k< fourD.length; k++){
                        if(i+fourD[k][0] >=0 && i+fourD[k][0]<grid[0].length
                                && j+fourD[k][1] >=0 && j+fourD[k][1]<grid.length
                                && grid[i+fourD[k][0]][j+fourD[k][1]] !=0
                                && !hs.contains(grid[i+fourD[k][0]][j+fourD[k][1]])){
                            sum+=hm.get(grid[i+fourD[k][0]][j+fourD[k][1]]);
                            hs.add(grid[i+fourD[k][0]][j+fourD[k][1]]);
                        }
                    }
                    max = Math.max(max, sum+1);
                    hs.clear();
                }
            }
        }
        if (max == 0){
            if (hm.isEmpty()){
                return 1;
            }
            else{
                return hm.get(grid[0][0]);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        MakingALargeIsland sol = new MakingALargeIsland();
        int[][] g ={{0,0},{0,0}};
        System.out.println(sol.largestIsland(g));
    }
}
