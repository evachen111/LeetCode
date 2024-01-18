package monoStack;

import java.util.Stack;

// 739
public class dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack();
        s.push(temperatures.length-1);

        int[] answer = new int[temperatures.length];
        answer[temperatures.length-1] = 0;
//        for (int i = temperatures.length-2; i>=0; i--){
//            if (temperatures[i] < temperatures[s.peek()]){ //could be in general case
//                answer[i] = 1;
//            }else if (answer[i+1] == 0){answer[i] = 0;} // could be in genral case
//            else{
//                while(!s.isEmpty() && temperatures[i]>=temperatures[s.peek()]){
//                    s.pop();
//                }
//                if (s.isEmpty()){
//                    answer[i] = 0;   //default, just skip
//                }
//                else{
//                    answer[i] = s.peek()-i;
//                }
//            }
//            s.push(i);
//        }
        for (int i = temperatures.length-2; i>=0; i--){

            while(!s.isEmpty() && temperatures[i]>=temperatures[s.peek()]){
                s.pop();
            }
            if (!s.isEmpty()){
                answer[i] = s.peek()-i;
            }

            s.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {89,62,70,58,47,47,46,76,100,70};
        dailyTemperatures sol = new dailyTemperatures();
        sol.dailyTemperatures(a);
    }
}
