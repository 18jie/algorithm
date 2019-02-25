package com;

public class TestUtil {

    public static void main(String[] args) {
        String sql = "select * from aaa where id = #{id} and tenant_id = #{tenant_id}";
        /**
         * 三种情况: 在开头：只有一个条件 或者 多个条件
         *          在中间 直接替换 tenant_id = #{tenant_id}
         *          在结尾： 替换 tenant_id = #{tenant_id} 这个可能和只有tenant_id的情况重合，并且出错
         *          这种情况使用：if(sql.endWith("and tenant_id = #{...}"))
         *
         * 综合以上: 使用and tenant_id = #{tenant_id} 或者 tenant_id = #{tenant_id}去替换没有问题
         */
    }

}
