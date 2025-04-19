package Top150;

public class QSort {
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 同时
        int i = left - 1;
        int j = right + 1;
        while (true){
            do{
                j--;
            } while (arr[j] > pivot);  // find <= pivot
            do{
                i++;
            } while (arr[i] < pivot); // find >= pivot

            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            else{
                return i; // 同时
            }
        }
    }
    public static void qsort(int[] arr, int l, int r){
        if (l < r){
            int m = partition(arr, l, r);
            qsort(arr,l,m-1);   //缺点是相同元素时，不靠中间，没有严格二分缩小处理区间 // 同时
            qsort(arr,m,r); // 同时
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1,1,1};
        int[] arr = {1,4,6,2,5};
        qsort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
