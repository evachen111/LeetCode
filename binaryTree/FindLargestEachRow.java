package binaryTree;

import java.util.ArrayList;
import java.util.List;

//515
public class FindLargestEachRow {
    public List<Integer> reList = new ArrayList<>();

    private void addLevel(TreeNode node, int level){
        //base case
        if (node==null){
            return;
        }

        // check null
        if (reList.size()<level){
            reList.add(node.val);
        }
        else {
            // check value
            int val = reList.get(level-1);
            //replace
            if (val < node.val){
                reList.set(level-1,node.val);
            }
        }

        // recursion
        addLevel(node.left, level+1);
        addLevel(node.right, level+1);

    }

    public List<Integer> largestValues(TreeNode root) {
        addLevel(root,1);
        return reList;
    }

    public static void main(String[] args) {

    }
}
