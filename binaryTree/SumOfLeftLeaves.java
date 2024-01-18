package binaryTree;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        // focus on the left
        TreeNode node = root.left;
        if (node == null){
            // case 1
            return sumOfLeftLeaves(root.right);
        }
        if (node.left == null && node.right == null){
            // case 2
            return node.val + sumOfLeftLeaves(root.right);
        }
        // case 3
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }


    public static void main(String[] args) {

    }
}
