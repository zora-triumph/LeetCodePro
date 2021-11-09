package src.main.DoublePointerSkill.LeftRight.SlidingWindow;

public class No1658MinOpReduceXto0 {
    public static int minOperations(int[] nums, int x) {
        int m = -1;
        int left = 0, right = 0;
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
        }
        int target = sum - x;
        // 利用滑动窗口方式 ，求中间最长连续窗口的和 为sum - x
        int diff = 0;
        while(right < len){
            if(right < len){
                diff += nums[right];
                right++;
            }
            while(diff > target && left < len){
                diff -= nums[left];
                left++;
            }
            if(diff == target){
                // if(diff == target && left < len){ 
                    // 这样会导致样例无法通过，因为此时left = right = len,但是len-m=1
                m = Math.max(right - left, m);
            }
        }
        return m == -1 ? -1 : len - m;
        
    }
    public static void main(String[] args){
        int [] nums = {5};
        int k = 5;
        System.out.println(minOperations(nums,k));


    }
    
}
