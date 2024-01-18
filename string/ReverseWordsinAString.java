package string;

//151
public class ReverseWordsinAString {
    public static String reverseWords(String s) {
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        int right = s.length() -1;
        int left = s.length() -1;

        while (left>=0 && right >=0){
            while (right >= 0 && c[right] == ' '){
                right--;
            }
            left = right;
            while (left >0 && c[left-1] != ' '){
                left--;
            }
            if (right <0 || left < 0){
                break;
            }
            for (int i = left; i<=right; i++){
                sb.append(c[i]);
            }
            sb.append(' ');
            right = left-1;

        }
        if (sb.charAt(sb.length()-1) == ' '){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String s = new String("  hello world  ");
        System.out.println(s);
        System.out.println(reverseWords(s));
    }
}
