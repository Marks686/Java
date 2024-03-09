/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-09
 * Time: 14:32
 */
public class Test {

//面试题 01.01. 判定字符是否唯一
    class Solution {
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
}
