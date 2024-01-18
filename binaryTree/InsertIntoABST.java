package binaryTree;

//701
public class InsertIntoABST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode p = root;
        TreeNode q = root;
        while (q!=null){
            if (q.val > val){
                p = q;
                q = q.left;
            }
            else if  (q.val<val){
                p = q;
                q = q.right;
            }
        }
        if (p.val > val){
            p.left = new TreeNode(val);
        }
        else {
            p.right = new TreeNode(val);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
