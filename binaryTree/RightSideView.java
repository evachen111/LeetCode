package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//199
public class RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        //sanity check
        if (root == null){
            return result;
        }
        Queue<TreeNode> qu = new LinkedList<>();

        // traverse and output together with marks
        qu.add(root);
        qu.add(null);
        while (qu.size()>1){
            TreeNode tmp = null;
            while (qu.peek()!= null){
                tmp = qu.remove();
                if (tmp.left!=null){
                    qu.add(tmp.left);
                }
                if (tmp.right!=null){
                    qu.add(tmp.right);
                }
            }
            qu.add(qu.remove());// add null // mark new level
            result.add(tmp.val);
        }

        return result;

    // wrong
//        List<Integer> result = new ArrayList<>();
//        //sanity check
//        if (root == null){
//            return result;
//        }
//
//        TreeNode cur = root;
//
//        while (cur!=null){
//            result.add(cur.val);
//            if (cur.right!=null){
//                cur = cur.right;
//            }
//            else{
//                cur = cur.left;
//            }
//        }
//
//        return result;
    }

    public static void main(String[] args) {
        TreeNode l4 = new TreeNode(4);
        TreeNode l3 = new TreeNode(3);

        TreeNode n2 = new TreeNode(2,l4,null);
        TreeNode root = new TreeNode(1,n2, l3);

        System.out.println(rightSideView(root));

    }

}
