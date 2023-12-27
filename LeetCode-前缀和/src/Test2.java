/**
 * Created with IntelliJ IDEA.
 * Description:DP35 【模板】二维前缀和
 * Date: 2023-12-26
 * Time: 18:03
 */
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 1.读入数据
        int n = in.nextInt(),m = in.nextInt(),q = in.nextInt();
        int[][] arr = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                arr[i][j] = in.nextInt();
            }
        }
        // 2.预处理一个前缀和矩阵
        long[][] dp = new long[n + 1][m + 1];
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i][j] - dp[i-1][j-1];
            }
        }

        // 3.使用前缀和矩阵
        while(q > 0)
        {
            int x1 = in.nextInt(),y1 = in.nextInt(),x2 = in.nextInt(),y2 = in.nextInt();
            System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
            q--;
        }
    }
}