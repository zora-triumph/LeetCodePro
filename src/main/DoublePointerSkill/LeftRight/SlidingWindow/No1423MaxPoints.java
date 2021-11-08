package src.main.DoublePointerSkill.LeftRight.SlidingWindow;

public class No1423MaxPoints {
    // 类似643 采用前缀窗口思想
    public static int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int sum = 0;
        int len = cardPoints.length;
        // 前缀窗口做法
        for (int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        max = sum;
        // 核心！！！ 
        for (int j = 0; j < k; j++){
            // 将末尾的数 依次替换掉 前缀窗口的最右边的数（注意题目意思）
            sum += cardPoints[len-1 -j] - cardPoints[k-1 -j];
            max = Math.max(max, sum);
        }
        return max;
        
    }
    public static void main(String []args){
        int [] points = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(points, k));
    }
    
}
