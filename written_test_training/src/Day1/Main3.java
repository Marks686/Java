package Day1;

import java.util.Scanner;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            char ch = s[i];
            if (st.length() != 0 && ch == st.charAt(st.length() - 1)) {
                // 出栈
                st.deleteCharAt(st.length() - 1);
            } else {
                // 进栈
                st.append(ch);
            }
        }
        System.out.println(st.length() == 0 ? 0 : st.toString());
    }
}