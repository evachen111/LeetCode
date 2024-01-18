package Graph;

import java.util.LinkedList;
import java.util.Queue;

//130
public class SurroundedRegions {
    public boolean can = true;
    public int[][] fourD = {{0,1},{0,-1},{1,0},{-1,0}};
    public void BFS(char[][] g, int i, int j, int[][] color){
        if (color[i][j] == 1){
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(i);
        q.add(j);
        color[i][j] = 1;
        while (!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            q2.add(x);
            q2.add(y);
            for (int k = 0; k<fourD.length; k++){
                if (x+fourD[k][0] <0 || x+fourD[k][0]>= g.length || y+fourD[k][1] <0 || y+fourD[k][1]>=g[0].length){
                    can = false;
                }
                else if (g[x+fourD[k][0]][y+fourD[k][1]] == 'O'&& color[x+fourD[k][0]][y+fourD[k][1]] == 0){
                    q.add(x+fourD[k][0]);
                    q.add(y+fourD[k][1]);
                    color[x+fourD[k][0]][y+fourD[k][1]] = 1;
                }
            }
        }
        if(can){
            while (!q2.isEmpty()){
                int x = q2.remove();
                int y = q2.remove();
                g[x][y] = 'X';
            }
        }
        can = true;
    }
    public void solve(char[][] board) {
        int[][] color = new int[board.length][board[0].length];
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[i].length; j++){
                if (board[i][j] == 'O'){
                    BFS(board, i,j, color);
                }
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions sol = new SurroundedRegions();
        char[][] g = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        sol.solve(g);
        for(int i = 0; i<g.length;i++){
            for (int j = 0; j<g[0].length; j++){
                System.out.println(g[i][j]);
            }
        }
    }
}
