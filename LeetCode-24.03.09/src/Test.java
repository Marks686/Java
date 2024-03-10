/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-09
 * Time: 14:32
 */
public class Test {

//面试题 01.01. 判定字符是否唯一
    class Solution1 {
        public boolean isUnique(String astr) {
            int ans = 0;
            if(astr.length() > 26){
                return false;
            }
            for(int i = 0; i < astr.length(); i++){
                int x = astr.charAt(i) - 'a';
                if(((ans >> x) & 1) == 1){
                    return false;
                }
                ans |= 1 << x;
            }
            return true;
        }
    }
//268. 丢失的数字
    class Solution2 {
        public int missingNumber(int[] nums) {
            int ret = 0;
            for(int x : nums) {
                ret ^= x;
            }
            for(int i = 0; i < nums.length + 1; i++){
                ret ^= i;
            }
            return ret;
        }
    }

//371. 两整数之和
    class Solution3 {
        public int getSum(int a, int b) {
            while(b != 0)
            {
                int x = a ^ b;
                int carry = (a & b) << 1;
                a = x;
                b = carry;
            }
            return a;
        }
    }


//137. 只出现一次的数字 II
    class Solution4 {
        public int singleNumber(int[] nums) {
            int ret = 0;
            for(int i = 0; i < 32; i++){
                int sum = 0;
                for(int x : nums){
                    if(((x >> i) & 1) == 1){
                        sum++;
                    }
                }
                sum %= 3;
                if(sum == 1){
                    ret |= 1 << i;
                }
            }
            return ret;
        }
    }

//面试题 17.19. 消失的两个数字
    class Solution5 {
        public int[] missingTwo(int[] nums) {
            int tmp = 0;
            for(int x : nums) tmp ^= x;
            for(int i = 1; i <= nums.length + 2; i++) tmp ^= i;

            int diff = 0;
            while(true){
                if(((tmp >> diff) & 1) == 1) break;
                else diff++;
            }

            int[] ret = new int[2];
            for(int x : nums){
                if(((x >> diff) & 1) == 1) ret[1] ^= x;
                else ret[0] ^= x;
            }
            for(int i = 1; i <= nums.length + 2; i++){
                if(((i >> diff) & 1) == 1) ret[1] ^= i;
                else ret[0] ^= i;
            }
            return ret;
        }
    }
}
