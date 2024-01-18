package binaryTree;

public class BalancedBinaryTree {
    public int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        else if (root.left != null && root.right!=null){
            return Math.abs(getDepth(root.left) - getDepth(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
        }

        else if (root.left == null && getDepth(root.right) <= 1){
            return true;
        }
        else if (root.right == null && getDepth(root.left) <= 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {


    }
}
