package jianzhioffer;

/**
 * @author fengjie
 * @date 2018:11:04
 */
public class NumberOf1 {

    public int NumberOf1(int n) {
        if(n == Integer.MIN_VALUE){
            return 1;
        }
        if(n == 0){
            return 0;
        }else if(n > 0){
            return calcPositive(0,n);
        }else{
            return 33 - calcPositive(0,-n) - calcNagetive(-n);
        }
    }

    public int calcPositive(int times,int num){
        if(num == 0){
            return times;
        }
        times += num % 2;
        return calcPositive(times,num/2);
    }

    public int calcNagetive(int num){
        int temp = num % 2;
        int nums = 0;
        while(temp != 1 && num != 0){
            nums++;
            num = num / 2;
            temp = num % 2;
        }
        return nums;
    }

    public double Power(double base, int exponent) {
        if(exponent > 0){
            return powerPostive(base, exponent);
        }else{
            return powerNegative(base,-exponent);
        }
    }

    public double powerPostive(double base,int exponent){
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public double powerNegative(double base,int exponent){
        return 1/powerPostive(base,exponent);
    }

    public static void main(String[] args) {
        NumberOf1 n = new NumberOf1();
        System.out.println(n.Power(2,-3));
    }
}
