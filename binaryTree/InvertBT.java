package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class InvertBT {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public static void main(String[] args) {

    }
}
