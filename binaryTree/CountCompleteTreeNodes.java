package binaryTree;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {

        if (root == null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right) + 1;
    }

    public static void main(String[] args) {

    }
}
