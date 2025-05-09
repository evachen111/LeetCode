package Top150;

import java.util.PriorityQueue;

public class LCAofBT {
    public static TreeNode p;
    public static TreeNode q;
    public static TreeNode result;
    public static int hasResult = 0;
    public static void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        if (root.left != null && root.left == p){
            p = root;
        }
        if (root.left != null && root.left == q){
            q = root;
        }
        if (root.right != null && root.right == p){
            p = root;
        }
        if (root.right != null && root.right == q){
            q = root;
        }
        if (p == root && q == root && hasResult ==0){
            result = root;
            hasResult=1;
            return;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        postOrder(root);
        hasResult = 0;
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode q = new TreeNode(5);
        root.left = q;
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        TreeNode p = new TreeNode(4);
        root.left.right.right = p;
        LCAofBT sol = new LCAofBT();
        System.out.println(sol.lowestCommonAncestor(root, p, q).val);
    }
}
