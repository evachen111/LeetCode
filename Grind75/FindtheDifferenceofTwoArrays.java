package Grind75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 2215
public class FindtheDifferenceofTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> l1 = new HashSet<>();
        for (int i = 0; i<nums1.length; i++){
            if (!l1.contains(nums1[i])){
                l1.add(nums1[i]);
            }
        }
        HashSet<Integer> l2 = new HashSet<>();
        for (int i= 0; i<nums2.length; i++){
            if (!l2.contains(nums2[i])){
                l2.add(nums2[i]);
            }
        }

        for (int i= 0; i<nums2.length; i++){
            if (l2.contains(nums2[i]) && l1.contains(nums2[i])){
                l2.remove(nums2[i]);
                l1.remove(nums2[i]);
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(l1));
        list.add(new ArrayList<>(l2));
        return list;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        System.out.println(l1); // has duplicates

    }
}
