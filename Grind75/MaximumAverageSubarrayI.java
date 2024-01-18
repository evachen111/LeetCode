package Grind75;

// 643
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int j = 0;
        int sum = 0;
        while (j<nums.length && j<k){
            sum += nums[j];
            j++;
        }
        int max = sum;
        for (int i =0; i<nums.length-k; i++){
            sum = sum + nums[k+i]-nums[i];
            max = Math.max(max,sum);
        }
        return (double)max/k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI sol = new MaximumAverageSubarrayI();
        int[] a = {1,12,-5,-6,50,3};
        System.out.println(sol.findMaxAverage(a,4));
    }
}
