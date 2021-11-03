package src.main.DoublePointerSkill.loopInvariant;

import java.util.PriorityQueue;
import java.util.Random;

public class No215KthLargestElement {
    private static Random random = new Random(System.currentTimeMillis());

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        // 第k大的元素的下标是len - k（即使有相同元素也是占一位的）
        int target = len - k;

        while(true){
            // 利用快排的一次划分来判断枢轴元素
            int index = partition(nums, left, right);

            // 若返回的元素的下标恰好满足，则返回
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
    // 快速排序的思想
    public static int partition(int[] nums, int left, int right){
        // 在区间内随机选择一个元素作为枢轴值，如果随机数组足够大，那么就可以是等分的概率
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        // 将等于pivot的元素分散在两边 [left,le)<= pivot (ge,right]>=pivot
        int le = left + 1;
        int ge = right;
        while(true){
            // 当nums[le]>=pivot的时候跳出循环
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



    // 堆排序
    /*
    1.维护一个只有k个元素的最小堆，
    2.元素数量超过k的时候就pop堆顶元素，
    （因为堆顶一直是存放最小元素，所以最后留下的那个堆 的堆顶就是第k大的元素）
    */
    public static int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String [] args){
        int [] nums = {2,4,1,3,5,6};
        int k = 2;
        System.out.println("== QuickSork ==");
        System.out.println(findKthLargest(nums,k));
        System.out.println("== HeapSork ==");
        System.out.println(findKthLargest2(nums,k));
    }
    
}
