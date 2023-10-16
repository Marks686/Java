/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-16
 * Time: 13:22
 */
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        System.out.print("请输入楼梯的数量：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        stair(n);
        System.out.print("有"+stair(n)+"种走法");
    }

    private static int stair(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return stair(n-1)+stair(n-2);
    }
}