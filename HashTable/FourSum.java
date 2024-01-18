package HashTable;

import java.util.HashMap;
import java.util.Map;

// 454
public class FourSum {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        int n = nums1.length;

        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                int value1 = nums1[i] + nums2[j];
                if (hm1.containsKey(value1)){
                    hm1.put(value1,hm1.get(value1)+1);
                }else{
                    hm1.put(value1,1);
                }
//                int value2 = nums3[i] + nums4[j];
//                if (hm2.containsKey(value2)){
//                    hm2.put(value2,hm2.get(value2)+1);
//                }else{
//                    hm2.put(value2,1);
//                }
            }
        }

        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                int value2 = nums3[i] + nums4[j];
                if (hm1.containsKey(-value2)){
                    result += hm1.get(-value2);
                }

            }
        }


//        for (int k1 : hm1.keySet()) {
//            for (int k2 : hm2.keySet()) {
//                if (k1+k2 == 0){
//                    result += hm1.get(k1)*hm2.get(k2);
//                }
//            }
//        }


        // Time Limit Exceeded
//        int[] ab  = new int[(int)Math.pow(n,2)];
//        int[] cd  = new int[(int)Math.pow(n,2)];
//        for (int i = 0; i<n; i++){
//            for (int j = 0; j<n; j++){
//                ab[i*n + j] = nums1[i] + nums2[j];
//                cd[i*n + j] = nums3[i] + nums4[j];
//            }
//        }
//
//        for (int i = 0; i< ab.length; i++){
//            for (int j = 0; j< cd.length; j++){
//                if(ab[i] + cd[j] == 0){
//                    result++;
//                }
//            }
//        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};

        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }
}
