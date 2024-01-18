package binaryTree;

import java.util.Arrays;

public class ConstructBTFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // sanity check
        if (inorder.length == 0){
            return null;
        }

        // get the root
        TreeNode root = new TreeNode(preorder[0]);

        // find root in inorder
        int idx = 0;
        for (int i = 0; i<inorder.length; i++){
            if (inorder[i] == root.val){
                idx = i;
            }
        }
        int interval = inorder.length - idx -1;

        // new inorder and new preorder for recursion
        int[] newInL = Arrays.copyOfRange(inorder, 0, idx);
        int[] newPreL = Arrays.copyOfRange(preorder, 1 , idx+1);
        int[] newInR = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        int[] newPreR = Arrays.copyOfRange(preorder, preorder.length-interval, preorder.length);

        root.left = buildTree(newPreL, newInL);
        root.right = buildTree(newPreR, newInR);
        return root;
    }

    public static void main(String[] args) {

    }
}
