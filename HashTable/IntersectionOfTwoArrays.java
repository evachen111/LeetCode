package HashTable;

//349

// 2nd time: use Set<Integer> set1 = new HashSet<>();
public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {

        int[] hash = new int[1000];

        // go through nums1
        for (int i = 0; i<nums1.length; i++){
            hash[nums1[i]] = 1;
        }

        // check through nums2
//        for (int i = 0; i< nums2.length; i++){
//            if (hash[nums2[i]] !=0){
//                hash[nums2[i]]++;
//            }
//        }
        for (int i : nums2){
            if (hash[i] !=0){
                hash[i]++;
            }
        }

        //result
        int cnt = 0;
        for (int i = 0; i<1000; i++){
            if (hash[i]>1){
                cnt++;
            }
        }
        int[] result = new int[cnt];
        int j = 0;
        for (int i = 0; i<1000; i++){
            if (hash[i]>1){
                result[j++] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = intersection(nums1, nums2);
        for (int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
