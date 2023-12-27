/**
 * Created with IntelliJ IDEA.
 * Description:724. 寻找数组的中心下标
 * Date: 2023-12-27
 * Time: 16:49
 */
public class Test3 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            int[] g = new int[n];

            // 1.预处理一下前缀和数组以及后缀和数组
            for(int i = 1; i < n; i++)
            {
                f[i] = f[i-1] + nums[i-1];
            }
            for(int i = n - 2; i >= 0; i--)
            {
                g[i] = g[i+1] + nums[i+1];
            }
            // 2.使用
            for(int i = 0; i < n; i++)
            {
                if(f[i] == g[i])
                {
                    return i;
                }
            }
            return -1;
        }
    }
}
