package Grind75;

// 162
public class FindPeakElement {
    public int checkMid(int[] nums, int l, int r){
        if (l>r){
            return -1;
        }
        int m = (l+r)/2;

        if (m==nums.length-1){
            if (nums[m] > nums[m-1]){
                return m;
            }
            return -1;
        }

        else if (m==0){
            if (nums[m] > nums[m+1]){
                return m;
            }
            if(checkMid(nums,m+1,r) != -1){
                return checkMid(nums,m+1,r);
            }
            return -1;
        }

        else if (nums[m] > nums[m+1] && nums[m] > nums[m-1]){
            return m;
        }

        else{
            if(checkMid(nums,m+1,r) != -1){
                return checkMid(nums,m+1,r);
            }
            if(checkMid(nums,l, m-1) != -1){
                return checkMid(nums,l, m-1);
            }
        }
        return -1;
    }

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        if (r==0){
            return 0;
        }
        if (r == 1){
            if (nums[0]> nums[1]){
                return 0;
            }
            return 1;
        }
        return checkMid(nums,l,r);
    }

    public static void main(String[] args) {
        FindPeakElement sol = new FindPeakElement();
        int[] n = {5,4,3,2,1};
        System.out.println(sol.findPeakElement(n));
    }
}
