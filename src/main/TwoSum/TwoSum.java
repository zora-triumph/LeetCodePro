package src.main.TwoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    static HashMap<Integer, Integer> hash = new HashMap<>();
    static HashSet<Integer> sum = new HashSet<>();
    static ArrayList<Integer> nums = new ArrayList<>();

    // 向数据结构添加一个数 number
    public static void add1(int number){
        // 把 <key：number，value：出现次数> 存到hash
        hash.put(number, hash.getOrDefault(number, 0)+1);
    }

    // 寻找当前数据结构中是否存在两个数的和 value
    public static boolean find1(int value){
        for (Integer key : hash.keySet()){
            int diff = value - key;
            // 情况一
            if (diff == key && hash.get(key)>1){
                return true;
            }
            // 情况二
            if (diff != value && hash.containsKey(diff)){
                return true;
            }
        }
        return false;
    }

    // 用set记录所有可能的和的值；用list存储新增加的number
    public static void add2(int number){
        for(int n : nums){
            sum.add(n+number);
        }
        nums.add(number);
    }

    // 对find进行优化，时间复杂度为O(1)
    public static boolean find2(int value){
        if (sum.contains(value)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        add1(3);
        add1(2);
        add1(3);
        add1(5);
        System.out.println(find1(6)); //true
        System.out.println(find1(7)); //true


        System.out.println("=== ==== ==  ==== === ==== ==");
        add2(3);
        add2(2);
        add2(3);
        add2(5);
        System.out.println(find2(6)); //true
        System.out.println(find2(7)); //true

    }
}