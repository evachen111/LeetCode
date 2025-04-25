package Top150;

import java.util.HashMap;

// 128
public class LongestConsecutiveSequence {
//    public static int[] parent;
    public static HashMap<Integer,Integer> parent;
    public static void union(int v, int w) {
        parent.put(find(v), find(w));
    }
    public static int find(int x){
        if (parent.get(x) != x){
            //return find(parent.get(x));
            parent.put(x, find(parent.get(x))); //加上路径压缩
        }
//        return x;
        return parent.get(x);
    }
    public int longestConsecutive(int[] nums) {
        //sanity check
        if (nums.length == 0) return 0;
        parent = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            parent.put(nums[i], nums[i]);
        }
        for (int i : nums){
            if (parent.containsKey(i-1)){
                union(i, i-1);
            }
        }
        int max = 0;
        for (HashMap.Entry<Integer, Integer> entry : parent.entrySet()) {
            max = Math.max(max,entry.getKey() - find(entry.getKey()));
        }
        return max+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,2};
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();
        System.out.println(sol.longestConsecutive(arr));
    }
}
