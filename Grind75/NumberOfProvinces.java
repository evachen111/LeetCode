package Grind75;

// 547
 // dfs
public class NumberOfProvinces {
    public int num_tree;
    public int[] color;
    public void dfs_tree(int[][] g, int i){
        color[i] = 1;
        for (int j = 0; j<g[0].length; j++){
            if (g[i][j] == 1 && color[j]==0){
                dfs_tree(g,j);
            }
        }
        color[i] = 2;
    }
    public int findCircleNum(int[][] isConnected) {
        num_tree = 0;
        color = new int[isConnected.length];
        for (int i = 0; i<isConnected.length; i++){
            if (color[i] == 0){
                dfs_tree(isConnected, i);
                num_tree++;
            }
        }
        return num_tree;
    }

    public static void main(String[] args) {

    }
}
