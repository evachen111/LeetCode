package Top150;


// 461
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        x ^=y;
        int res = 0;
        while (x != 0) {
            x &= x-1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 1;
        x ^= 4;
        System.out.println(x);
    }
}
