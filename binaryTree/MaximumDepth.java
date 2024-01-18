package binaryTree;

public class MaximumDepth {

    public int max(int a, int b){
        if (a > b) {
            return a;
        }
        return b;
    }

    public int maxDepth(TreeNode root) {
        // recursive
        // base case
        if (root == null){
            return 0;
        }

        return max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }


    public static void main(String[] args) {

    }
}
