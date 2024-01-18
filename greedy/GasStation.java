package greedy;

import java.util.Arrays;

//134
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int gasSum = Arrays.stream(gas).sum();
//        int costSum = Arrays.stream(cost).sum();
//        if (gasSum<costSum){
//            return -1;
//        }

        int sum = 0;
        int minSum = 0;
        int mark = 0;
        for (int i = 0; i<gas.length; i++){
            sum = sum + gas[i] - cost[i];
            if (sum<minSum){
                minSum = sum;
                mark = (i+1)%gas.length;
            }
        }
        if (sum<0){
            return -1;
        }
        return mark;
    }

    public static void main(String[] args) {

    }
}
