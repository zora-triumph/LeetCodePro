package src.main.DoublePointerSkill.LeftRight.SlidingWindow;

public class No1052GrumpyBookstoreOwner {
    // 类似643的固定大小 滑动窗口
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int len = customers.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                // 首先把所有老板不生气的时候，顾客满意的总数计算出来 sum
                sum = sum + customers[i];
                // 把计算过的那些全部置为0，就转换为子数组的最大和
                customers[i] = 0;

            }
        }
        int num = customers[0];
        int maxval = customers[0];
        for (int j = 1; j < len; j++) {
            // 注意，这里j是从1开始的，否则会重复计算
            if (j < minutes) {
                num = num + customers[j];
            } else {
                num = num + customers[j] - customers[j - minutes];
            }
            // 计算出滑动窗口为miutes的满意顾客数量，此时就可以不用管那些是不是满意，反正在窗口内的都满意
            maxval = Math.max(num, maxval);
        }
        return maxval + sum;
    }

    public static void main(String [] args){
        int [] customArr = {1,0,1,2,1,1,7,5};
        int [] grumpyArr = {0,1,0,1,0,1,0,1};
        int x = 3;
        System.out.println(maxSatisfied(customArr, grumpyArr, x));

    }

}
