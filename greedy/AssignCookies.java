package greedy;

import java.util.Arrays;

//455
public class AssignCookies {

    public int helper(int[] g, int[] s, int i, int j) {
        if (i == g.length || j == s.length){
            return 0;
        }
        else if (g[i]<=s[j]){
            return 1 + helper(g,s,i+1,j+1);
        }
        else{
            return helper(g,s,i,j+1);
        }
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        return helper(g,s,0,0);
    }

    public static void main(String[] args) {

    }
}
