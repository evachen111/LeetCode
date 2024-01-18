package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();

    private void addLevel(Node root, int level){
        if (root == null){
            return;
        }

        if (level > result.size()){
            List<Integer> relist = new ArrayList<>();
            result.add(relist);
        }

        result.get(level-1).add(root.val);
        for (Node i : root.children){
            addLevel(i,level+1);
        }

    }
    public List<List<Integer>> levelOrder(Node root) {

        // sanity check
        if(root == null){
            return result;
        }
        addLevel(root, 1);

        return result;
    }

    public static void main(String[] args) {

    }

}
