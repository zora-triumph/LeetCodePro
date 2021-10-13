package src.main.DoublePointerSkill.LeftRight;

public class No26RemoveDuplicatesFromSortedArr {
    public static int removeDuplicates1(int[] nums) {
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
    public static int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return len;
        }
        // 采用区间为[0,j] 闭区间
        int j = 0;
        for (int i = 1; i < len; i++){
            if (nums[i] != nums[j]){
                // j++;
                // 注意：此处应该是先移动j指针再赋值
                nums[++j] = nums[i];
                
            }
        }

        return j+1;
        // 因为j=0的时候，就已经有一个数
        
    }



    public static void main (String[] args){
        int[] nums1 = {1,1,2};
        System.out.println(removeDuplicates1(nums1));

        int[] nums2 = {0,0,1,1,2,3,4,4,5,6,6};
        System.out.println(removeDuplicates2(nums2));
        /*
        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
        ！也就是说，你需要把不重复的数按照升序排列在前j个里面
        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).


        */

    }
}
