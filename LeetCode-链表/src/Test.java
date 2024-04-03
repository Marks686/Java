import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-16
 * Time: 20:12
 */
public class Test {
////21. 合并两个有序链表
//    class Solution1 {
//        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//            if(list1 == null){
//                return list2;
//            } else if(list2 == null){
//                return list1;
//            } else if(!(list1.Val() >= list2.Val())){
//                list1.next = mergeTwoLists(list1.next,list2);
//                return list1;
//            }else{
//                list2.next = mergeTwoLists(list1,list2.next);
//                return list2;
//            }
//        }
//    }
//    2. 两数相加
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode cur1 = l1,cur2 = l2;
//        ListNode newHead = new ListNode(0);
//        ListNode prev = newHead;
//        int t = 0;
//        while(cur1 != null || cur2 != null || t != 0){
//            if(cur1 != null){
//                t += cur1.isVal();
//                cur1 = cur1.next;
//            }
//            if(cur2 != null){
//                t += cur2.val;
//                cur2 = cur2.next;
//            }
//            prev.next = new ListNode(t%10);
//            prev = prev.next;
//            t /= 10;
//        }
//        return newHead.next;
//    }
//}
    //24. 两两交换链表中的节点
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode newHead = new ListNode(0);
            newHead.next = head;

            ListNode prev = newHead,cur = prev.next,next = cur.next,nnext = next.next;
            while(cur != null && next != null){
                //交换节点
                prev.next = next;
                next.next = cur;
                cur.next = nnext;

                //修改指针
                prev = cur;
                cur = nnext;
                if(cur != null) next = cur.next;
                if(next != null) nnext = next.next;
            }
            return newHead.next;
        }
    }
    class Solution3
    {
        public int minNumberOfFrogs(String c)
        {
            char[] croakOfFrogs = c.toCharArray();
            String t = "croak";
            int n = t.length();
            int[] hash = new int[n]; // 数组模拟哈希表
            Map<Character, Integer> index = new HashMap<>(); // [x, x这个字符对应的下标
            for(int i = 0; i < n; i++)
                index.put(t.charAt(i), i);
            for(char ch : croakOfFrogs)
            {
                if(ch == t.charAt(0))
                {
                    if(hash[n - 1] != 0) hash[n - 1]--;
                    hash[0]++;
                }
                else
                {
                    int i = index.get(ch);
                    if(hash[i - 1] == 0) return -1;
                    hash[i - 1]--; hash[i]++;
                }
            }
            for(int i = 0; i < n - 1; i++)
                if(hash[i] != 0)
                    return -1;

            return hash[n - 1];
        }
    }
//    143. 重排链表
    class Solution4 {
        public void reorderList(ListNode head) {


            if(head == null || head.next == null || head.next.next == null){
                return;
            }
            //
            ListNode slow = head, fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            //slow后面进行逆序
            ListNode head2 = new ListNode(0);
            ListNode cur = slow.next;
            slow.next = null;
            while(cur != null){
                ListNode next = cur.next;
                cur.next = head2.next;
                head2.next = cur;
                cur = next;
            }

            //合并链表
            ListNode cur1 = head,cur2 = head2.next;
            ListNode ret = new ListNode(0);
            ListNode prev = ret;
            while(cur1 != null){
                prev.next = cur1;
                prev = cur1;
                cur1 = cur1.next;

                if(cur2 != null){
                    prev.next = cur2;
                    prev = cur2;
                    cur2 = cur2.next;
                }
            }
        }

    }
//23. 合并 K 个升序链表
    class Solution5 {
        public ListNode mergeKLists(ListNode[] lists) {
            int k = lists.length;
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while (true) {
                ListNode minNode = null;
                int minPointer = -1;
                for (int i = 0; i < k; i++) {
                    if (lists[i] == null) {
                        continue;
                    }
                    if (minNode == null || lists[i].val < minNode.val) {
                        minNode = lists[i];
                        minPointer = i;
                    }
                }
                if (minPointer == -1) {
                    break;
                }
                tail.next = minNode;
                tail = tail.next;
                lists[minPointer] = lists[minPointer].next;
            }
            return dummyHead.next;
        }
    }
//    23. 合并 K 个升序链表
    class Solution6 {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists,0,lists.length - 1);
        }

        public ListNode merge(ListNode[] lists,int left, int right){
            if(left > right) return null;
            if(left == right) return lists[left];

            //1.先平分数组
            int mid = (left + right)/2;
            //[left ,mid] [mid + 1,right]

            // 2.递归处理左右两部分
            ListNode l1 = merge(lists,left,mid);
            ListNode l2 = merge(lists,mid+1,right);

            //3.合并两个有序链表
            return mergeTwoList(l1,l2);
        }
        public ListNode mergeTwoList(ListNode l1,ListNode l2){
            if(l1 == null) return l2;
            if(l2 == null) return l1;

            // 合并两个有序链表
            ListNode head = new ListNode(0);
            ListNode cur1 = l1,cur2 = l2,prev = head;
            while(cur1 != null && cur2 != null){
                if(cur1.val <= cur2.val){
                    prev.next = cur1;
                    prev = cur1;
                    cur1 = cur1.next;
                }else{
                    prev.next = cur2;
                    prev = cur2;
                    cur2 = cur2.next;
                }
            }
            if(cur1 != null){
                prev.next = cur1;
            }
            if(cur2 != null){
                prev.next = cur2;
            }

            return head.next;
        }
    }

    class Solution7 {
        public ListNode reverseKGroup(ListNode head, int k) {
            // 1.先求出需要逆序多少组
            int n = 0;
            ListNode cur = head;
            while(cur != null){
                cur = cur.next;
                n++;
            }
            n /= k;
            // 2.重复n次 ：长度为k的链表的逆序
            ListNode newHead = new ListNode(0);
            ListNode prev = newHead;
            cur = head;
            for(int i = 0; i < n; i++){
                ListNode tmp = cur;
                for(int j = 0; j < k; j++){
                    // 头插
                    ListNode next = cur.next;
                    cur.next = prev.next;
                    prev.next = cur;
                    cur = next;
                }
                prev = tmp;
            }
            // 把后面不需要逆序的连接上
            prev.next = cur;
            return newHead.next;
        }
    }
//217. 存在重复元素

class Solution8 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int x : nums){
            if(hash.contains(x)){
                return true;
            }
            hash.add(x);
        }
        return false;
    }
}
}
