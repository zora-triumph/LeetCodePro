public class No2AddTwoNum {
    // 迭代法
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int total = 0;
        int next1 = 0;
        ListNode result = new ListNode();
        // 辅助指针，在result链表上移动，最后只需要返回result->next
        /* result  
        *    head -> 0  ->  1  ->  2
        *  current一直移动
        */
        ListNode current = result;
        while(l1!=null && l2!=null){
            total = l1.val + l2.val + next1;
            // 新增一个节点
            current.next = new ListNode(total%10);
            next1 = total / 10 ;
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }
        // l1没有走完
        while(l1!=null){
            total = l1.val + next1;
            current.next = new ListNode(total%10);
            next1 = total / 10;
            l1 = l1.next;
            current = current.next;
        }
        // l2没有走完
        while(l2!=null){
            total = l2.val + next1;
            current.next = new ListNode(total%10);
            next1 = total / 10;
            l2 = l2.next;
            current = current.next;
        }
        // 判断最后一位是否需要进位,若进位则需要新加一个节点
        if(next1 != 0){
            current.next = new ListNode(next1);
        }
        // 由于链表存储是从head之后存储的，可以将result看作head
        return result.next;
    }


    // 递归法
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int total = 0;
        int next1 = 0;
        ListNode res = new ListNode();
        /*
        *  l1            l2               next1          total        res
        *   9             9                 1             18           8
        *   9(10)         9                 1             19           9
        *   9(10)        (0)                1             10           0
        *  (0)(1)        (0)                0             1            1
        *
        */
        total = l1.val + l2.val;
        next1 = total / 10;
        res = new ListNode(total%10);
        // 当全为0的时候，递归完成
        if(l1.next!=null || l2.next!=null || next1!=0){
            if(l1.next!=null){
                l1 = l1.next;
            }
            else{
                // 若l1走完了，则补0
                l1 = new ListNode(0); 
            }
            if(l2.next!=null){
                l2 = l2.next;
            }
            else{
                // 若l2走完了，则补0
                l2 = new ListNode(0);
            }
            // 把进位的值加到l1或者l2，实现递归
            l1.val = l1.val + next1;
            res.next = addTwoNumbers2(l1,l2);
        }
        // 递归完成之后，返回整个链表即可，此处没有head
        return res;
    }




    public static void main(String[] args){
    }

}