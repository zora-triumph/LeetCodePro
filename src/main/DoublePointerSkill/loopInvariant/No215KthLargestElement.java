package src.main.DoublePointerSkill.loopInvariant;

import java.util.Random;

public class No215KthLargestElement {
    private static Random random = new Random(System.currentTimeMillis());
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        
        int target = len - k;

        while(true){
            int index = partition(nums, left, right);
            if (index == target){
                return nums[index];
            }
            else if (index < target){
                left++;
            }
            else {
                right--;
            }
        }

    }
    public static int partition(int[] nums, int left, int right){
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        while(true){
            while(le <= ge && nums[le] < pivot){
                le++;
            }
            while(le <= ge && nums[ge] > pivot){
                ge--;
            }
            if (le > ge){
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;

        }
        swap(nums, left, ge);
        return ge;

    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String [] args){
        int [] nums = {2,4,1,3,5,6};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }
    
}
