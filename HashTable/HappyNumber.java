package HashTable;

import java.util.HashSet;

public class HappyNumber {

    public static int sum(int n){
        int result = 0;
        while(n>0){
            result = result + (int) Math.pow(n%10,2);
            n = n/10;
        }
        return result;
    }

    public static boolean isHappy(int n) {
        // sanity check
        if (n==1){
            return true;
        }
        HashSet<Integer> ht = new HashSet<>();
        while (!ht.contains(n)){
            ht.add(n);
            if(sum(n) == 1){
                return true;
            }
            n = sum(n);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
