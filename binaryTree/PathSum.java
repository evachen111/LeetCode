package binaryTree;

//112
public class PathSum {
    public boolean result = false;
    public int target;

    public void addPath(TreeNode node, int val){
        // if node: append
        int pathVal = val + node.val;

        // if leaves: output
        if (node.left == null && node.right == null) {
            if (pathVal == target){
                result = true;
            }
        }
        if (node.left != null){
            addPath(node.left,pathVal);
        }
        if (node.right != null){
            addPath(node.right,pathVal);
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
//        target = targetSum;
//        if (root == null){
//            return result;
//        }
//        addPath(root,0);
//        return result;


        // less memory
        //sanity check
        if (root == null){
            return false;
        }
        //base case
        if (root.left == null && root.right == null && root.val == targetSum){
            return true;
        }
        // all recursive cases return true
        if (root.left != null && hasPathSum(root.left, targetSum-root.val)){
            return true;
        }

        if (root.right != null && hasPathSum(root.right, targetSum-root.val)){
            return true;
        }

        //else
        return false;

    }

    public static void main(String[] args) {

    }
}
