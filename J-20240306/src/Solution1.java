/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-06
 * Time: 17:37
 */
public class Solution1 {
        public int firstUniqChar(String s) {

            int[] count = new int[256];
            for(int i = 0; i < s.length(); i++){
                count[s.charAt(i)]++;
            }
            for(int i=0; i < s.length(); i++){
                if(count[s.charAt(i)] == 1){
                    return i;
                }
            }
            return -1;
        }
}
