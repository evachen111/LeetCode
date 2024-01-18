package greedy;

import java.util.Arrays;

//452
public class MinNumOfArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));

        int i = 0;
        int numA = 0;
        while (i<points.length){
            int left = points[i][0];
            int right = points[i][1];
            numA++;
            for (int j = i+1; j<points.length; j++){
                if ((left <= points[j][0] &&  points[j][0]<= right)){
                    left = points[j][0];
                    right = Math.min(points[j][1],right);
                    i++;
                }
                else {
                    break;
                }
            }
            i++;
        }
        return numA;
    }

    public static void main(String[] args) {
        int[][] a = {{10,16}, {2,8},{1,6},{7,12}};

        //{-2147483646,-2147483645},{2147483646,2147483647}
        //{10,16}, {2,8},{1,6},{7,12}
        //{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}
        //{-1,1},{0,1},{2,3},{1,2}

        MinNumOfArrowsBurstBalloons sol = new MinNumOfArrowsBurstBalloons();
        System.out.println(sol.findMinArrowShots(a));
    }
}
