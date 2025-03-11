package Top150;

// 136
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums){
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
