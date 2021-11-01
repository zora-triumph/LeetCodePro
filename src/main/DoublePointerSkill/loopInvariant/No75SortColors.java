package src.main.DoublePointerSkill.loopInvariant;

public class No75SortColors {
    public static int[] sortColors(int[] nums) {
        // 快速排序的思想，一次划分就可以使选定的元素的左边都小于等于它，右边都大于等于它
        // p0,p2是一首一尾两个指针，然后向中间靠拢
        // [0,p0) == 0
        // [p0,i) == 1
        // [p2,len-1) == 2
        int len = nums.length;
        if (len < 2){
            return nums;
        }
        int p0 = 0;
        int i = 0;
        int p2 = len - 1;
        while (i <= p2){
            // 因为p2和i重合的元素也需要比较
            if(nums[i] == 0){
                swap(nums, i, p0);
                i++;
                p0++;
            }
            else if(nums[i] == 1){
                i++;
            }
            else {
                // nums[i] == 2
                swap(nums, i, p2);
                p2--;
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static void main(String args[]){
        int[] nums = {2,1,1,0,0,2};
        int[] res = sortColors(nums);
        for (int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
    
}
