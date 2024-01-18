package greedy;

//55
public class JumpGame {

//    public boolean helper(int[] nums, int idx){
//        // base case
//        if (idx + nums[idx] >= nums.length-1){
//            return true;
//        }
//
//        for (int i = 1; i<=nums[idx]; i++){
//            if (helper(nums,idx+i)){
//                return true;
//            }
//        }
//        return false;
//    }


//    public boolean couldBeReached(int[] nums, int end){
//        if (end == 0){
//            return true;
//        }
//        for (int i = end-1; i>=0; i--){
//            if (nums[i] + i >= end && couldBeReached(nums,i)){
//                return true;
//            }
//        }
//        return false;
//    }


    public boolean canJump(int[] nums) {
            //1
//        return helper(nums,0);
            //2
//        return  couldBeReached(nums, nums.length-1);
            //3
//        boolean[] canGet = new boolean[nums.length];
//        canGet[0] = true;
//        for (int i = 0; i<nums.length; i++){
//            if (canGet[i] && nums[i] > 0){    // i 每次移动只能在 cover 的范围内移动
//                for (int j = 1; j<=nums[i] && (i+j)<nums.length; j++){
//                    canGet[i+j] = true;
//                }
//            }
//        }
//        return canGet[nums.length-1];

        //4
        int far = 0;
        for (int i = 0; i<=far; i++){ //i 每次移动只能在 cover 的范围内移动
            if (i + nums[i]> far){
                far = i + nums[i];
            }
            if (far >= nums.length-1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,0,4};
        JumpGame sol = new JumpGame();
        System.out.println(sol.canJump(a));
    }
}
