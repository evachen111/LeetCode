package binaryTree;

import java.util.Arrays;

// 106
public class ConstructBTfromInorderAndPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0){
            return null;
        }

        int rVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rVal);

        // find the right node
        int idx = 0;
        for (int i = 0; i<inorder.length; i++){
            if (inorder[i] == rVal){
               idx = i;
            }
        }
        int interval = inorder.length-1-idx;

        int[] newInL = Arrays.copyOfRange(inorder, 0, idx);
        int[] newPostL = Arrays.copyOfRange(postorder, 0 , postorder.length-1-interval);
        int[] newInR = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        int[] newPostR = Arrays.copyOfRange(postorder, postorder.length-1-interval, postorder.length-1);

        root.left = buildTree(newInL,newPostL);
        root.right = buildTree(newInR,newPostR);

        return root;
    }

    public static void main(String[] args) {
//        int[] src = new int[] {1, 2, 3, 4, 5};
//        int[] dst = Arrays.copyOfRange(src,0,3); // 1,2,3


    }
}
