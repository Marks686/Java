import java.util.*;


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList(1);
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution20 {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // write code here
        ListNode newhead = new ListNode(0);
        ListNode prev = newhead;
        int t = 0;
        while(head1 != null || head2 != null || t != 0){
            if( head1 != null){
                t += head1.val;
                head1=head1.next;
            }
            if( head2 != null){
                t += head2.val;
                head2=head2.next;
            }
            prev.next = new ListNode(t % 10);
            prev = prev.next;
            t /= 10;
        }
        return newhead.next;
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
}

class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for(ListNode head : lists){
            if(head != null){
                heap.offer(head);
            }
        }

        ListNode ret = new ListNode(0);
        ListNode prev = ret;
        while(!heap.isEmpty()){
            ListNode t = heap.poll();
            prev.next = t;
            prev = t;
            if(t.next != null){
                heap.offer(t.next);
            }
        }
        return ret.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1.先求出需要逆序多少组
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        n /= k;

        ListNode newhead = new ListNode(0);
        ListNode prev = newhead;
        cur = head;
        // 2.重复n次 ：长度为k的链表的逆序
        for(int i =0; i < n; i++){
            ListNode tmp = cur;
            // 头插数据
            for(int j = 0; j < k; j++){
                ListNode next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
                cur = next;
            }
            prev = tmp;
        }
        // 把后面不需要逆序的连接上
        prev.next= cur;
        return newhead.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution3 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = new ListNode(0);
        newhead.next = head;

        ListNode prev = newhead,cur = prev.next,next = cur.next,nnext = next.next;

        while(cur != null && next != null){
            prev.next = next;
            next.next = cur;
            cur.next = nnext;


            prev = cur;
            cur = nnext;
            if(nnext != null)next = nnext.next;
            if(next != null)nnext = next.next;
        }
        return newhead.next;
    }
}

class Solution4 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode tmp = swapPairs(head.next.next);
        ListNode cur = head.next;
        cur.next = head;
        head.next = tmp;

        return cur;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution5 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode head2 = new ListNode(0);
        while(cur != null){
            ListNode next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = next;
        }

        ListNode h1 = head;
        ListNode h2 = head2.next;
        ListNode newhead = new ListNode(0);
        ListNode prev = newhead;
        while(h1 != null){
            prev.next = h1;
            prev = h1;
            h1 = h1.next;
            if(h2 != null){
                prev.next = h2;
                prev = h2;
                h2 = h2.next;
            }
        }
    }
}

class Solution6 {
    public void duplicateZeros(int[] arr) {
        int dest = -1;
        int cur = 0;
        int n = arr.length;
        while(cur < n){
            if(arr[cur] == 0){
                dest+=2;
            }else{
                dest+=1;
            }
            if(dest >= n-1){
                break;
            }else{
                cur++;
            }
        }

        // 2.处理边界情况
        if(dest == n){
            arr[n-1] =0;
            cur--;
            dest -= 2;
        }
        // 3.从后向前复写
        while(cur >= 0){
            if(arr[cur] != 0){
                arr[dest] = arr[cur];
                cur--;
                dest--;
            }else{
                arr[dest] = 0;
                dest--;
                arr[dest] = 0;
                dest--;
                cur--;
            }
        }
    }
}

class Solution7 {
    public void swap(int dest,int cur,int nums[]){
        int tmp = nums[dest];
        nums[dest] = nums[cur];
        nums[cur] = tmp;
    }
    public void moveZeroes(int[] nums) {
        int dest = -1;
        for(int cur = 0; cur < nums.length; cur++){
            if(nums[cur] != 0){
                dest++;
                swap(dest,cur,nums);
            }
        }
    }
}

class Solution8 {
    public int bitSum(int n){
        int sum = 0;
        while(n != 0){
            int t = n % 10;
            sum += t * t;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = bitSum(n);
        while(slow != fast){
            slow = bitSum(slow);
            fast = bitSum(bitSum(fast));
        }
        return slow == 1;
    }
}
class Solution9 {
    public int maxArea(int[] height) {
        int ret = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right){
            int v = Math.min(height[left],height[right]) * (right-left);
            ret = Math.max(v,ret);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return ret;
    }
}

class Solution10 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ret = 0;

        for(int i = n-1; i >= 2; i--){
            int left = 0;
            int right = i-1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    ret += right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ret;
    }
}


class Solution11 {
    public int[] twoSum(int[] price, int target) {
        int left = 0;
        int right = price.length - 1;
        while(left < right){
            if(price[left] + price[right] == target){
                return new int[] {price[left],price[right]};
            }else if(price[left] + price[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{0};
    }
}

class Solution12 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();


        Arrays.sort(nums);

        int n = nums.length;
        for(int i =0; i < n;){
            if(nums[i] > 0) break;
            int left = i+1;
            int right = n-1;
            int target = -nums[i];
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }else{
                    ret.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
            i++;
            while(i<n && nums[i] == nums[i-1]){
                i++;
            }
        }
        return ret;
    }
}

class Solution13 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<>();


        for(int i =0; i< nums.length;i++){
            int x = target - nums[i];
            if(hash.containsKey(x)){
                return new int[]{i,hash.get(x)};
            }
            hash.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}

class Solution14 {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        int[] hash = new int[26];

        for(int i = 0; i < s1.length(); i++){

            hash[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s2.length();i++){
            hash[s2.charAt(i) - 'a']--;
            if(hash[s2.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;

    }
}


class Solution15 {
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

class Solution16 {
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


class Solution17 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hash = new HashMap<>();
        for(String s : strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);

            if(!hash.containsKey(key)){
                hash.put(key,new ArrayList());
            }
            hash.get(key).add(s);
        }
        return new ArrayList(hash.values());
    }
}

class Solution18 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int n = nums.length;
        for(int left = 0,right = 0; right < n; right++){
            sum += nums[right];

            while(sum >= target){
                len = Math.min(len,right-left+1);
                sum -= nums[left++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}


class Solution19 {
    public int lengthOfLongestSubstring(String ss) {
        char[] s = ss.toCharArray();
        int ret = 0;
        int left = 0;
        int right = 0;
        int n = ss.length();
        int[] hash = new int[128];
        while(right < n){
            hash[s[right]]++;
            while(hash[s[right]] > 1){
                hash[s[left++]]--;
            }
            ret = Math.max(ret,right-left+1);
            right++;
        }
        return ret;
    }
}

class Solution21 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zero = 0;
        int ret = 0;
        int n = nums.length;
        for(int right = 0; right < n; right++){
            if(nums[right] == 0){
                zero++;
            }
            while(zero > k){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }
            ret = Math.max(ret,right - left + 1);
        }
        return ret;
    }
}
class Solution22 {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int a : nums){
            sum += a;
        }
        int target = sum - x;
        if(target < 0 ){
            return -1;
        }

        int left = 0;
        int tmp = 0;
        int ret = -1;
        for(int right = 0; right < nums.length; right++){
            tmp += nums[right];
            while(tmp > target){
                tmp -= nums[left++];
            }
            if(tmp == target){
                ret = Math.max(ret,right-left+1);
            }
        }
        if(ret == -1){
            return ret;
        }
        return nums.length - ret;
    }
}

class Solution23 {
    public int totalFruit(int[] f) {
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        int left = 0;
        int ret = 0;
        for(int right = 0; right < f.length; right++){
            int in = f[right];
            hash.put(in,hash.getOrDefault(in,0) + 1);
            while(hash.size() > 2){
                int out = f[left];
                hash.put(out,hash.get(out)-1);
                if(hash.get(out) == 0){
                    hash.remove(out);
                }
                left++;
            }
            ret = Math.max(ret,right - left + 1);
        }
        return ret;
    }
}
class Solution24 {
    public int search(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

class Solution25 {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = ret[1] = -1;
        int left = 0;
        int right = nums.length -1;
        if(nums.length == 0){
            return ret;
        }
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        if(nums[left] != target){
            return ret;
        }
        else{
            ret[0] = left;
        }

        left = 0; right = nums.length -1;
        while(left < right){
            int mid = left + (right - left + 1)/2;
            if(nums[mid] <= target) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        ret[1] = right;

        return ret;
    }
}

class Solution26 {
    public int mySqrt(int x) {
        if(x < 1){
            return 0;
        }
        long left = 0;
        long right = x;
        while(left < right){
            long mid = left + (right - left + 1)/2;
            if(mid * mid <= x){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return (int)right;
    }
}

class Solution27 {
    public int searchInsert(int[] nums, int target) {
        int left = 0; int right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(nums[left] < target) {
            return left+1;
        }
        return left;
    }
}

class Solution28 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while(left < right){
            int mid = left + (right - left+1)/2;
            if(arr[mid] > arr[mid-1]){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return right;
    }
}

class Solution29 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left +(right - left)/2;
            if(nums[mid] < nums[mid+1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

class Solution30 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int x = nums[right];
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[right];
    }
}
class Solution31 {
    public int takeAttendance(int[] records) {
        int left = 0;
        int right = records.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(records[mid] == mid){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left == records[left] ? left+1 : left;
    }
}

class Solution32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = in.nextInt();
        }

        long[] dp = new long[n+1];
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i-1] + arr[i];
        }
        while(q > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(dp[r]-dp[l-1]);
            q--;
        }
    }
}


// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Solution33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[][] arr = new int[n+1][m+1];

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                arr[i][j] = in.nextInt();

        long[][] dp = new long[n+1][m+1];
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i][j] - dp[i-1][j-1];



        while(q > 0){
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
            q--;
        }
    }
}

class Solution34 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];

        // 1.预处理一下前缀和数组以及后缀和数组
        for(int i = 1; i < n; i++)
        {
            f[i] = f[i-1] + nums[i-1];
        }
        for(int i = n - 2; i >= 0; i--)
        {
            g[i] = g[i+1] + nums[i+1];
        }
        // 2.使用
        for(int i = 0; i < n; i++)
        {
            if(f[i] == g[i])
            {
                return i;
            }
        }
        return -1;
    }
}