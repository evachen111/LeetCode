package binaryTree;

import java.util.ArrayList;
import java.util.List;

// 113
public class PathSum2 {
    public List<List<Integer>> result = new ArrayList<>();

    public void addPath (TreeNode node, List<Integer> reList, int val){

        reList.add(node.val);
        // base case
        if (node.left == null && node.right == null && node.val == val){
            result.add((new ArrayList<>(reList)));
        }

        if (node.left != null){
            addPath(node.left, reList, val- node.val);
            reList.remove(reList.size()-1);
        }
        if (node.right != null){
            addPath(node.right, reList, val- node.val);
            reList.remove(reList.size()-1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // sanity check
        if(root == null){
            return result;
        }
        List<Integer> reList = new ArrayList<>();
        addPath(root, reList, targetSum);
        return result;
    }

    public static void main(String[] args) {

    }
}
