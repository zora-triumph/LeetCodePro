package src.OfferI.Day1;


public class MinStack {
    /*
    定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.min();   --> 返回 -3.
    minStack.pop();
    minStack.top();      --> 返回 0.
    minStack.min();   --> 返回 -2.

    */

    private Node head;
    public MinStack(){

    }
    public void push(int x) {
        if(head == null){
            head = new Node(x, x, null);
        }
        else{
            // head.min 
            head = new Node(x, Math.min(x, head.min), head);
        }

    }
    
    public void pop() {
        head = head.next;

    }
    
    public int top() {
        return head.val;

    }
    
    public int min() {
        return head.min;

    }

    // 利用链表来构造栈
    private class Node {
        int val;
        int min;
        Node next;

        // 不能写成public void Node
        public Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    
}
