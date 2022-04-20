package src.OfferI.Day2;

import java.util.ArrayList;

// 从尾到头打印链表
public class ReverseListNode {
    // 方法一：利用数组 反向添加
    public int[] reversePrint(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        int[] nums = new int[count];
        // 反向填充数组，记得取=0，因为是从0- 【count-1】
        for(int i = count-1 ; i >= 0; i--){
            nums[i] = head.val;
            head = head.next;

        }
        return nums;
    }

    // 方法二：递归法
    ArrayList<Integer> tmp = new ArrayList<>();
    public int[] reversePrint2(ListNode head){
        recur(head);
        int [] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
    // 递归阶段每次传入node.next，以node==null为递归终止条件
    public void recur(ListNode node){
        if(node == null){
            return ;
        }
        node = node.next;
        tmp.add(node.val);
    }
}
