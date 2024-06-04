package Day1;

import java.util.*;


public class Main2 {
    public ArrayList<Integer> intersection (ArrayList<Integer> nums1,ArrayList<Integer> nums2) {
        boolean[] hash = new boolean[1010];
        for(int x : nums1){
            hash[x] =  true;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for(int x : nums2){
            if(hash[x]){
                ret.add(x);
                hash[x] = false;
            }
        }
        return ret;
    }
}