import java.util.PriorityQueue;

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
class Solution {
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