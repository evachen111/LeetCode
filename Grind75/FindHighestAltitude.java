package Grind75;

//1732
public class FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int now = 0;
        for (int i = 0; i<gain.length; i++){
            now+=gain[i];
            if(now>max){
                max = now;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
