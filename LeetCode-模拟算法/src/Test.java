import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-10
 * Time: 15:01
 */
public class Test {
//1576. 替换所有的问号
    class Solution1 {
        public String modifyString(String ss) {
            char[] s = ss.toCharArray();
            int n = s.length;
            for(int i = 0; i < n; i++){
                if('?' == s[i]){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if((i == 0 || ch != s[i - 1]) && (i == n-1 || ch != s[i + 1])){
                            s[i] = ch;
                            break;
                        }
                    }
                }
            }
            return String.valueOf(s);
        }
    }


//495. 提莫攻击
    class Solution2 {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            int ret = 0;
            for(int i = 1; i < timeSeries.length; i++){
                int x = timeSeries[i] - timeSeries[i-1];
                if(x >= duration){
                    ret += duration;
                }else{
                    ret += x;
                }
            }
            return ret + duration;
        }
    }
//6. Z 字形变换
    class Solution3 {
        public String convert(String s, int numRows) {
            // 边界
            if (numRows == 1) {
                return s;
            }
            int d = 2 * numRows - 2, n = s.length();
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < n; i += d) {
                ret.append(s.charAt(i));
            }
            for (int k = 1; k < numRows - 1; k++) {
                for (int i = k, j = d - i; i < n || j < n; i += d, j += d) {
                    if (i < n) ret.append(s.charAt(i));
                    if (j < n) ret.append(s.charAt(j));
                }
            }
            for (int i = numRows - 1; i < n; i += d) {
                ret.append(s.charAt(i));
            }
            return ret.toString();
        }
    }


// 38. 外观数列
    class Solution4 {
        public String countAndSay(int n) {
            String ret = "1";
            for(int i = 1; i < n; i++){
                StringBuilder tmp = new StringBuilder();
                int len = ret.length();
                for(int left = 0,right = 0; right < len; ){
                    while(right < len && ret.charAt(left) == ret.charAt(right)){
                        right++;
                    }
                    tmp.append(Integer.toString(right - left));
                    tmp.append(ret.charAt(left));
                    left = right;
                }
                ret = tmp.toString();
            }
            return ret;
        }
    }
//1419. 数青蛙
    class Solution5{
        public int minNumberOfFrogs(String c) {
            char[] croakOfFrogs = c.toCharArray();
            String t = "croak";
            int n = t.length();
            int[] hash = new int[n];

            Map<Character,Integer> index = new HashMap<>();
            for(int i = 0; i < n; i++){
                index.put(t.charAt(i),i);
            }

            for(char ch : croakOfFrogs){
                if(ch == t.charAt(0)){
                    if(hash[n - 1] != 0) {
                        hash[n - 1]--;
                    }
                    hash[0]++;
                }else{
                    int i = index.get(ch);
                    if(hash[i - 1] == 0){
                        return -1;
                    }
                    hash[i - 1]--;
                    hash[i]++;
                }
            }

            for(int i = 0; i < n - 1; i++){
                if(hash[i] != 0){
                    return -1;
                }
            }
            return hash[n - 1];
        }
    }
}
