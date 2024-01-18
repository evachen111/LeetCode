package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//127
// beginword and endword could be at any place in the wordlist
public class WordLadder {
    public int BFS(int[][] g, int i, int idx){
        int[] dist = new int[g.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        g[i][i] = 2; // color
        dist[i] = 1; // dist
        while(!q.isEmpty()){
            int v = q.remove();
            for (int j = 0; j<g.length; j++){
                if (g[v][j] == 1 && g[j][j] ==0){
                    g[j][j] = 2;
                    dist[j] = dist[v] +1;
                    q.add(j);
                }
            }
        }
        return dist[idx];
    }

    public boolean differInOne(String a, String b){
        int num = 0;
        for (int i = 0; i<a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                num++;
            }
            if (num>1){
                return false;
            }
        }
        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        int[][] map;
        if (!wordList.contains(beginWord)){
            map = new int[wordList.size()+1][wordList.size()+1];
            wordList.add(0,beginWord);
        }
        else{
            map = new int[wordList.size()][wordList.size()];
        }
        int beIdx = 0;
        int endIdx = 0;
        for (int i =0; i<wordList.size(); i++){
            for (int j = i+1; j<wordList.size(); j++){
                if (differInOne(wordList.get(i), wordList.get(j))){
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
            if (wordList.get(i).equals(endWord)){
                endIdx = i;
            }
            if (wordList.get(i).equals(beginWord)){
                beIdx = i;
            }
        }
        return BFS(map,beIdx, endIdx);
    }

    public static void main(String[] args) {
        List<String> wl = new ArrayList<>();
        wl.add("hot");
        wl.add("dog");

        String b = "hot";
        String e = "dog";
        WordLadder sol = new WordLadder();
        System.out.println(sol.ladderLength(b,e,wl));
    }
}
