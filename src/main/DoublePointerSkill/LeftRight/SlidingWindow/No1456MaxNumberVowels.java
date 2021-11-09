package src.main.DoublePointerSkill.LeftRight.SlidingWindow;

public class No1456MaxNumberVowels {
     // 滑动窗口
    public static int maxVowels1(String s, int k) {
        int maxLen = 0;
        int left = 0, right = 0, count = 0;
        while( right < s.length()){
            char temp = s.charAt(right);
            if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u'){
                count++;
            }
            right++;
            if(right - left == k){
                maxLen = Math.max(maxLen, count);
                char l = s.charAt(left);
                if(l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u'){
                    count--;
                }
                left++;

            }
        }
        return maxLen;
    }

    // 前缀和思想1
    public static int maxVowels2(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        int [] prefixSum = new int [n+1];
        for (int i =1; i < n+1; i++){
            prefixSum[i] = prefixSum[i-1] + (isVowel(s.charAt(i-1)) ? 1 :0);
            System.out.println(prefixSum[i]);
        }
        System.out.println("==========");
        for (int i = 0; i < n - k + 1; i++){
            System.out.println(prefixSum[i+k] +" -  "+ prefixSum[i]);
/*
1
1
2
3
4
4
5
5
==========
1 -  0
2 -  1
3 -  1
4 -  1
4 -  2
5 -  3
5 -  4
*/
            // 类似滑动窗口的做法，向右加一个就剔除掉左边那个
            maxLen = Math.max(maxLen, prefixSum[i+k] - prefixSum[i]);
        }
        return maxLen;

    }

    // 类似643的前缀和思想
    public static int maxVowels3(String s, int k) {
        int maxLen = 0;
        int count = 0;
        int i, j;
        for (i = 0; i < k; i++){
            count += isVowel(s.charAt(i)) ? 1 : 0;
        }
        maxLen = count;
        for(j = i + 1; j < s.length(); j++){
            count += (isVowel(s.charAt(j)) ? 1 : 0) - (isVowel(s.charAt(j-k)) ? 1 : 0);
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }
    public static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String [] aStrings){
        // java定义常量字符串用双引号
        String str = "abciiidef";
        int k = 3;
        System.out.println("滑动窗口法");
        System.out.println(maxVowels1(str,k));
        // System.out.println("前缀和 不太好理解！");
        // maxVowels2(str,k);
        // System.out.println(maxVowels2(str,k));

        System.out.println("前缀和 好理解的！");
        System.out.println(maxVowels3(str,k));

    }
    
}
