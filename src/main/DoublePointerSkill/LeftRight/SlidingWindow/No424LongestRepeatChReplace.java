package src.main.DoublePointerSkill.LeftRight.SlidingWindow;

public class No424LongestRepeatChReplace {
    public static int characterReplacement(String s, int k) {
        // sliding window 类似76
        int res = 0;
        int len = s.length();
        if(len < 2){
            return len;
        }
        int left = 0, right = 0;
        // 为了方便将26个字母转换成ASII
        final int A = 'A';
        int[] freq = new int[26];
        int maxCount = 0;

        while(right < len){
            Character cr = s.charAt(right);
            freq[cr - A]++;
            maxCount = Math.max(maxCount, freq[cr - A]);
            right++;
            // 这个判断很重要，主要是为了减少不必要的计算
            /*
                说明k不足以将窗口内的非重复字母全部替换，则此时left就应该移动！
            */
            if(right - left > maxCount + k){
                Character cl = s.charAt(left);
                // left移动时别忘记频率数也要减少
                freq[cl - A]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
        
    } 

    public static void main(String[] aStrings){
        String str = "ABAB"; 
        int k = 2;
        System.out.println(characterReplacement(str, k));

    }
    
}
