package leetCode;

/**
 * @author fengjie
 * @date 2018:12:02
 */
public class Divide {

    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        int result = 0;
        if (dividend < 0 && divisor > 0) {
            divisor = -divisor;
            while(dividend - divisor <= 0){
                dividend -= divisor;
                result--;
                if(result == Integer.MIN_VALUE){
                    return result;
                }
            }
        }
        if(dividend > 0 && divisor < 0){
            dividend = -dividend;
            while(dividend - divisor <= 0){
                dividend -= divisor;
                result--;
                if(result == Integer.MIN_VALUE){
                    return result;
                }
            }
        }
        if(dividend > 0 && divisor > 0){
            dividend = -dividend;
            divisor = -divisor;
            while(dividend - divisor <= 0){
                dividend -= divisor;
                result++;
                if(result == Integer.MAX_VALUE){
                    return result;
                }
            }
        }
        if(dividend < 0 && divisor < 0){
            while(dividend - divisor <= 0){
                dividend -= divisor;
                result++;
                if(result == Integer.MAX_VALUE){
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Divide d = new Divide();
        int divide = d.divide(-10, -2);
        System.out.println(divide);
    }

}
