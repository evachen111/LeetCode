package string;

// 1071
public class GreatestCommonDivisorofStrings {
    public boolean isDivisor(String str1, String str2){
        if (str2.length() > str1.length()){
            return false;
        }
        if (str1.length() % str2.length() !=0){
            return false;
        }
        for (int i = 0; i<=str1.length()-str2.length(); i += str2.length()){
            for (int j = 0; j<str2.length(); j++){
                if (str1.charAt(i+j) != str2.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length()<str2.length()){
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        for (int i = str2.length(); i>0; i--){
            if (isDivisor(str1, str2.substring( 0,i)) && isDivisor(str2, str2.substring(0,i))){
                return str2.substring(0,i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s1 = "ABABAB";
        String s2 = "ABC";
        GreatestCommonDivisorofStrings sol = new GreatestCommonDivisorofStrings();
        System.out.println(sol.gcdOfStrings(s1,s2));
    }
}
