/**
 * Created with IntelliJ IDEA.
 * Description:153. 寻找旋转排序数组中的最小值
 * Date: 2023-12-21
 * Time: 20:20
 */
public class Test5 {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0,right = nums.length - 1;
            int x = nums[right];
            while(left <right)
            {
                int mid = left + (right - left)/2;
                if(nums[mid] > x)
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid;
                }
            }
            return nums[left];
        }
    }
}
