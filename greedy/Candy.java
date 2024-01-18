package greedy;

import java.util.Arrays;

//135
public class Candy {
    public int candy(int[] ratings) {
        int[] give = new int[ratings.length];
        give[0] = 1;
        for (int i = 1; i<ratings.length; i++){
            if (ratings[i] > ratings[i-1]){
                give[i] = give[i-1]+1;
            }
            else{
                give[i] = 1;
            }
        }

        for (int i = ratings.length-2; i>=0; i--){
            if (ratings[i] > ratings[i+1]){
                give[i] = Math.max(give[i+1]+1,give[i]);
            }
        }
        return Arrays.stream(give).sum();
    }

    public static void main(String[] args) {
        Candy sol = new Candy();
        int[] a = {1,3,2,2,1};
        System.out.println(sol.candy(a));
    }
}
