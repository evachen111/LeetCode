package dynamic;

//63
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] helper = new int[m][n];
        for (int i = 0; i<m; i++){
            if (obstacleGrid[i][0] == 1){
                helper[i][0] = 0;
                break;
            }
            else{
                helper[i][0] = 1;
            }
        }
        for (int j = 0; j<n; j++){
            if (obstacleGrid[0][j] == 1){
                helper[0][j] = 0;
                break;
            }
            else{
                helper[0][j] = 1;
            }
        }
        for (int i = 1; i<m; i++){
            for (int j = 1; j<n; j++){
                if (obstacleGrid[i][j] == 1){
                    helper[i][j] = 0;
                }
                else{
                    helper[i][j] = helper[i][j-1] + helper[i-1][j];
                }
            }
        }
        return helper[m-1][n-1];
    }

    public static void main(String[] args) {

    }
}
