package OA;

import java.util.Scanner;

// 包裹分类
public class meituan01 {
    private String[] types = {"standard", "special", "mix", "invalid"};
    //检查每个字符
    public boolean isLetter(char c){
        if ((c>= 65 && c <=90) || (c>= 97 && c <=122)){
            return true;
        }
        return false;
    }

    public boolean isInt(char c){
        if (c>= 48 && c <=57){
            return true;
        }
        return false;
    }

    public String check(String s){
        // sanity check
        if (s == null || s.length() == 0 || s.length() == 1) {
            return types[3]; // 返回 "invalid"
        }

        int thisType = 3;
        if(isLetter(s.charAt(0))){
            for (int i = 1; i<s.length();i++){
                if (isInt(s.charAt(i))){
                    if(thisType ==0 || i==1){
                        thisType = 0;
                    }
                    if (thisType == 3){
                        thisType = 2;
                    }
                }
                else if (isLetter(s.charAt(i))){
                    if (thisType == 0){
                        thisType = 2;
                    }
                }
                else {
                    thisType = 3;
                    return types[thisType];
                }
            }
        }

        else if (isInt(s.charAt(0))){
            for (int i = 1; i<s.length();i++){
                if (!isLetter(s.charAt(i))){
                    thisType = 3;
                    return types[thisType];
                }
            }
            thisType = 1;
        }
        //else
        return types[thisType];
    }
    public static void main(String[] args) {
        meituan01 sol = new meituan01();

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine()); // 使用 nextLine() 来读取整数以避免换行符的问题

        String[] ss = new String[n];
        // 读取接下来的 n 行输入并分类
        for (int i = 0; i < n; i++) {
            ss[i] = in.nextLine();
        }
        in.close(); // 关闭 Scanner
        for (int i = 0; i < n; i++) {
            System.out.println(sol.check(ss[i])); // 输出分类结果
        }

    }
}
