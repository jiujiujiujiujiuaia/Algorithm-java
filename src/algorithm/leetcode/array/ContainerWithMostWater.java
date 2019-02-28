package algorithm.leetcode.array;

/**
 * @Author yuchunwei
 */
public class ContainerWithMostWater {
    //基本不可取 又是模拟的做法 把每种情况做出来
    public int maxArea(int[] height) {
        int i = 0 , j = height.length - 1;
        int best = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
        while ( i < j) {
            if(height[i+1] < height[i] && height[j-1] < height[j] ){
                i++;
                j--;
            }
            else if(height[i+1] > height[i] && height[j-1] < height[j]){
                int temp = (j - i - 1) * (height[i+1] > height[j] ? height[j] :height[i+1]);
                if(temp > best) best = temp;
                i++;
            }
            else if(height[i+1] < height[i] && height[j-1] > height[j]){
                int temp = (j - i - 1) * (height[i] > height[j - 1] ? height[j -1] :height[i]);
                if(temp > best) best = temp;
                j--;
            }
            else {
                int temp = (j - i - 2) * (height[i+1] > height[j-1] ? height[j-1] :height[i+1]);
                if(temp > best) best = temp;
                i++;j--;
            }
        }
        return best;
    }
    //0（n）最优解
    public int maxArea2(int[] height) {
        int start = 0 ,end = height.length - 1 ;
        int best = 0 ;
        while (start < end){
            best = Math.max(best , Math.min(height[start],height[end]) * (end - start));
            if(height[start] > height[end]){
                end--;
            }
            else {
                start++;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        ContainerWithMostWater withMostWater = new ContainerWithMostWater();
        withMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}   
