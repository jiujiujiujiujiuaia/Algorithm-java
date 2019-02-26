package newcoder.offer;

/**
 * @Author yuchunwei
 * 替换空格
 */
public class Code2 {

    public static  String replaceSpace(StringBuffer str) {
        char[] string = str.toString().toCharArray();
        int usedLength = string.length ;
        // 统计字符数组中的空白字符数
        int whiteCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (string[i] == ' ') {
                whiteCount++;
            }
        }
        // 计算转换后的字符长度是多少
        int targetLength = whiteCount * 2 + usedLength;
        int tmp = targetLength; // 保存长度结果用于返回
        // 如果没有空白字符就不用处理
        if (whiteCount == 0) {
            return str.toString();
        }
        char[] string1 = new char[targetLength];
        usedLength--; // 从后向前，第一个开始处理的字符
        targetLength--; // 处理后的字符放置的位置
        // 字符中有空白字符，一直处理到所有的空白字符处理完

        while (usedLength >= 0 ) {
            // 如是当前字符是空白字符，进行"%20"替换
            if (string[usedLength] == ' ') {
                string1[targetLength--] = '0';
                string1[targetLength--] = '2';
                string1[targetLength--] = '%';
            } else { // 否则移动字符
                string1[targetLength--] = string[usedLength];
            }
            usedLength--;
        }
        return new String(string1);
    }


    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("aaaa ");
        System.out.println(replaceSpace(stringBuffer));

    }
}   
