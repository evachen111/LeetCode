package binaryTree;

import java.util.Stack;

// 98
public class ValidateBST {

    public Stack<Integer> st = new Stack<>();
    public boolean result = true;
    public void inOrderCheck(TreeNode node){
        if (node == null){
            return;
        }
        inOrderCheck(node.left);
        if (!st.isEmpty()){
            int val = st.pop();
            if (node.val <= val){
                result = false;
            }
        }
        st.push(node.val);
        inOrderCheck(node.right);

    }

    public TreeNode max;
    public boolean isValidBST(TreeNode root) {
        // 1st
//        if (root == null){
//             return true;
//        }
//        if (root.left != null && root.left.val >= root.val){
//            return false;
//        }
//        if (root.right != null && root.right.val <= root.val){
//            return false;
//        }
//
//        return isValidBST(root.left) && isValidBST(root.right);

        // 2nd
//        inOrderCheck(root);
//        return result;

        // combined in one
        if (root == null){
            return true;
        }
        // check left
        if (!isValidBST(root.left)){
            return false;
        }
        // mid
        if (max != null && root.val <= max.val){
            return false;
        }
        max = root;

        // check right
        return isValidBST(root.right);

    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode node = new TreeNode(2, n1, n3);
        ValidateBST sol = new ValidateBST();
        System.out.println(sol.isValidBST(node));
    }
}
