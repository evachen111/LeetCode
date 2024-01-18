package Graph;

// 684
// for a new edge: check if the 2 vertices are already in a union
public class RedundantConnection {
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
        parent[find(y)] = find(x);
    }
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for (int i = 0; i<=edges.length; i++){
            parent[i] = i;
        }
        int idx = -1;
        for (int i = 0; i<edges.length; i++){
            // check
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

    }
}
