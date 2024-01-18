package binaryTree;

public class SymmetricTreeRec {
    public boolean compare(TreeNode l, TreeNode r){
        // ends the recursion
        if (l == null && r == null){
            return true;
        }
        else if (l == null || r == null){
            return false;
        }
        else if (l.val != r.val){
            return false;
        }
        // recursion
        return compare(l.left, r.right) && compare(l.right, r.left);

    }

    public boolean isSymmetric(TreeNode root) {

        if (root.left == null && root.right == null){
            return true;
        }

        return compare(root.left, root.right);
    }

    public static void main(String[] args) {

    }

}
