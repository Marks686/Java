import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:974. 和可被 K 整除的子数组
 * Date: 2023-12-30
 * Time: 19:31
 */
public class Test6 {
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
            hash.put(0 % k,1);

            int sum = 0,ret = 0;
            for(int x : nums)
            {
                sum += x;
                int r = (sum % k + k) % k;
                ret += hash.getOrDefault(r,0);
                hash.put(r,hash.getOrDefault(r,0)+1);
            }
            return ret;
        }
    }
}
