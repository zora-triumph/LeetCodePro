public class No2AddTwoNum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode outNode = new ListNode();
        ListNode head3 = outNode;
        int val, c = 0;
        while( l1 != null && l2 != null){
            val = l1.val + l2.val + c;
            c = val / 10;
            val = val % 10;
            outNode.next = new ListNode(val);
            outNode = outNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            val = l1.val + c;
            c = val / 10;
            val = val % 10;
            outNode.next = new ListNode(val);
            outNode = outNode.next;
            l1 = l1.next;
        }
        while (l2 != null){
            val = l2.val + c;
            c = val / 10;
            val = val % 10;
            outNode.next = new ListNode(val);
            outNode = outNode.next;
            l2 = l2.next;
        }
        if (c != 0){
            outNode.next = new ListNode(c);
        }

        return head3.next;
    }

    public static void main(String[] args){
        




    }
}