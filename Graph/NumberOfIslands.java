package Graph;

import java.util.LinkedList;
import java.util.Queue;

// 200
// BFS
public class NumberOfIslands {
    public int num = 1;
    public void BFS(char grid[][], int i, int j){
        grid[i][j] = (char)(++num + '0');
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);

        while (!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            if (x>=1 && grid[x-1][y] == 49){
                grid[x-1][y] = (char)(num + '0');
                q.add(x-1);
                q.add(y);
            }
            if (x<grid.length-1 && grid[x+1][y] == 49){
                grid[x+1][y] = (char)(num + '0');
                q.add(x+1);
                q.add(y);
            }
            if (y>=1&&grid[x][y-1] == 49){
                grid[x][y-1] = (char)(num + '0');
                q.add(x);
                q.add(y-1);
            }
            if (y<grid[x].length-1 && grid[x][y+1] == 49){
                grid[x][y+1] = (char)(num + '0');
                q.add(x);
                q.add(y+1);
            }
        }

    }
    public int numIslands(char[][] grid) {
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[i].length; j++){
                if (grid[i][j] == 49){ // =='1'
                    BFS(grid, i,j);
                }
            }
        }
        return num-1;
    }

    public static void main(String[] args) {
//        char a = '1';
//        System.out.println(a == 49);
//        int b = 2;
//        char c = (char)(b+'0');
//        System.out.println(c);
        NumberOfIslands sol = new NumberOfIslands();
        char[][] g = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(sol.numIslands(g));
    }
}
