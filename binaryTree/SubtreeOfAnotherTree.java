package binaryTree;

public class SubtreeOfAnotherTree {
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

        // without modifying the original tree structure
        boolean result = isSymmetric(root);
        q = invertTree(q);
        return result;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // base case
         if (isSameTree(root, subRoot)){
             return true;
         }
         if (root == null){
             return false;
         }

         // recursion
         return isSubtree(root.left, subRoot)||isSubtree(root.right, subRoot);

    }

    public static void main(String[] args) {
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(1);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4,n11,n21);

        TreeNode subRoot = new TreeNode(4,n12,n22);

        TreeNode n5 =  new TreeNode(5);
        TreeNode root = new TreeNode(3, n4, n5);

        SubtreeOfAnotherTree sol = new SubtreeOfAnotherTree();
        System.out.println(sol.isSubtree(root, subRoot));
    }
}
