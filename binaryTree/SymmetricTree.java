package binaryTree;

import java.util.*;

public class SymmetricTree {
    public List<Stack<TreeNode>> reList = new ArrayList<>();

    private int max;

    private TreeNode nullNode = new TreeNode(-101);
    public int max(int a, int b){
        if (a > b) {
            return a;
        }
        return b;
    }

    public int maxDepth(TreeNode root) {
        // recursive
        // base case
        if (root == null){
            return 0;
        }

        return max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    public void addLevel(TreeNode node, int level){
//        if(node == null){
//            return;
//        }
        if (level>max){
            return;
        }

        if (level>reList.size()){
            Stack<TreeNode> st = new Stack<>();
            reList.add(st);
        }

        if (reList.get(level-1).isEmpty()){
            reList.get(level-1).push(node);
        }
        else{
            TreeNode tmp = reList.get(level-1).pop();
            if ((tmp == null && node == null) || (tmp!=null && node !=null && tmp.val == node.val)){

            }
            else{
                reList.get(level-1).push(tmp);
                reList.get(level-1).push(node);
            }
        }


//        if (node.left == null){
//            addLevel(nullNode,level+1);
//        }
//        else {
//            addLevel(node.left,level+1);
//        }
//        if (node.right == null){
//            addLevel(nullNode, level+1);
//        }
//        else {
//            addLevel(node.right,level+1);
//        }
        if(!(node.right== null && node.left == null)){
            if (node.left == null){
                addLevel(nullNode,level+1);
                addLevel(node.right,level+1);
            }
            else if (node.right == null){
                addLevel(node.left,level+1);
                addLevel(nullNode, level+1);
            }
            else {
                addLevel(node.left,level+1);
                addLevel(node.right,level+1);
            }
        }
        else {
            addLevel(nullNode, level+1);
        }


    }
    public boolean isSymmetric(TreeNode root) {
        max = maxDepth(root);
        addLevel(root,1);
        for (int i = 1; i<reList.size(); i++){
            if (reList.get(i).size()>0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        TreeNode n31 = new TreeNode(3);
        TreeNode n32 = new TreeNode(3);

        TreeNode n21 = new TreeNode(2,null, null);
        TreeNode n22 = new TreeNode(2, n31, n32);

        TreeNode root = new TreeNode(1, n21, n22);

        SymmetricTree sol = new SymmetricTree();
        System.out.println(sol.isSymmetric(root));

    }
}
