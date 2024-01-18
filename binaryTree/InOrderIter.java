package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderIter {
    public List<Integer> inorderTraversal(TreeNode root) {
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
                st.push(tmp);
                st.push(null);
                if(tmp.left != null){
                    st.push(tmp.left);
                }
            }
            else {
                tmp = st.pop();
                result.add(tmp.val);
            }
        }


//        TreeNode cur = root;
//        while(cur != null || !st.isEmpty()){
//            if (cur != null){
//                st.push(cur);
//                cur = cur.left;
//            }
//            else{
//                cur = st.pop();
//                result.add(cur.val);
//                cur = cur.right;
//            }
//
//        }


        return result;
    }

}
