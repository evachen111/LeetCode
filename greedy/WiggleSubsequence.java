package greedy;

//376
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1){
            return 1;
        }

        int cnt = 1;
        int cur = nums[0];
        int j = 1;
        while (j<nums.length && nums[j] == cur){
            j++;
        }
        if (j == nums.length){
            return cnt;
        }
        boolean larger = nums[j] > nums[0];
        for (int i =j; i<nums.length; i++){
            if (larger){
                if (nums[i] > cur){
                    cnt++;
                    larger = false;
                }
                cur = nums[i];
            }
            if (!larger){
                if (nums[i] < cur){
                    cnt++;
                    larger = true;
                }
                cur = nums[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {


    }
}
