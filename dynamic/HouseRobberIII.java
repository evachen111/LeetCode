package dynamic;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

// 337
public class HouseRobberIII {
    // level order traversal
    public int[] helper(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(root);
        q1.add(null);
        TreeNode n0 = new TreeNode(-1);
        while (q1.size()>1){
            int sum = 0;
            while (q1.peek()!= null){
                TreeNode tmp = q1.remove();
                //operation
                if (tmp.val == -1){
                    q2.add(0);
                }
                else{
                    q2.add(tmp.val);
                    sum = 1;
                }
                if (tmp.left!=null){
                    q1.add(tmp.left);
                }
                else{
                    q1.add(n0);
                }
                if (tmp.right!=null){
                    q1.add(tmp.right);
                }
                else{
                    q1.add(n0);
                }
            }
            if (sum == 0){
                break;
            }
            q1.add(q1.remove());
        }
        int[] a = new int[q2.size()];
        for(int i = 0; i<q2.size(); i++){
            a[i] = q2.remove();
        }
        return a;
    }

    public int rob(TreeNode root) {
        if (root.left == null && root.right == null){
            return root.val;
        }

        int[] dp = helper(root);
        for (int i = (dp.length-3)/4-1; i>=0; i--){
            dp[i] = Math.max(dp[2*i+1]+dp[2*i+2],
                    dp[i]+dp[4*i+3]+dp[4*i+4]+dp[4*i+5]+ dp[4*i+6]);
        }
        return dp[0];
    }

    public int rob(int[] nums){
        int[] dp = new int[2*nums.length+1];
        for(int i = (nums.length-3)/2+1; i<nums.length; i++){
            dp[i] = nums[i];
        }
        for (int i = nums.length; i<=2*nums.length; i++){
            dp[i] = 0;
        }
        for (int i = (nums.length-3)/2; i>=0; i--){
            dp[i] = Math.max(dp[2*i+1]+dp[2*i+2],
                    nums[i]+dp[4*i+3]+dp[4*i+4]+dp[4*i+5]+ dp[4*i+6]);
        }
        return dp[0];
    }

    public static void main(String[] args) {

        HouseRobberIII sol = new HouseRobberIII();
        int[] a = {0,0,27,21,30,9,26,29,46,7,19,23,0,28,0,37,49,3,8,16,20,22,25,
                0,0,34,44,48,0,2,5,0,0,10,18,0,0,0,0,24,0,31,35,42,45,47,0,1,0,4,
                6,0,12,17,0,0,0,0,33,0,36,38,43,0,0,0,0,0,0,0,0,0,0,11,14,
                0,0,32,0,0,0,0,39,0,0,0,0,13,15,0,0,0,41,0,0,0,0,40};
        System.out.println(sol.rob(a));


//        TreeNode n31 = new TreeNode(3);
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2, null,n31);
//        TreeNode n32 = new TreeNode(3, null, n1);
//        TreeNode root = new TreeNode(3, n2, n32);
//        int[] a = sol.helper(root);
//        for (int i = 0; i<a.length; i++){
//            System.out.println(a[i]);
//        }
//        System.out.println(sol.rob(root));
    }
}
