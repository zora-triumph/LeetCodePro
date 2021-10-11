package src.main.DoublePointerSkill.LeftRight;
import java.util.HashSet;
import java.util.Set;

public class No3lengthofLongestSubtr {
    public static int lengthOfLongestSubstring1(String s) {
        int[] last = new int[128];
        for (int j = 0; j < 128; j++) {
            last[j] = -1;
        }
        int len = s.length();
        int res = 0; // 不重复字符串长度
        int start = 0; // 不重复字符串的开始位置
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i); // 返回下标i对应的字符的ASII
            // char str = s.charAt(i);  返回下标i对应的字符
            start = Math.max(start, last[index] + 1); // 出现重复字符时，start才会向后移动
            res = Math.max(res, i - start + 1); // 不重复的字符串的长度 
            last[index] = i;
        }
        return res;

    }

    /*
    * 滑动窗口法
    * 注意：子串是连续的，而子序列是可以不连续的
    * 记录这个窗口中的最大值或者最小值
    * 本题中：这个窗口内的字符是不重复的，左右位置都是从start开始，一旦end出现重复的值，则左边开始向右收缩
    * 每一次加入新的值都需要记录整个窗口的大小
    */
    public static int lengthOfLongestSubstring2(String s){
        int res = 0; // 记录最长子串长度
        int len = s.length();
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>(); // 使用set容器存储不重复的子串
        while(start < len && end < len){
            if(set.contains(s.charAt(end))){ // 窗口右边end出现重复的值
                set.remove(s.charAt(start++));  //左边窗口开始向右收缩，并且要将之间的start值移除掉
            }
            else{
                set.add(s.charAt(end++)); // 无重复值，则窗口向右滑动
                res = Math.max(res, end-start); // 不用end-start+1，因为start并不包括边界
            } 
        }
        return res;
    }
    public static void main(String args[]){
        String testStr = "abcdabcabc";
        int result = lengthOfLongestSubstring2(testStr);
        System.out.println(result);

    }
}
