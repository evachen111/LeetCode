package Top150;

// 543
public class DiameterOfBinaryTree {
    public static int res;
    public static int longestPath(TreeNode root){
//        // root != null
//        int len = 0;
//        int left = 0;
//        int right = 0;
//        if(root.left == null && root.right == null){
//            return 0;
//        }
//        else if (root.left == null){
//            left = longestPath(root.right);
//            len =  left + 1;
//        }
//        else if (root.right == null){
//            right = longestPath(root.left);
//            len = right + 1;
//        }
//        else{
//            left = longestPath(root.right);
//            right = longestPath(root.left);
//            if (left + right + 2 > res){
//                res = left + right + 2;
//            }
//            len = Math.max(left,right) + 1;
//        }
//
//        if (len >res){
//            res = len;
//        }
//        return len;

        if (root == null){
            return 0;
        }
        int left = longestPath(root.right);
        int right = longestPath(root.left);
        if (left + right > res){
            res = left + right;
        }
        return Math.max(left,right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        int tmp = res;
        res = 0;
        return tmp;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(sol.diameterOfBinaryTree(root));
    }
}
