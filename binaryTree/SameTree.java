package binaryTree;

// 100 = invertBT + SymmetricTree
public class SameTree {
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        q = invertTree(q);
        TreeNode root = new TreeNode(0,p,q);

        return isSymmetric(root);
    }

    public static void main(String[] args) {

    }
}
