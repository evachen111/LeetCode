package OA;

public class pdd001 {
    public static void Square(int n){
        int[][] arr = new int[n][n];

        int x = 0, y = -1;
        int i = 1;
        while (i <= Math.pow(n,2)) {
            while (y<n-1 && arr[x][y+1] == 0){ //先判断能不能走
                arr[x][++y] = i++; //再走
            }
            while (x<n-1 && arr[x+1][y] == 0){
                arr[++x][y] = i++;
            }
            while (y>0 && arr[x][y-1] == 0){
                arr[x][--y] = i++;
            }
            while (x>0 && arr[x-1][y] == 0){
                arr[--x][y] = i++;
            }
        }
        for (int j = 0; j<n; j++){    //can't define another i again
            for (int k = 0; k<n; k++){
                System.out.print(arr[j][k]+",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Square(6);
    }
}
