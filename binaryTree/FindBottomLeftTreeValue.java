package binaryTree;

// 513
public class FindBottomLeftTreeValue {

    public int result;
    public int maxLevel = 0;
    public void nextLevel(TreeNode node, int level){
        if (node == null){
            return;
        }
        if (level>maxLevel){
            maxLevel = level;
            result = node.val;
        }
        nextLevel(node.left, level+1);    // makes sure that the first one is the left most one
        nextLevel(node.right, level+1);
    }

    public int findBottomLeftValue(TreeNode root) {
        nextLevel(root,1);
        return result;
    }

    public static void main(String[] args) {

    }
}
