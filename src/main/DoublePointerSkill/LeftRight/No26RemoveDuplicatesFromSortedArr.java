package src.main.DoublePointerSkill.LeftRight;

public class No26RemoveDuplicatesFromSortedArr {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return len;
        }
        // 区间为【0,j) 左闭右开区间
        int j = 1;
        // j表示要赋值的元素的下标
        int pre = nums[0];
        for (int i = 1; i < len; i++){
            // 因为pre是第一个数，一定不会重复，所以i可以从1开始
            if (nums[i] != pre){
                nums[j] = nums[i];
                pre = nums[j];
                // pre永远指向第一个不重复的数
                j++;

            }
        }

        return j;
        
    }

    public static void main (String[] args){
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));

        /*
        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
        ！也就是说，你需要把不重复的数按照升序排列在前j个里面
        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).


        */

    }
}
