package binaryTree;

import java.util.*;

//145
public class PostOrderIter {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();

        // consistent
        if (root != null){
            st.push(root);
        }

        while (!st.isEmpty()){
            TreeNode tmp = st.pop();
            if (tmp!=null){
                st.push(tmp);
                st.push(null);

                if (tmp.right != null){
                    st.push(tmp.right);
                }
                if(tmp.left != null){
                    st.push(tmp.left);
                }
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
//            if(tmp.left!=null){
//                st.push(tmp.left);
//            }
//            if (tmp.right!=null){
//                st.push(tmp.right);
//            }
//        }
//
//        Collections.reverse(result);
        return result;
    }
}
