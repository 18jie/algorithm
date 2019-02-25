package jianzhioffer;

/**
 * @author fengjie
 * @date 2018:11:04
 */
public class JumpFloor {

    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }


    public static void main(String[] args) {
        JumpFloor j = new JumpFloor();
        int i = j.JumpFloor(4);
        System.out.println(i);
    }

    // 1 2 1: 1 1 2 , 1 2 1 , 2 1 1
    //832040
    //322365

}
