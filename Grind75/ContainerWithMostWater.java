package Grind75;

// 11
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        int left = 0;
        int ri = 0;
        while(i<j){
            left = height[i];
            ri = height[j];
            max = Math.max(max, Math.min(left,ri)*(j-i));
            if(left>ri){
                j--;
            }
            else{
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
