package Grind75;

//238
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int max = 1;
        int hasZero = 0;
        for (int i : nums){
            if (i == 0){
                hasZero++;
            }
            else{
                max = max*i;
            }
        }
        if (hasZero == 0){
            for (int i = 0; i<nums.length; i++){
                nums[i] = max / nums[i];
            }
        }
        else if (hasZero == 1){
            for (int i = 0; i<nums.length; i++){
                if (nums[i] == 0){
                    nums[i] = max;
                }
                else{
                    nums[i] = 0;
                }
            }
        }
        else{
            for (int i = 0; i<nums.length; i++){
                nums[i] = 0;
            }
        }
        return nums;
    }

    public static void main(String[] args) {


    }
}
