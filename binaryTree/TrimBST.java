package binaryTree;


// 669
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null){
            if  (root.val<low || root.val > high){
                return null;
            }
            return root;
        }
        // case 1
        if (root.val > high){
            return trimBST(root.left, low, high);
        }
        // case 2
        if (root.val < low){
            return trimBST(root.right, low, high);
        }
        //case 3
        if (root.left != null){
            root.left = trimBST(root.left, low, high);
        }
        if (root.right != null){
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
