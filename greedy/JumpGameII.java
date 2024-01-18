package greedy;

//45
public class JumpGameII {
    public int jump(int[] nums) {

        //1
        if (nums.length == 1){
            return 0;
        }
//        int[] hops = new int[nums.length];
//        hops[0] = 0;
//        for (int i = 0; i<nums.length; i++){
//            if (nums[i]>0){
//                for (int j = 1; j<=nums[i] && i+j<nums.length; j++){
//                    if (hops[i+j]!=0){
//                        hops[i+j] = Math.min(hops[i] + 1,hops[i+j]);
//                    }
//                    else{
//                        hops[i+j] = hops[i] + 1;
//                    }
//                }
//            }
//        }
//        return hops[nums.length-1];

        //2
        int cover = 0;
        int canCover=0;
        int jump = 0;

        for (int i = 0; i<nums.length; i++){
            // update canCover at this step
            canCover = Math.max(i + nums[i], canCover);

            if (canCover >= nums.length-1){
                jump++;          // last jump
                return jump;
            }
            if (i == cover){     // when to jump?    // when go out of the last coverage
                jump++;
                cover = canCover;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        JumpGameII sol = new JumpGameII();
        int[] a = {2,3,1,1,4};
        System.out.println(sol.jump(a));
    }
}
