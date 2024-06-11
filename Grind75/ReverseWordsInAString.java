package Grind75;

// 151
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        StringBuffer tmp = new StringBuffer();

        for (char c: s.toCharArray()){
            if (c == ' '){
                if (tmp.length() != 0){
                    sb.insert(0,tmp);
                    sb.insert(0, ' ');
                    tmp.setLength(0);
                }
            }
            else{
                tmp.append(c);
            }
        }
        if(tmp.length() != 0){
            sb.insert(0,tmp);
        }
        else{
            sb.delete(0,1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = " hello world ";

        ReverseWordsInAString sol = new ReverseWordsInAString();
        System.out.println(sol.reverseWords(s));
    }

}
