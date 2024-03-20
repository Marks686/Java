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
}
