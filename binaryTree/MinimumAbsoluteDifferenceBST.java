package binaryTree;

//530
public class MinimumAbsoluteDifferenceBST {

    public TreeNode last;
    public int dif = 100001;
    public int getMinimumDifference(TreeNode root) {
        // left
        if (root.left != null && getMinimumDifference(root.left) < dif){
            dif = getMinimumDifference(root.left);
        }

        // mid
        if(last!=null && root.val - last.val < dif){
            dif = root.val - last.val;
        }
        last = root;

        // right
        if (root.right != null && getMinimumDifference(root.right) < dif){
            dif = getMinimumDifference(root.right);
        }
        return dif;
    }

    public static void main(String[] args) {


    }
}
