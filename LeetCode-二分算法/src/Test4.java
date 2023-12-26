/**
 * Created with IntelliJ IDEA.
 * Description:162.寻找峰值
 * Date: 2023-12-20
 * Time: 20:40
 */
public class Test4 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0,right = nums.length - 1;
            while(left < right)
            {
                int mid = left + (right - left)/2;
                if(nums[mid] > nums[mid + 1])
                {
                    right = mid;
                }
                else
                {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
