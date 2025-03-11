package Top150;

// 88
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // sanity check
        if (n == 0){
            return;
        }

        int i = m-1, j = n-1;
        int curr = m+n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]){
                nums1[curr--] = nums2[j--];
            }
            else{
                nums1[curr--] = nums1[i];
                nums1[i] = 0;
                i--;
            }
        }
        if (i==-1){
            for(int x =0; x<=curr; x++){
                nums1[x] = nums2[x];
            }
        }
//        for (int x = 0; x < nums1.length; x++){
//            System.out.println(nums1[x]);
//        }
    }

    public static void main(String[] args) {
        MergeSortedArray sol = new MergeSortedArray();
//        int[] nums1 = {1,2,5,0,0,0,0};
//        int[] nums2 = {1,2,5,6};
        int[] nums1 = {0};
        int[] nums2 = {1};
        sol.merge(nums1,0, nums2,1);
    }
}
