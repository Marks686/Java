/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-12-14
 * Time: 20:29
 */
public class Test1 {
//    34. 在排序数组中查找元素的第一个和最后一个位置
    class Solution {
        public int[] searchRange(int[] nums, int target)
        {
            int[] ret = new int[2];
            ret[0] = ret[1] = -1;
            //处理边界情况
            if(nums.length == 0) return ret;

            // 1.二分左端点
            int left = 0, right = nums.length - 1;
            while(left < right)
            {
                int mid = left + (right-left)/2;
                if(nums[mid] < target) left = mid + 1;
                else right = mid;
            }
            //判断是否有结果
            if(nums[left] != target) return ret;
            else ret[0] = right;
            // 2.二分右端点
            left = 0; right = nums.length - 1;
            while(left < right)
            {
                int mid = left + (right-left+1)/2;
                if(nums[mid] <= target) left = mid;
                else right = mid - 1;
            }
            ret[1] = left;
            return ret;
        }
    }
}
