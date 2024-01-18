package greedy;

//860
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0]!=5){
            return false;
        }
        int[] num = new int[2];
        for (int i:bills){
            if (i == 5){
                num[0]++;
            }
            else if (i == 10){
                num[1]++;
                num[0]--;
            }
            else{
                if (num[1]>0){
                    num[1]--;
                    num[0]--;
                }
                else{
                    num[0] = num[0]-3;
                }
            }
            if (num[0]<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
