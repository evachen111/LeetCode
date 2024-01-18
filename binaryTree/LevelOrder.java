package binaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//102

// new level:
    // 1. null mark
    // 2. depth argument, find the d-th list element in the result list
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //sanity check
        if (root == null){
            return result;
        }
        Queue<TreeNode> qu = new LinkedList<>();

        // traverse and output together with marks
        qu.add(root);
        qu.add(null);
        while (qu.size()>1){
            List<Integer> list = new ArrayList<>();
            while (qu.peek()!= null){
                TreeNode tmp = qu.remove();
                //operation
                list.add(tmp.val);

                if (tmp.left!=null){
                    qu.add(tmp.left);
                }
                if (tmp.right!=null){
                    qu.add(tmp.right);
                }
            }
            qu.add(qu.remove());// add null // mark new level
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode l9 = new TreeNode(9);
        TreeNode l15 = new TreeNode(15);
        TreeNode l7 = new TreeNode(7);

        TreeNode n20 = new TreeNode(20,l15,l7);
        TreeNode root = new TreeNode(3, l9, n20);

        System.out.println(levelOrder(root));
    }
}
