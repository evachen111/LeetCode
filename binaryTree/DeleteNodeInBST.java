package binaryTree;

import com.sun.source.tree.Tree;

// 450
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        // find the node
        TreeNode p = root;
        TreeNode q = null;
        while (p != null){
            if (p.val == key){
                break;
            }
            else if (p.val>key){
                q = p;
                p = p.left;
            }
            else{
                q = p;
                p = p.right;
            }
        }
        // node not found
        if (p == null){
            return root;
        }
        // the node has no child
        if (p.left == null && p.right == null){
            if (q == null){
                return q;
            }
            else if (q.right == p){
                q.right = null;
            }
            else{
                q.left = null;
            }
        }
        // has one child
        else if (p.left == null){
            if (q == null){
                return p.right;
            }
            if (q.right == p){
                q.right = p.right;
            }
            else{
                q.left = p.right;
            }
        }
        else if(p.right == null){
            if (q == null){
                return p.left;
            }
            if (q.right == p){
                q.right = p.left;
            }
            else{
                q.left = p.left;
            }
        }
        // has 2 children
        // find the right most one of the left subtree
        else{

            TreeNode replace = p.left;
            while (replace.right!=null){
                replace = replace.right;
            }

            if (q == null){
                root = replace;
            }
            else{
                if (q.left == p){
                    q.left = replace;
                }
                else{
                    q.right = replace;
                }
            }

            replace.right = p.right;
            p.right = null;
            if (replace != p.left){
                while (replace.left!=null){
                    replace = replace.left;
                }
                replace.left = p.left;
            }
            p.left = null;

        }

        return root;
    }

    public static void main(String[] args) {

    }
}
