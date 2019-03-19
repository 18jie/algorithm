package test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fengjie
 * @date 2019/3/8 13:59
 */
public class TestJson {

    public static void main(String[] args) {
//        Map<String,Map<String,String>> fieldEx = new HashMap<>();
//        Map<String,String> map = new HashMap<>();
//        map.put("1001","错误1");
//        map.put("1002","错误2");
//        fieldEx.put("field",map);
//        String s = JSONObject.toJSONString(fieldEx);
//        System.out.println(s);

        List<String> list = new ArrayList<>();
        Class<? extends List> aClass = list.getClass();
        System.out.println(aClass);
    }

}