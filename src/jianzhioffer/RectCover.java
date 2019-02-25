package jianzhioffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：
 * 当n=1时：f(1) = 1;
 * 当n=2时：f(2) = 2;
 * 当n=3时：当n=3的时候，仍然只能采用横着放或者竖着放的方式去覆盖这个矩形，我们仍首先考虑使用竖着放的方式，当竖着放的时候，
 * 由于已经覆盖了左边（假设是从左边开始覆盖的，从右边的覆盖的效果是一样的）一个2*1的矩形，所以还有2个2*1的矩形，而这种情况
 * 我们已经在n=2的时候计算出来了，就是f(2)；接下来我们考虑横着放的情况，由于是横着放，在水平方向已经覆盖了一个2*1的矩形，
 * 所以要想覆盖这由3个2*1组成的矩形，只能在水平方向的覆盖的那个矩形下面继续覆盖一个，那么只剩下一个2*1的矩形了，这也通过前
 * 面的分析计算出来了，就是f(1)。综合以上分析，当n=3的时候，覆盖的方法是f(3)=f(1)+f(2)。
 * @author fengjie
 * @date 2018:11:04
 */
public class RectCover {

    public int RectCover(int target) {
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    public static void main(String[] args) {
        RectCover rectCover = new RectCover();
        int i = rectCover.RectCover(21);
        System.out.println(i);
    }

}
