package backTracking;

public class SudokuSolver2 {
    public boolean isValid (char[][] board, int row, int col, char val){
        for (int i = 0; i<9; i++){
            if (board[row][i] == val){ //row
                return false;
            }
            if (board[i][col] == val){ // col
                return false;
            }
        }
        // sub-boxes
        for (int i = 0; i<3; i++){
            for (int j =0; j<3; j++){
                if (board[(row/3)*3 + i][(col/3)*3 + j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean helper(char[][] board){
        for (int i = 0; i<9; i++){ // row
            for (int j = 0; j<9; j++){  // col
                // all possibilities if there is a solution
                for (char val = '1'; val <= '9'; val++){
                    if (isValid(board,i, j, val)){
                        board[i][j] = val;
                        if (helper(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                /// when there is no solution(return true) after trying all 9 nums at this position
                return false;                 /// !!!
            }
        }

        return true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    public static void main(String[] args) {

//        char[] c = {'1','2','3'};
//        System.out.println(c[2] == '3');

        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        for (int i = 0; i<9; i++){
            System.out.println(board[i]);
        }
        SudokuSolver2 sol = new SudokuSolver2();
        System.out.println("================");
        sol.solveSudoku(board);
        for (int i = 0; i<9; i++){
            System.out.println(board[i]);
        }
    }
}
