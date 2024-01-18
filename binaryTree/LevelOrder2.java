package binaryTree;

import java.util.*;

public class LevelOrder2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
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
                list.add(tmp.val);
                if (tmp.left!=null){
                    qu.add(tmp.left);
                }
                if (tmp.right!=null){
                    qu.add(tmp.right);
                }
            }
            qu.add(qu.remove());// add null // mark new level
            // change to linked list
                // do not need collections.reverse()
            result.addFirst(list);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
