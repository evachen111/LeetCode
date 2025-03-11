package OA;

public class tianyi03 {
    public int minOperation (int[] a, int[] b) {
        // find the max in a
        int max = Integer.MIN_VALUE;
        for (int i : a){
            if (i>max){
                max = i;
            }
        }

        int cnt = 0;
        // go through b
        for (int j : b){
            if (j<max){
                cnt+=(max-j);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
