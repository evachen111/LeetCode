package string;

// 1768
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int j = 0;
        while (i<word1.length() && j<word2.length()){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        if (i>=word1.length()){
            sb.append(word2.substring(j,word2.length()));
        }
        else{
            sb.append(word1.substring(i,word1.length()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
