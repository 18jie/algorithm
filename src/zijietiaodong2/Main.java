package zijietiaodong2;

import java.util.List;
import java.util.Scanner;

/**
 * 找到所有的分割，遍历找出合规的分割
 * @author fengjie
 * @date 2018:09:09
 */
public class Main {

    public int solution(){
        Scanner sc = new Scanner(System.in);
        String ip = String.valueOf(sc.nextInt());
        if(ip.length() == 4){
            return 1;
        }

        return 0;
    }

    /**
     * 难点在于怎么获取所有的切分
     * @param ip
     * @return
     */
    public List<String> getAllSplit(String ip){
        if(ip.length() == 5){

        }
        return null;
    }

}
