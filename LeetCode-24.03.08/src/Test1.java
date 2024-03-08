/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-08
 * Time: 20:33
 */
public class Test1 {

//191. 位1的个数
    public class Solution1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while(n != 0){
                res += n & 1;
                n >>>= 1;
            }
            return res;
        }
    }
//461. 汉明距离
    class Solution2 {
        public int hammingDistance(int x, int y) {
            int ret = x ^ y;
            int ans = 0;
            while(ret != 0){
                ret &= (ret-1);
                ans++;
            }
            return ans;
        }
    }
//136. 只出现一次的数字
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = nums[0];
            if(nums.length > 1){
                for(int i = 1; i < nums.length; i++){
                    ans = ans ^ nums[i];
                }
            }
            return ans;
        }
    }
}
