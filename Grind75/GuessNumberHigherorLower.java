package Grind75;

// 374
public class GuessNumberHigherorLower {
    public int guess(int num){
        return 0;
    }
    public int guessNumber(int n) {
        long left = 1;
        long right = n;
        n = (int)((left+right)/2);
        while (guess(n)!=0){
            System.out.println(guess(n));
            if (guess(n) == 1){
                left = n+1;
            }
            else{
                right = n-1;
            }
            n = (int)((right+left)/2);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println((long)(2126753390 + 2126753390)/2);
    }
}
