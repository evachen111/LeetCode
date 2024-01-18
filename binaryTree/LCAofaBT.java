package binaryTree;


//236
public class LCAofaBT {
    public boolean isAnc(TreeNode root, TreeNode node){
        if (root == null){
            return false;
        }
        if (root == node){
            return true;
        }
        // left
        if (root.left != null &&isAnc(root.left, node)){
            return true;
        }
        // right
        if (root.right != null && isAnc(root.right, node)) {
            return true;
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isAnc(root.left, p) && isAnc(root.left, q)){
            return lowestCommonAncestor(root.left, p,q);
        }
        if (isAnc(root.right, p) && isAnc(root.right, q)){
            return lowestCommonAncestor(root.right, p,q);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n7, n4);
        TreeNode n5 = new TreeNode(5, n6, n2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n1 = new TreeNode(1, n0, n8);
        TreeNode n3 = new TreeNode(3, n5, n1);

        LCAofaBT sol = new LCAofaBT();
        TreeNode re = sol.lowestCommonAncestor(n3, n6, n2);
        System.out.println(re.val);
    }

}
