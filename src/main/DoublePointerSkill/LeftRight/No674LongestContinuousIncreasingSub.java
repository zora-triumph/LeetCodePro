package src.main.DoublePointerSkill.LeftRight;

public class No674LongestContinuousIncreasingSub {
    public static int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int left = 0, right = 0;
        // 左闭右开的区间[left,right)
        int len = nums.length;
        while(right < len){
            if (right > 0 && nums[right-1] >= nums[right]){
                // 如果不满足右边的数比左边的大，则窗口收缩（重新构造窗口，因为前面的都不满足），left直接移到right
                left = right;
                
            }
            right++;
            res = Math.max(res, right-left);

        }
        return res;
        
    }

    public static void main(String[] args){
        int[] nums = {1,2,5,4,8};
        System.out.println(findLengthOfLCIS(nums));
    }
}
