import java.util.Scanner;

import static sun.util.calendar.CalendarUtils.mod;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-09
 * Time: 12:46
 */
public class NewClass1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 1;
        int min = 10000;
        int p,q,k;
        int m = 0;
        int n = 0;
        int s = 0;
        int t = 0;
        int [] a = new int[]{1,16,10,16,1,9,15,12,6,8,3,9,5,12,8,17};
        int l = a.length;
        for (int i = 0; i < l; i++) {
            p = mod((l + i -1),l);
            q = mod((i + 1),l);
            k = a[p]*a[q];
            if (k > max){
                max = k;
                m = a[p];
                n = a[q];
            }
            if (k < min){
                min = k;
                s = a[p];
                t = a[q];
            }
        }
        System.out.println("最大乘积:"+max+"="+m+"*"+n);
        System.out.println("最小乘积:"+min+"="+s+"*"+t);

    }
}
