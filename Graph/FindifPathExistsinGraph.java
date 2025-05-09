package Graph;

// 1971
public class FindifPathExistsinGraph {
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

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        for (int i = 0; i<n; i++){
            parent[i] = i;
        }
        for (int i =0 ; i<edges.length; i++){
            union(edges[i][0], edges[i][1]);
        }
        if (find(source) == find(destination)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
    }
}
