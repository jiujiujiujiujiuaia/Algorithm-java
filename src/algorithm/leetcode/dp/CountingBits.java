package algorithm.leetcode.dp;

public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        if(num>1){
            int j = 1;
            result[1] = 1;
            for (int i = 2; i < num+1; i++) {
                if (i > j && i < 2 * j) {
                    result[i] = result[j] + result[i - j];
                    continue;
                }
                result[i] = 1;
                j *= 2;
            }
        }
        else if(num == 1){
            result[1] = 1;
        }
        return result;
    }

    public static void main(String[] args){
        CountingBits countingBits = new CountingBits();
        for(int i:countingBits.countBits(1)){
            System.out.println(i);
        }
    }
}
