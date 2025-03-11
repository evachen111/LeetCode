package OA;

public class tianyi {

    public double getValue (int a, int b) {
        if (a==0){
            return -1.0;
        }
        return (1-b)/a;

    }

    public static void main(String[] args) {
        tianyi t = new tianyi();
        System.out.println(t.getValue(2,5));
    }
}
