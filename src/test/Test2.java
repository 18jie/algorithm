package test;
import com.TestUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) {
        new Thread(()->{
            while(1 == 1){
                ArrayList<Integer> list = new ArrayList();
                list.add(1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
