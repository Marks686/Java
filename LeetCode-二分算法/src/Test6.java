/**
 * Created with IntelliJ IDEA.
 * Description:LCR 173. 点名
 * Date: 2023-12-21
 * Time: 20:44
 */
public class Test6 {
    class Solution {
        public int takeAttendance(int[] records) {
            int left = 0,right = records.length - 1;
            while(left < right)
            {
                int mid = left + (right - left)/2;
                if(records[mid] == mid) left = mid + 1;
                else right = mid;
            }
            return records[right] == right ? left + 1:left;
        }
    }
}
