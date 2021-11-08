package src.main.DoublePointerSkill.LeftRight.SlidingWindow;

public class No643MaxAvgSubarr {
    public static double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        // 注意定义为double
        double max;
        int sum = 0;
        // 前缀窗口的思想
        for (int i = 0; i < k; i++){
            sum = sum + nums[i];
        }
        // 第一个窗口确定，但是因为是固定窗口大小
        max = sum;
        for (int j = k; j < len; j++){
            // 滑动窗口的思想，每次先加一个最右边，再减去一个最左边，注意边界
            sum = sum + nums[j] - nums[j-k];
            max = Math.max(sum, max);
        }
        return max / k;
    }
    public static void main (String[] args){
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums,k));

    }
    
}
