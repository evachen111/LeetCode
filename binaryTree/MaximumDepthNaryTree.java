package binaryTree;

import java.util.*;

public class MaximumDepthNaryTree {
    public int maxDepth(Node root) {

        if(root == null){
            return 0;
        }

        if (root.children.size() == 0){
            return 1;
        }

//        List<Integer> reList = new ArrayList<>();
//        for (Node i : root.children){
//            reList.add(maxDepth(i));
//        }
//
//        Collections.sort(reList);
//
//        return reList.get(reList.size()-1) + 1;

        // find the largest one == 逐个比较 != 全部放进来sort, pick one
        int depth = 0;
        for (Node i : root.children){
            depth = Math.max(depth, maxDepth(i));
        }

        return depth + 1;

    }


    public static void main(String[] args) {

    }
}
