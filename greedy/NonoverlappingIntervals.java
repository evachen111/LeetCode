package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

//435
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int num = 0;
        int right = intervals[0][1];
        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0]<right){
                num++;
                right = Math.min(intervals[i][1],right);
            }
            else{
                right = intervals[i][1];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        NonoverlappingIntervals sol = new NonoverlappingIntervals();
        int[][] a = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};

        //{1,2},{2,3},{3,4},{-100,-2},{5,7}
        System.out.println(sol.eraseOverlapIntervals(a));

    }
}
