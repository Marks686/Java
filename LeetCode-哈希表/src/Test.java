import java.util.*;

public class Test {

//1. 两数之和
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] + nums[j] == target) {
                        ret[0] = i;
                        ret[1] = j;
                        return ret;
                    }
                }
            }
            return ret;
        }
    }

//    class Solution1 {
//        public int[] twoSum(int[] nums, int target) {
//            Map<Integer,Integer> hash = new HashMap<>();
//            for(int i = 0; i < nums.length;i++){
//                int x = target - nums[i];
//                if(hash.containsKey(x)){
//                    return new int[]{i,hash.get(x)};
//                }
//                hash.put(nums[i],i);
//            }
//            return new int[]{-1,-1};
//        }
//    }


//    面试题 01.02. 判定是否互为字符重排
    class Solution2 {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int[] hash = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                hash[s1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s2.length(); i++) {
                hash[s2.charAt(i) - 'a']--;
                if (hash[s2.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//    217. 存在重复元素
    class Solution3 {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> hash = new HashSet<>();
            for(int s : nums){
                if(hash.contains(s)){
                    return true;
                }
                hash.add(s);
            }
            return false;
        }
    }

//    219. 存在重复元素 II
    class Solution4 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer,Integer> hash = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(hash.containsKey(nums[i])){
                    if(i - hash.get(nums[i]) <= k){
                        return true;
                    }
                }
                hash.put(nums[i],i);
            }
            return false;
        }
    }
//    49. 字母异位词分组
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> hash = new HashMap<>();
            // 1.把所有的字符异位词分组
            for(String s : strs){
                char[] tmp = s.toCharArray();
                Arrays.sort(tmp);
                String key = new String(tmp);
                if(!hash.containsKey(key)){
                    hash.put(key,new ArrayList());
                }
                hash.get(key).add(s);
            }
            //2. 提取结果
            return new ArrayList(hash.values());
        }
    }
}
