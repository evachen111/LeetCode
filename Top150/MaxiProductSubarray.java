package Top150;

// 152
public class MaxiProductSubarray {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(min[i-1]*nums[i], Math.max(nums[i] , max[i-1]*nums[i]));
            min[i] = Math.min(min[i-1]*nums[i], Math.min(nums[i] , max[i-1]*nums[i]));
        }

        int res = nums[0];
        for (int i : max){
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxiProductSubarray sol = new MaxiProductSubarray();
        System.out.println(sol.maxProduct(new int[]{-1,-2,-3,-3}));
    }
}
