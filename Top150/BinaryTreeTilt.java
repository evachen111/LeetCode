package Top150;

// 563
public class BinaryTreeTilt {
    static int sum = 0;
    public static void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        if (root.left != null){
            root.val += root.left.val;
        }
        if (root.right!= null){
            root.val += root.right.val;
        }
    }
    public static void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        int diff = 0;
        if (root.left != null){
            diff = root.left.val;
        }
        if (root.right!= null){
            diff -= root.right.val;
        }
        sum += Math.abs(diff);
        preOrder(root.left);
        preOrder(root.right);
    }

    public int findTilt(TreeNode root) {
        // post-order traversal
        postOrder(root);
        // pre-order traversal
        sum = 0;
        preOrder(root);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(21);
        root.left = new TreeNode(7);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(3);

        BinaryTreeTilt sol = new BinaryTreeTilt();
        System.out.println(sol.findTilt(root));
    }
}
