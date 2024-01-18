package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    public static void InOrder(TreeNode root, List<Integer> list){
    if(root!=null){
        InOrder(root.left, list);
        list.add(root.val);
        InOrder(root.right, list);
    }
}

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        InOrder(root, result);

        return result;
    }
}
