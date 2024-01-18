package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIter {

    public List<Integer> preorderTraversal(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
                    // consistent
        // sanity check
        if (root != null){
            st.push(root);
        }

        while (!st.isEmpty()){
            TreeNode tmp = st.pop();
            if (tmp!=null){
                if (tmp.right != null){
                    st.push(tmp.right);
                }
                if(tmp.left != null){
                    st.push(tmp.left);
                }
                st.push(tmp);
                st.push(null);
            }
            else {
                tmp = st.pop();
                result.add(tmp.val);
            }
        }




//        // sanity check
//        if (root == null){
//            return result;
//        }
//
//        st.push(root);
//        while(!st.isEmpty()){
//            TreeNode tmp = st.pop();
//            result.add(tmp.val);
//
//            if (tmp.right!=null){
//                st.push(tmp.right);
//            }
//            if(tmp.left!=null){
//                st.push(tmp.left);
//            }
//        }

        return result;

    }
}
