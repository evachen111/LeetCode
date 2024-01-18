package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//406
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // sort people based on the 1st element
        Arrays.sort(people, (a,b)->{
            if (a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });

//        for (int[] j: people){
//            System.out.print(j[0]);
//            System.out.println(j[1]);
//        }

        // reconstruct based on the 2nd element
        List<int[]> re = new ArrayList<>();
        for (int j = people.length-1; j>=0; j--){
//        for (int j = 0; j<people.length; j++){     //wrong
            re.add(people[j][1],people[j]);
        }
        return re.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight sol = new QueueReconstructionByHeight();
        int[][] people = {{7,0}, {4,4},{7,1},{5,0},{6,1},{5,2}};
        for (int[] j: sol.reconstructQueue(people)){
            System.out.print(j[0]);
            System.out.println(j[1]);
        }

        // must insert in the order of the index
//        List<Integer> re = new ArrayList<>();
//        re.add(0,0);
//        re.add(4,4);
//        re.add(2,2);
//        re.add(3,3);
//        re.add(1,1);
//
//        System.out.println(re);

    }
}
