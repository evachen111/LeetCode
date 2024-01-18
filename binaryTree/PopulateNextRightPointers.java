package binaryTree;

import java.util.ArrayList;
import java.util.List;

//116 117

// if the binary tree is complete?
    //
public class PopulateNextRightPointers {

    public List<nNode> result = new ArrayList<>();

    private void addLevel(nNode node, int level){
        //base case
        if (node==null){
            return;
        }
        // deal with the list for each level
        if (level > result.size()){
            result.add(node);
        }
        else {
            // link nodes
            result.get(level-1).next = node;
            // change node stored
            result.set(level-1, node);
        }
        node.next = null;
        // recursion
        addLevel(node.left, level+1);
        addLevel(node.right, level+1);

    }

    public nNode connect(nNode root) {
        addLevel(root,1);

        return root;
    }

    public static void main(String[] args) {


    }
}
