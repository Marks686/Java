/**
 * Created with IntelliJ IDEA.
 * Description:69. x 的平方根
 * Date: 2023-12-18
 * Time: 20:29
 */
public class Test1 {
    class Solution {
        public int mySqrt(int x) {
            if(x <1) return 0;
            long left = 1,right = x;
            while(left < right)
            {
                long mid = left + (right - left + 1)/2;
                if(mid * mid <= x)
                {
                    left = mid;
                }
                else
                {
                    right = mid - 1;
                }
            }
            return (int)left;
        }
    }
}
