package src.main.DoublePointerSkill.LeftRight.SlidingWindow;

public class No76MinWinSubstring {
    // 【注意】 子串必须是连续的，另外T中可能出现重复的字符
    // 暴力破解法（时间复杂度S^3+T,空间复杂度S+T 主要是频数数组）
    /*
        1.枚举S中长度大于等于T的长度3的所有子串
        2.对这些子串逐步判断，是否含有T的所有字母，而且每个字母出现的频率得一致
        3.满足上述条件的子串，取最小值
    */

    // 滑动窗口 sliding-window
    /*
        1.首先让right移动到窗口内包含了T所有的字符（此时不需要考虑right右边的字符，因为那个子串只会更大）
        2.此时向右移动left，使得窗口变短到刚好不包含T中所有的字符，则right开始向右移动
       
        如何判断区间内包含T的所有字符呢？ 对比频数数组的方式
        1.对T做频数统计，设置distance表示T中有多少个不同的字母
        2.left 和 right移动的时候，只对T中出现的字母做统计
        3.right移动的时候，频数增加，增加到刚好和T对应字母相等，distance-1，当distance==0时，滑动窗口内包含T所有字母的最小子串
        4.left移动的时候，频数做减法，减少到比T中对应字符个数小1的时候，平衡被打破，则right继续右移
    */
    public static  String minWindow(String s, String t) {
        if(s==null || s.isEmpty() || t==null || t.isEmpty()){
            return "";
        }
        int[] Tmap=new int[256];
        int[] Smap=new int[256];
        int left = 0, right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        String res = "";

        for(int i = 0; i < t.length(); i++){
            Tmap[t.charAt(i)]++;
        }
        while(right < s.length()){
            if(valid < t.length()){
                if(Tmap[s.charAt(right)]>0){
                    Smap[s.charAt(right)]++;
                    if(Smap[s.charAt(right)] <= Tmap[s.charAt(right)]){
                        valid++;
                    }
                }
            }
            right++;
            while(valid == t.length()){
                if(right - left < len){
                    len = right - left;
                    res = s.substring(left, right);
                }
                if (Tmap[s.charAt(left)]>0){
                    Smap[s.charAt(left)]--;
                    if(Smap[s.charAt(left)]<Tmap[s.charAt(left)]){
                        valid--;
                    }
                }
                left++;   
            }   
        }

        return res;
        
    }

    public static void main (String[] args){
        String str1 = "ADOBECODEBANC";
        String str2 = "ABC";
        System.out.println(minWindow(str1, str2));
    }
    
}
