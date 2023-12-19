/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-12-18
 * Time: 22:34
 */
public class Test2 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0,right = nums.length - 1;
            while(left < right)
            {
                int mid = left + (right - left)/2;
                if(nums[mid] < target)
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid;
                }
            }
            if(nums[left] < target)
            {
                return left + 1;
            }
            return right;
        }
    }
}
