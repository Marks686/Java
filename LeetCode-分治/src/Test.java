import javax.swing.tree.TreeNode;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-11
 * Time: 17:12
 */
public class Test {
//    75. 颜色分类
    class Solution1 {
        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        public void sortColors(int[] nums) {
            int left = -1, right = nums.length, i = 0;
            while(i < right){
                if(nums[i] == 0){
                    swap(nums,++left,i++);
                }else if(nums[i] == 1){
                    i++;
                }else{
                    swap(nums,--right,i);
                }
            }
        }
    }
//912. 排序数组
    class Solution2 {
        public int[] sortArray(int[] nums) {
            qsort(nums,0,nums.length-1);
            return nums;
        }
        public void qsort(int[] nums,int l,int r){
            if(l >= r) return;

            int key = nums[new Random().nextInt(r - l + 1) + l];
            int left = l-1,right = r + 1, i = l;
            while(i < right){
                if(nums[i] < key){
                    swap(nums,++left,i++);
                }else if(nums[i] == key){
                    i++;
                }else{
                    swap(nums,--right,i);
                }
            }
            qsort(nums,l,left);
            qsort(nums,right,r);
        }

        public void swap(int[] nums,int i,int j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//215. 数组中的第K个最大元素
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return qsort(nums,0,nums.length - 1,k);
        }
        public int qsort(int[] nums, int l, int r, int k){
            if(l == r) return nums[l];

            int key = nums[new Random().nextInt(r - l + 1) + l];

            int left = l - 1,right = r + 1, i = l;
            while(i < right){
                if(nums[i] < key) swap(nums,++left,i++);
                else if(nums[i] == key) i++;
                else swap(nums,--right,i);
            }
            int b = right - left - 1;
            int c = r - right + 1;
            if(c >= k) return qsort(nums,right,r,k);
            else if(b + c >= k) return key;
            else return qsort(nums,l,left,k - b - c);
        }
        public void swap(int[] nums,int left,int right){
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
        }
    }

}
