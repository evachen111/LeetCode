package binaryTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AverageOfLevel {
    private List<List<Double>> reList = new ArrayList<>();
    private List<Double> result = new ArrayList<>();

    private void addLevel(TreeNode node, int level){
        //base case
        if (node==null){
            return;
        }
        // deal with the list for each level
        if (level > reList.size()){
            List<Double> reLevel = new ArrayList<>();
            reList.add(reLevel);
        }
        // add value
        reList.get(level-1).add((double)node.val);
        // recursion
        addLevel(node.left, level+1);
        addLevel(node.right, level+1);

    }
    public List<Double> averageOfLevels(TreeNode root) {
        addLevel(root,1);
        for (List<Double> li : reList){
                // int can not handle 2147483647
            //result.add(((double)(li.stream().mapToInt(Integer::intValue).sum())/li.size()));
            double sum = 0;
            for (double i: li){
                sum+=i;
            }
            result.add(sum/li.size());
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode l4 = new TreeNode(2147483647);
        TreeNode l3 = new TreeNode(2147483647);

        TreeNode root = new TreeNode(2147483647,l4, l3);

        AverageOfLevel an = new AverageOfLevel();
        System.out.println(an.averageOfLevels(root));

//        double a = 2147483647;
//        System.out.println(a + a);
    }

}
