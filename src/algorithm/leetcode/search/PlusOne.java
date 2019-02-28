package algorithm.leetcode.search;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int last = digits[length-1];
        if(last == 9){
            int point = length-1;
            while(digits[point] == 9){
                digits[point] = 0;
                point--;
                if(point<0){
                    break;
                }
            }
            if(point>=0){
                digits[point] = digits[point] + 1;
            }
            else {
                int[] result = new int[length+1];
                result[0] = 1;
                for(int i =1;i<length;i++){
                    result[i]=0;
                }
                return result;
            }
        }
        else{
            digits[length-1] = digits[length-1]+1;
        }
        return digits;
    }
}
