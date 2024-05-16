package Grind75;

import java.util.ArrayList;
import java.util.List;

// 1431
public class KidsWithTheGreatestNumberCandies {
    public List<Boolean> result = new ArrayList<>();
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i<candies.length; i++){
            if (max < candies[i]){
                max = candies[i];
            }
        }
        for (int i = 0; i<candies.length; i++){
            if (max <= candies[i] + extraCandies){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
