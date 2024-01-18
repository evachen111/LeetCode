package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 841
public class KeysandRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // bfs: all reachable from a source vertex
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int v = 0;
        int[] visited = new int[rooms.size()];
        visited[0] = 1;
        while (!q.isEmpty()){
            v = q.remove();
            for (int i = 0; i<rooms.get(v).size(); i++){
                if (visited[rooms.get(v).get(i)] == 0){
                    visited[rooms.get(v).get(i)] = 1;
                    q.add(rooms.get(v).get(i));
                }
            }
        }
        for (int i = 0; i<rooms.size(); i++){
            if (visited[i] == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
