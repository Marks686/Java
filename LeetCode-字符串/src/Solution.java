class Solution {
    public String longestCommonPrefix(String[] strs) {
        //解法一：两两比较
        String ret = strs[0];
        for(int i = 1; i < strs.length; i++){
            ret = findCommon(strs[i],ret);
        }
        return ret;
    }

    public String findCommon(String s1,String s2){
        int i = 0;
        while(i < Math.min(s1.length(),s2.length()) && s1.charAt(i) == s2.charAt(i))
            i++;
        return s1.substring(0,i);
    }
}