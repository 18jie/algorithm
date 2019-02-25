package jianzhioffer;

/**
 * @author fengjie
 * @date 2018:11:28
 */
public class StrToInt {

    public int StrToInt(String str) {
        if(str.length() == 0){
            return 0;
        }
        int times = 1;
        int total = 0;
        int np = 1;
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0 ; i--) {
            if(chars[i] == 45){
                np = -1;
            }
            if(chars[i] >= 48 && chars[i] <= 57){
                total += (chars[i] - 48) * times;
                times *= 10;
            }else{
                return 0;
            }
        }
        return np * total;
    }

    public static void main(String[] args) {
        char a = '9';
        System.out.println((int)a);
    }

}
