/**
 * Created with IntelliJ IDEA.
 * Description:238. 除自身以外数组的乘积
 * Date: 2023-12-28
 * Time: 17:16
 */
public class Test4 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            int[] g = new int[n];

            f[0]= g[n - 1] = 1;
            for(int i = 1; i < n; i++)
            {
                f[i]= f[i - 1] * nums[i - 1];
            }
            for(int i = n - 2; i >= 0; i--)
            {
                g[i] = g[i + 1] * nums[i + 1];
            }

            int[] ret = new int[n];
            for(int i = 0; i < n; i++)
            {
                ret[i] = f[i] * g[i];
            }
            return ret;
        }
    }
}
