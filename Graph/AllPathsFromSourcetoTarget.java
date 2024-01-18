package Graph;

import java.util.ArrayList;
import java.util.List;

// 797
public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> re = new ArrayList<>();

    public void DFSTree(int[][] graph, int v){
        re.add(v);

        // check if it's the ending node
        if (v == graph.length-1){
            result.add(new ArrayList<>(re));
        }
        else{
            for (int i = 0; i<graph[v].length; i++){
                DFSTree(graph, graph[v][i]);
            }
        }

        re.remove(re.size()-1);
    }

//    public void helper(int[][] graph, int[] color){
//        for (int i = 0; i<graph.length; i++){
//            if (color[i] == 0){
//                DFSTree(graph,i,color);
//            }
//        }
//    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        int[] color = new int[graph.length];
        DFSTree(graph,0);
        return result;
    }

    public static void main(String[] args) {
        AllPathsFromSourcetoTarget sol = new AllPathsFromSourcetoTarget();
        int[][] g = {{1,2},{3},{3},{}};
        sol.allPathsSourceTarget(g);
    }
}
