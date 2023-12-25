import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:DP34 【模板】前缀和
 * Date: 2023-12-25
 * Time: 23:19
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 1.读入数据
        int n = in.nextInt(),q = in.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1; i <= n;i++) arr[i] = in.nextInt();

        //2.预处理
        long[] dp = new long[n+1]; //防溢出
        for(int i = 1; i <= n; i++) dp[i] = dp[i-1] + arr[i];

        //3.使用前缀和数组
        while(q > 0)
        {
            int l = in.nextInt(),r = in.nextInt();
            System.out.println(dp[r] - dp[l-1]);
            q--;
        }
    }
}
