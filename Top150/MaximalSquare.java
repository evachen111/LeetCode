package Top150;

// 221
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] == '1' ? 1 : 0;
            }
        }
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[i].length; j++) {
                if (result[i][j] == 1 &&
                        result[i - 1][j - 1] > 0 &&
                        result[i][j-1] >0 &&
                        result[i-1][j] >0) {
                    result[i][j] = Math.min(Math.min(result[i-1][j-1],result[i][j-1]),result[i-1][j]) + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j =0; j < result[i].length; j++) {
                if (result[i][j] > max){
                    max = result[i][j];
                }
            }
        }

        return max*max;
    }

    public static void main(String[] args) {
        MaximalSquare sol = new MaximalSquare();
        char[][] matrix = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1'}
        };
        System.out.println(sol.maximalSquare(matrix));
    }
}
