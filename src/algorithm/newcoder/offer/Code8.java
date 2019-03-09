package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 剪绳子
 */
public class Code8 {

    public static int maxProductAfterCut(int length){
        int[] res = new int[length+1];
        res[1] = 1;
        for(int i = 2 ; i <= length ; i++){
            int best = i - 1;
            for(int j = 1 ; j < i ; j++){
                int temp = (res[j] > j ? res[j] : j) * (res[i - j] > i - j ? res[i - j] :i - j );
                if(temp > best) best = temp;
            }
            res[i] = best;
        }
        return res[length];
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCut(12));
    }

}
