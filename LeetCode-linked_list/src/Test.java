/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-16
 * Time: 20:12
 */
public class Test {
//21. 合并两个有序链表
    class Solution1 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null){
                return list2;
            } else if(list2 == null){
                return list1;
            } else if(!(list1.Val() >= list2.Val())){
                list1.next = mergeTwoLists(list1.next,list2);
                return list1;
            }else{
                list2.next = mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
    }
}
