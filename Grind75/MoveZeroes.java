package Grind75;

// 283
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1){
            return;
        }
        int i = 0;
        int j = 1;
        int tmp;
        while (i<nums.length && j<nums.length){
            if (nums[i] != 0){
                i++;
                j = j+1;
            }
            // num[i] == 0
            else if (nums[j] != 0){
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            }

            else{
                j++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
