package Graph;

// 685
public class RedundantConnectionII {
    public int[] parent;
    public int find(int x){
        if (parent[x] != x){
            return find(parent[x]);
        }
        else{
            return x;
        }
    }
    public void union(int x, int y){
        parent[y] = x;
    }

    public boolean check(int[][] edges, int k) {
        for (int j = 0; j<=edges.length; j++){
            parent[j] = j;
        }

        for (int i = 0; i<edges.length; i++){
            if (i == k){
                continue;
            }
            if (find(edges[i][0]) != find(edges[i][1])){
                union(edges[i][0], edges[i][1]);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        parent = new int[edges.length+1];

        // quicker: N^2 --> N (+ 2N) + N
        for (int j = 0; j<=edges.length; j++){
            parent[j] = j;
        }

        int idx1 = -1;
        int idx2 = -1;

        // check degree
        for (int i = 0; i<edges.length; i++){
            if (parent[edges[i][1]] == edges[i][1]){
                union(edges[i][0], edges[i][1]);
            }
            else{
                idx1=i;
                for (int j = 0; j<i; j++){
                    if (edges[j][0] == parent[edges[i][1]]&& edges[j][1] == edges[i][1]){
                        idx2 = j;
                    }
                }
                if (check(edges, idx1)){
                    return edges[idx1];
                }
                else {
                    return edges[idx2];
                }
            }
        }

        for (int j = 0; j<=edges.length; j++){
            parent[j] = j;
        }

        int idx = -1;
        for (int i = 0; i<edges.length; i++){
            if (find(edges[i][0]) != find(edges[i][1])){
                union(edges[i][0], edges[i][1]);
            }
            else{
                idx = i;
            }
        }
        return edges[idx];
    }

    public static void main(String[] args) {
        int[][] g = {{2,1}, {3,1}, {4,2},{1,4}};
        RedundantConnectionII sol = new RedundantConnectionII();
        sol.findRedundantDirectedConnection(g);
    }
}


//class Solution {
//    public int[] parent;
//    public int find(int x){
//        if (parent[x] != x){
//            return find(parent[x]);
//        }
//        else{
//            return x;
//        }
//    }
//    public void union(int x, int y){
//        parent[y] = x;
//    }
//
//    public boolean check(int[][] edges, int k) {
//        for (int i = 0; i<edges.length; i++){
//            if (i == k){
//                continue;
//            }
//            if (find(edges[i][0]) != find(edges[i][1])){
//                // normal
//                if (parent[edges[i][1]] == edges[i][1]){
//                    union(edges[i][0], edges[i][1]);
//                }
//                // check parent
//                else{
//                    return false;
//                }
//            }
//            else{
//                // check cycle
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public int[] findRedundantDirectedConnection(int[][] edges) {
//        parent = new int[edges.length+1];
//
//        for (int i = edges.length-1; i>=0; i--){
//            for (int j = 0; j<=edges.length; j++){
//                parent[j] = j;
//            }
//            if (check(edges,i)){
//                return edges[i];
//            }
//        }
//
//        return edges[0];
//    }
//}


