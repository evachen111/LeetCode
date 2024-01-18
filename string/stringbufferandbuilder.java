package string;

public class stringbufferandbuilder {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity()); //16

        StringBuffer sb1 = new StringBuffer("aaaa");
        System.out.println(sb1.capacity()); // 20: 16 continuous extra space in memory
        System.out.println(sb1.length());  // 4
        sb1.append("bbbb");
        System.out.println(sb1);

        sb1.deleteCharAt(2);

        String str = sb1.toString();
        System.out.println(str);

    }
}
