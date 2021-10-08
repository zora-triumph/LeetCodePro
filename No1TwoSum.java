import java.util.HashMap;

// 暴力破解法
public class No1TwoSum{
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        int result[] = new int[2];
        for (int i = 0; i < len; i++){
            for (int j = i+1; j < len; j++){
                if (target == nums[i] + nums[j]){
                    result[0] = i;
                    result[1] = j;
                    return result; // 此处一定会跳出
                }
            }
        }
        return result;

    }


// 哈希表法
    public static int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        int result[] = new int[2];
        // Hash Map
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for (int i = 0; i < len; i++){
            // 以 key=num[i],value=i 的方式存储
            hash.put(nums[i],i);
        }

        for (int j = 0; j < len; j++){
            int diff = target - nums[j]; 
            if(hash.containsKey(diff) && hash.get(diff)!=j){
                // 避免同一个元素在答案中出现，比如target=6，nums=[3],则结果可能是[0,0]
                result[0] = j;
                result[1] = hash.get(diff);
                return result; // 这一句很关键，不然结果会覆盖
            }
        }

        return result;

    }


    public static void main(String[] args){
        int[] arr = {2,7,11,15};
        int sum = 9;
        int[] index = twoSum2(arr,sum);
        System.out.println(index[0]);
        System.out.println(index[1]);

    }
}