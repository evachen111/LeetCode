package greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//56
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if (a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i<intervals.length; i++){
            if (intervals[i][0]<=result.get(result.size()-1)[1]){
                int[] a = new int[2];
                a[0] = result.get(result.size()-1)[0];
                a[1] = Math.max(intervals[i][1], result.get(result.size()-1)[1]);
                result.remove(result.size()-1);
                result.add(a);
            }
            else{
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals sol =new MergeIntervals();
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};

        int[][] re = sol.merge(a);
        for (int[] j: re){
            System.out.print(j[0]);
            System.out.println(j[1]);
        }
    }
}
