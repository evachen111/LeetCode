package Grind75;

//1207
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {

        int[] freq = new int[2001];
        for (int i : arr){
            freq[i+1000]++;
        }

        int maxFreq = 0;
        for (int i = 0; i<2001; i++){
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        int[] unique = new int[maxFreq+1];
        for (int i : freq){
            if (i != 0 && unique[i] != 0){
                return false;
            }
            unique[i]++;
        }

        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurrences sol = new UniqueNumberOfOccurrences();
        int[] a = {1,2,2,1,1,3};
        System.out.println(sol.uniqueOccurrences(a));
    }
}
