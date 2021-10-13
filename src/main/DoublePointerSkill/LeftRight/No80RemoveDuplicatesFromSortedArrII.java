package src.main.DoublePointerSkill.LeftRight;

public class No80RemoveDuplicatesFromSortedArrII {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 3){
            return len;
        }
        int j =2;
        // 类似26题，选择左闭右开的区间[i,j)
        // 由于前两个元素肯定是不会发生改变，所以i，j都从2开始
        for(int i = 2; i < len; i++){
            if( nums[j-2] != nums[i]){
                // 只需要判断当前元素（也就是i所在的位置）是否与前两位j-2的元素是否相同
                nums[j++] = nums[i];
            }
        }
        return j;  
    }

    public static void main(String[] args){
        int[] nums = {1,2,2,2,3,3,4,4,4,4,5};
        System.out.println(removeDuplicates(nums));

    }
    
}
