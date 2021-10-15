package src.main.DoublePointerSkill.LeftRight;

public class No283MoveZeros{
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
                // 把非零的都移动到前面
            }
        }
        while(j < len){
            nums[j++] = 0;
            // 后面的全部赋值0
        }
    }
}