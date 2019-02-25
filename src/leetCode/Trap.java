package leetCode;

/**
 * @author fengjie
 * @date 2018:12:09
 */
public class Trap {

    public int trap(int[] height) {
        return trapHelper(height,0);
    }

    public int trapHelper(int[] height, int result) {
        int[] newHeight = new int[height.length];
        int negetiveNums = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                while (i < height.length && height[i] > 0) {
                    i++;
                }
//                System.out.println(" start Index : " + i);
                int len = 0;
                while (i < height.length && height[i] <= 0) {
                    i++;
                    len++;
                }
//                System.out.println("len : " + len);
                if (i < height.length) {
                    result += len;
                }
                i--;
//                System.out.println("result : " + result);
            } else if (height[i] < 0) {
                negetiveNums++;
            }
        }
        for (int i = 0; i < height.length; i++) {
            newHeight[i] = height[i] - 1;
        }
        if(negetiveNums == height.length){
            return result;
        }
        return trapHelper(newHeight, result);
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Trap t = new Trap();
        int trap = t.trap(height);
        System.out.println(trap);
    }

}
