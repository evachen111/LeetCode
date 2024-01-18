package string;

public class replaceSpace {
    public static String replaceSpace(String s) {
        // copy approach
//        StringBuffer sb = new StringBuffer();
//        for (int i =0; i<s.length(); i++){
//            if (s.charAt(i) == ' '){
//                sb.append("%20");
//            }
//            else{
//                sb.append(s.charAt(i));
//            }
//        }
//        return sb.toString();

        // 2 pointers approach
        // expand the length of string with extra space for %20
        StringBuffer expand = new StringBuffer();
        for (int i = 0; i<s.length(); i++){
            if (s.charAt(i) == ' '){
                expand.append("  ");     // add 2 more space
            }
        }
        // check if there is any space
        if (expand.length() == 0){
            return s;
        }

        int left = s.length() -1;
        s += expand.toString();
        int right = s.length() -1;
        char[] c = s.toCharArray();
        while (left >=0){
            if (c[left] == ' '){
                c[right--] = '0';
                c[right--] = '2';
                c[right] = '%';
            }
            else{
                c[right] = c[left];
            }
            right--;
            left--;
        }

        return new String(c);
    }

    public static void main(String[] args) {
        String s = new String("We are happy.");
        System.out.println(s);
        System.out.println(replaceSpace(s));
    }
}
