package leetCode;

/**
 * @author fengjie
 * @date 2019:01:02
 */
public class MySqrt {

    public static int mySqrt(int x) {
        if (x < 0) return 0;
        if (x == 0) return 0;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("mid : " + mid);
            if(x / mid < mid){
                right = mid - 1;
            }else if(x / mid > mid){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(19919191));
    }

}
