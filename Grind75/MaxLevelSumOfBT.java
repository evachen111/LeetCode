package Grind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//1161
public class MaxLevelSumOfBT {
    public Queue<TreeNode> q = new LinkedList<>();
    public int maxSum = Integer.MIN_VALUE;
    public int maxIdx = 1;
    public int curIdx = 1;
    public int maxLevelSum(TreeNode root) {
        q.add(root);
        q.add(null);
        int levelSum = 0;
        while(!q.isEmpty()){
            TreeNode p = q.remove();
            if (p==null){
                if (levelSum>maxSum){
                    maxIdx = curIdx;
                    maxSum = levelSum;
                }
                levelSum = 0;
                if (!q.isEmpty()){
                    q.add(null);
                    curIdx++;
                }
            }
            else{
                levelSum += p.val;
                if (p.left!=null){
                    q.add(p.left);
                }
                if (p.right!=null){
                    q.add(p.right);
                }
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {

    }
}
