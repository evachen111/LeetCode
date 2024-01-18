package binaryTree;

public class MinimumDepth {
    public int min( int a, int b){
        if (a<b){
            return a;
        }
        return b;
    }

    public int minDepth(TreeNode root) {
        // sanity check
        if (root == null){
            return 0;
        }

        // base case
        if (root.right == null && root.left == null){
            return 1;
        }
        else if (root.left == null){
            return minDepth(root.right) + 1;
        }
        else if (root.right == null ){
            return minDepth(root.left) + 1;
        }
        else {
            return min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public static void main(String[] args) {

    }
}
