package src.OfferI.Day1;

import java.util.LinkedList;

public class CQueue {
    /*
        用两个栈实现一个队列。
        队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
        (若队列中没有元素，deleteHead 操作返回 -1 )

        输入：
        ["CQueue","appendTail","deleteHead","deleteHead"]
        
        [[],[3],[],[]]  说明这一行是参数
        
        输出：[null,null,3,-1]


    */
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public CQueue(){
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();

    }
    public void appendTail(int value){
        stack1.add(value);

    }
    public int deleteHead(){
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());

            }
            return stack2.pop();
        }
        return stack2.pop();

    }
    
}
