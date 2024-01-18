package binaryTree;

// 235
public class LCAofaBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if((p.val >root.val && root.val > q.val) || (p.val < root.val && root.val < q.val)){
            return root;
        }
        else if (p.val >root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }

    public static void main(String[] args) {

    }
}
