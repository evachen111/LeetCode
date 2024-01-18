package greedy;

//738
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        String temp = Integer.toString(n);
        int[] digits = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            digits[i] = temp.charAt(i) - '0';
        }

        for (int i = digits.length-1; i>0; i--){
            if (digits[i]<0){
                digits[i] =9;
                digits[i-1]--;
            }
            if(digits[i] < digits[i-1]){
                for (int j = i;j<digits.length;j++){
                    digits[j] = 9;
                }
                digits[i-1]--;
            }
        }
        int re=0;
        for (int i = 0; i<digits.length; i++){
            re+=digits[i]*Math.pow(10,digits.length-i-1);
        }
        return re;
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits sol = new MonotoneIncreasingDigits();
        System.out.println(sol.monotoneIncreasingDigits(1254));
    }
}
