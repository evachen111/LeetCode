package OA;

public class eleme02 {
    public static int result;
    public static int[] arr;
    public static void search(int begin, int end, int k) {
        if (end == k){
            result++;
            return;
        }

        if (k+1<arr.length && arr[k+1] == 0){
            arr[k+1] = 1;
            search(begin, end, k+1);
            arr[k+1] = 0;
        }
        if (k+2<arr.length && arr[k+2] == 0){
            arr[k+2] = 1;
            search(begin, end, k+2);
            arr[k+2] = 0;
        }
        if (k-1>=0 && arr[k-1] == 0){
            arr[k-1] = 1;
            search(begin, end, k-1);
            arr[k-1] = 0;
        }
        if (k-2>=0 && arr[k-2] == 0){
            arr[k-2] = 1;
            search(begin, end, k-2);
            arr[k-2] = 0;
        }
    }


    public static void main(String[] args) {
        int n = 3;
        int begin = 2;
        int end = 3;

        arr = new int[n+1];
        arr[begin] = 1;
        search(begin,end,begin);
        System.out.println(result);
    }
}
