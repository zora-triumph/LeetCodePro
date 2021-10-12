package src.main.DoublePointerSkill.LeftRight.SlidingWindow;

public class No76MinWinSubstring {
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
