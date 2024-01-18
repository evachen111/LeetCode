package binaryTree;

// 538
public class ConvertBSTtoGreaterTree {
    public int sum;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        // right
        root.right = convertBST(root.right);
        // mid
        sum = sum + root.val;
        root.val = sum;
        // left
        root.left = convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {

    }
}
