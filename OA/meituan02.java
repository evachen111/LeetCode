package OA;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// find the password
public class meituan02 {
    public Map<Integer, HashSet<String>> hm = new TreeMap<>();

    public int[] findPwd(String[] ss, String psw){
        int[] result = new int[2];
        int len = 0;

        // put into hashmap
        for (String s : ss){
            len = s.length();
            if (hm.containsKey(len)){
                if (!hm.get(len).contains(s)){
                    hm.get(len).add(s);
                }
            }
            else{
                HashSet<String> hs = new HashSet<>();
                hs.add(s);
                hm.put(len,hs);
            }
        }

        // check
        int lenPws = psw.length();
        int max = 0;
        int min = 1;
        for (Map.Entry<Integer, HashSet<String>>  entry: hm.entrySet()){
            max += entry.getValue().size();
            if (lenPws == entry.getKey()){
                result[0] = min;
                result[1] = max;
                return result;
            }
            else{
                min += entry.getValue().size();
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String pwd = in.nextLine();
        String[] ss = new String[n];
        for (int i = 0; i <n; i++){
            ss[i] = in.nextLine();
        }
        meituan02 sol = new meituan02();
        int[] result = sol.findPwd(ss,pwd);
        System.out.println(result[0] + " " + result[1]);
    }
}
