package Grind75;

import java.util.*;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> l1 = new LinkedList<>();
        Queue<TreeNode> l2 = new LinkedList<>();
        TreeNode p = root1;
        Stack<TreeNode> st = new Stack<>();
        if (root1!=null){
            st.push(root1);
        }
        while (!st.isEmpty()){
            TreeNode tmp = st.pop();
            if (tmp.left== null && tmp.right == null){
                l1.add(tmp);
            }

            if (tmp.right!= null){
                st.push(tmp.right);
            }
            if (tmp.left!= null){
                st.push(tmp.left);
            }
        }

        if (root2!=null){
            st.push(root2);
        }
        while (!st.isEmpty()){
            TreeNode tmp = st.pop();
            if (tmp.left== null && tmp.right == null){
                l2.add(tmp);
            }

            if (tmp.right!= null){
                st.push(tmp.right);
            }
            if (tmp.left!= null){
                st.push(tmp.left);
            }
        }

        if (l1.size() != l2.size()){
            return false;
        }
        while (!l1.isEmpty()){
            if (l1.remove().val!=l2.remove().val){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
