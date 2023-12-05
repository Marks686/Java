/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-12-01
 * Time: 18:56
 */
// 704. 二分查找
public class Test1 {
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0,right = nums.length - 1;
            while(left <=  right)
            {
                int mid = left + (right - left)/2; //防止溢出
                if(nums[mid] < target){
                    left = mid + 1;
                }else if(nums[mid] > target){
                    right = mid - 1;
                }
                else{
                    return mid;
                }
            }
            return -1;
        }
    }
}
