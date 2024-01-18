package Graph;

// 463
public class IslandPerimeter {
    public int[][] fourD = {{0,1},{0,-1},{1,0},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        // upload the number of neighbors
        int cnt = 0;
        int pm = 0;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 1){
                    cnt++;
                    for (int k = 0; k<fourD.length; k++){
                        if (i+fourD[k][0]>=0 && i+fourD[k][0]<grid.length
                        && j+fourD[k][1]>=0 && j+fourD[k][1]<grid[0].length
                        && grid[i+fourD[k][0]][j+fourD[k][1]]!=0){
                            pm++;
                        }
                    }
                }
            }
        }

        // calculate the perimeter
        return 4*cnt-pm;
    }

    public static void main(String[] args) {

    }
}
