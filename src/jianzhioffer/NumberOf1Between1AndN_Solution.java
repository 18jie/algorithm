package jianzhioffer;

/**
 * @author fengjie
 * @date 2018:11:11
 */
public class NumberOf1Between1AndN_Solution {

    public int solution(int n) {
        if(n == 0){
            return 0;
        }else if(n < 10){
            return 1;
        }
        String num = String.valueOf(n);
        int totalOne = 0;
        int times = 10;
        while ((n % times) > 0 && times < n) {
            int head = n / times;
            int end = n % times;
            totalOne += calc(head, end);
            n = n - end;
            times *= 10;
        }
        if (num.startsWith("1")) {
            totalOne += (int) ((num.length() - 1) * Math.pow(10, (num.length() - 2)) + 1);
        } else {
            totalOne += (int) ((Integer.valueOf(String.valueOf(num.charAt(0))) * (num.length() - 1) + 10) * Math.pow(10, num.length() - 2));
        }
        return totalOne;
    }

    public int calc(int head, int end) {
        int headOne = 0;
        String headNum = String.valueOf(head);
        String endNum = String.valueOf(end);
        for (char c : headNum.toCharArray()) {
            if (c == '1') {
                headOne++;
            }
        }
        if (end < 10) {
            return headOne * end + 1;
        } else if (endNum.startsWith("1")) {
            return (int) (headOne * end + (endNum.length() - 1) * Math.pow(10, (endNum.length() - 2)) + 1);
        } else {
            return (int) (headOne * end + (Integer.valueOf(String.valueOf(endNum.charAt(0))) * (endNum.length() - 1) + 10) * Math.pow(10, endNum.length() - 2));
        }
    }

    /**
     * 下面这个算法时间复杂度和我自己写的差不多
     * 可能思路是差不多的
     * @param n
     * @return
     */
    public int solution1(int n){
        int count = 0;//1的个数
        int i = 1;//当前位
        int current = 0,after = 0,before = 0;
        while((n/i)!= 0){
            current = (n/i)%10; //高位数字
            before = n/(i*10); //当前位数字
            after = n-(n/i)*i; //低位数字
            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0)
                count += before*i;
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
            else if(current == 1)
                count += before * i + after + 1;
                //如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
            else{
                count += (before + 1) * i;
            }
            //前移一位
            i = i*10;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution n = new NumberOf1Between1AndN_Solution();

        long start = System.nanoTime();
        n.solution1(999999999);
        long end = System.nanoTime();
        System.out.println("his times : " + (end - start));

        start = System.nanoTime();
        int solution = n.solution(999999999);
        end = System.nanoTime();
        System.out.println("my times : " + (end - start));


        System.out.println(solution);
    }

}
