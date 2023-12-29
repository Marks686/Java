/**
 * Created with IntelliJ IDEA.
 * Description:560. 和为 K 的子数组
 * Date: 2023-12-29
 * Time: 22:19
 */
public class Test5 {
    public class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for (int start = 0; start < nums.length; ++start) {
                int sum = 0;
                for (int end = start; end >= 0; --end) {
                    sum += nums[end];
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

}
