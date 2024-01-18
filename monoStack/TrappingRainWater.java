package monoStack;

// 42
// the next/previous largest
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] next = new int[height.length];
        int[] pre = new int[height.length];

        int max = 0;
        for (int i = height.length-1; i>=0; i--){
            next[i] = max;
            max = Math.max(max,height[i]);
        }
        max = 0;
        for (int i = 0; i<height.length; i++){
            pre[i] = max;
            max = Math.max(max,height[i]);
        }
        int sum = 0;
        for (int i = 0; i<height.length; i++){
            sum += Math.max(0, Math.min(pre[i],next[i])-height[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater sol = new TrappingRainWater();
        System.out.println(sol.trap(a));
    }
}
