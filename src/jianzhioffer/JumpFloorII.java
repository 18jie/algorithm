package jianzhioffer;

/**
 * 由数学归纳法得到，结果f(n) = 2 * f(n - 1);
 * 及f(n) = 2^(n-1);
 * @author fengjie
 * @date 2018:11:04
 */
public class JumpFloorII {

    public int JumpFloorII(int target) {
        return (int) Math.pow(2,target-1);
    }

}
