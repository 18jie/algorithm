package jianzhioffer;

/**
 * @author fengjie
 * @date 2018:11:29
 */
public class IsNumeric {

    public boolean isNumeric(char[] str) {
        if (str.length == 0 || (str.length == 1 && (str[0] < '0' || str[0] > '9')) || str[0] == '.') {
            return false;
        }
        int eTimes = 0;
        int comTimes = 0;

        for (int i = 0; i < str.length; i++) {
            if ((str[i] >= 'a' && str[i] < 'e') || (str[i] > 'e' && str[i] <= 'z') || (str[i] >= 'A' && str[i] < 'E') || (str[i] > 'E' && str[i] <= 'Z')) {
                return false;
            }

            if (i != 0 && (str[i] == '+' || str[i] == '-')){
                return false;
            }
            if(i == str.length - 1 && (str[i] == 'e' || str[i] == 'E' || str[i] == '.')){
                return false;
            }
            if(str[i] == '.'){
                comTimes++;
            }
            if(str[i] == 'e' || str[i] == 'E'){
                eTimes++;
            }
        }
        if(eTimes > 1 || comTimes > 1){
            return false;
        }
        return true;
    }

}
