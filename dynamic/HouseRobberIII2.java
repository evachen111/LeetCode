package dynamic;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII2 {
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        //base case
        if (memo.containsKey(root)){
            System.out.println("====");
            return memo.get(root);
        }
        if (root == null){
            return 0;
        }

        int value = root.val;
        if (root.left != null){
            value = value + rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            value = value + rob(root.right.left) + rob(root.right.right);
        }
        value = Math.max(rob(root.left) + rob(root.right), value);

        memo.put(root, value);
        return value;
    }

    public static void main(String[] args) {

    }

}
