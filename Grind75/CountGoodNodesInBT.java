package Grind75;

// 1448
public class CountGoodNodesInBT {

    private int re = 0;
    public void check(TreeNode root, int max){
        if (root.val >= max){
            re++;
            max = root.val;
        }

        if (root.left != null){
            check(root.left,max);
        }
        if (root.right != null){
            check(root.right, max);
        }
    }

    public int goodNodes(TreeNode root) {
        if (root.left == null && root.right == null){
            return 1;
        }

        check(root, root.val);
        return re;
    }

    public static void main(String[] args) {

    }
}
