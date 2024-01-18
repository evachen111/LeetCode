package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//417

public class PacificAtlanticWaterFlow {
    public int[][] fourD = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> result = new ArrayList<>();
    public int[][] canP;
    public int[][] canA;
    public void checkP(int[][] g, int i, int j){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        canP[i][j] = 1;
        while (!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            for(int k = 0; k< fourD.length; k++){
                if (y+ fourD[k][1]>=0 && y+ fourD[k][1]<g[0].length && x+fourD[k][0]>=0 && x+fourD[k][0]<g.length
                        && g[x+fourD[k][0]][y+ fourD[k][1]] >= g[x][y]
                        && canP[x+fourD[k][0]][y+ fourD[k][1]] == 0){
                    q.add(x+fourD[k][0]);
                    q.add(y+ fourD[k][1]);
                    canP[x+fourD[k][0]][y+ fourD[k][1]] = 1;
                }
            }
        }
    }
    public void checkA(int[][] g, int i, int j){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        canA[i][j] = 1;
        while(!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            for(int k = 0; k< fourD.length; k++){
                if (y+ fourD[k][1]>=0 && y+ fourD[k][1]<g[0].length && x+fourD[k][0]>=0 && x+fourD[k][0]<g.length
                        && g[x+fourD[k][0]][y+ fourD[k][1]] >= g[x][y]
                        && canA[x+fourD[k][0]][y+ fourD[k][1]] == 0){
                    q.add(x+fourD[k][0]);
                    q.add(y+ fourD[k][1]);
                    canA[x+fourD[k][0]][y+ fourD[k][1]] = 1;
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        canP = new int[heights.length][heights[0].length];
        canA = new int[heights.length][heights[0].length];
        // init
        for (int j = 0; j<heights[0].length;j++){
            checkP(heights,0,j);
            checkA(heights,canA.length-1,j);
        }
        for (int i =0; i< heights.length; i++){
            checkP(heights,i,0);
            checkA(heights,i,canA[0].length-1);
        }
        for (int i = 0; i< canP.length; i++){
            for (int j = 0; j<canP[0].length; j++){
                if (canA[i][j] == 1 && canP[i][j] == 1){
                    List<Integer> li = new ArrayList<>();
                    li.add(i);
                    li.add(j);
                    result.add(li);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow sol = new PacificAtlanticWaterFlow();
        int[][] g = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(sol.pacificAtlantic(g));
    }
}
