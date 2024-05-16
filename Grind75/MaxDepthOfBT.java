package Grind75;

import LinkedList.LinkedList;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

//104
public class MaxDepthOfBT {

    public int backtracking(TreeNode root, int lev){
        if (root.left == null && root.right == null){
            return lev;
        }

        int left = lev;
        int right = lev;
        if (root.left != null){
            left = backtracking(root.left, lev + 1);
        }
        if (root.right != null){
            right = backtracking(root.right, lev+1);
        }

        return Math.max(left,right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        return backtracking(root,1);
    }

    public static void main(String[] args) {

    }
}
