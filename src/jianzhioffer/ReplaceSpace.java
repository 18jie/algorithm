package jianzhioffer;

/**
 * @author fengjie
 * @date 2018:10:21
 */
public class ReplaceSpace {

    public String todo(StringBuffer str){
        StringBuffer result = new StringBuffer();
        for (char c:str.toString().toCharArray()) {
            if(c == ' '){
                result.append("%20");
            }else{
                result.append(c);
            }
        }
        return result.toString();
    }

}
