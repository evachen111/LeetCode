package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public static void PostOrder(TreeNode root, List<Integer> list){
        if(root!=null){
            PostOrder(root.left, list);
            PostOrder(root.right, list);
            list.add(root.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        PostOrder(root, result);

        return result;
    }

}
