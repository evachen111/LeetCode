package binaryTree;


import java.util.ArrayList;
import java.util.List;

// 501
public class FindModeInBST {
    public List<Integer> result = new ArrayList<>();
    public int cur;
    public int max;
    public TreeNode last;
    public void inOrder(TreeNode root) {
        //left
        if (root.left != null){
            inOrder(root.left);
        }
        //mid
        if (last!= null && last.val == root.val){
            cur++;
        }
        else{
            cur = 1;
        }

        if (cur == max){
            result.add(root.val);
        }
        if (cur > max){
            result.clear();
            result.add(root.val);
            max = cur;
        }
        last = root;

        //right
        if (root.right!=null){
            inOrder(root.right);
        }
    }

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] finalResult = result.stream().mapToInt(i->i).toArray();
        return finalResult;
    }

    public static void main(String[] args) {

        TreeNode n22 = new TreeNode(2);
        TreeNode n21 = new TreeNode(2, n22, null);
        TreeNode n1 = new TreeNode(1, null, n21);
        FindModeInBST sol = new FindModeInBST();
        int[] re = sol.findMode(n1);
        for (int i: re){
            System.out.println(i);
        }


    }
}
