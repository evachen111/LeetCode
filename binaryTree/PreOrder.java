package binaryTree;


import java.util.ArrayList;
import java.util.List;

//144
public class PreOrder {
    public static void preOrder(TreeNode root, List<Integer> list){
        if(root!=null){
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
//        preOrder(root, result);

        //2
        if (root != null){
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }



        return result;
    }

    public static void main(String[] args) {

    }

}
