package binaryTree;

import java.util.ArrayList;
import java.util.List;

//257
public class BinaryTreePaths {
    public List<String> result = new ArrayList<>();

    public void addPath(TreeNode node, String apath){
        // if node: append
        StringBuffer path = new StringBuffer(apath);
        path.append("->");
        path.append(node.val);

        // if leaves: output
        if (node.left == null && node.right == null) {
            result.add(path.delete(0,2).toString());
        }
        if (node.left != null){
            addPath(node.left,path.toString());
        }
        if (node.right != null){
            addPath(node.right,path.toString());
        }
    }


    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return result;
        }
        addPath(root,"");
        return result;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, null, n5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);

        BinaryTreePaths sol = new BinaryTreePaths();
        System.out.println(sol.binaryTreePaths(n1));

    }
}
