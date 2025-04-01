package Top150;


public class HSBC04 {
    public int solution(String S) {
        // Implement your solution here
        // sanity check
        if (S.length() == 1 && S.charAt(0) == 'H'){
            return -1;
        }

        StringBuffer sb = new StringBuffer();
        int i = 0;
        int count = 0;
        while (i<S.length()){
            if (i+2<S.length() && S.charAt(i) == 'H'&&
                    S.charAt(i+1) == '_'&& S.charAt(i+2) == 'H'){
                count++;
                i += 3;
            }
            else{
                sb.append(S.charAt(i));
                i++;
            }
        }
        System.out.println(sb);
        for (int j = 0; j<sb.length(); j++){
            if (sb.charAt(j) == 'H'){
                if (j+1<sb.length() && sb.charAt(j+1) == '_'){
                    count++;
                }
                else if (j-1>=0 && sb.charAt(j-1) == '_'){
                    count++;
                }
                else{
                    return -1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        HSBC04 sol = new HSBC04();
        String s = "_H_HH_H_H_";
        System.out.println(sol.solution(s));
    }
}


