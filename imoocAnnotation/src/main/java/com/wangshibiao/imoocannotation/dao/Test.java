package com.wangshibiao.imoocannotation.dao;

import javafx.scene.control.Tab;

import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by SamMFFL on 2016/4/24.
 */
public class Test {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);//查询id为10的用户

        Filter f2 = new Filter();
        f2.setUserName("Sam");//模糊查询用户名为Sam的用户

        Filter f3 = new Filter();
        f3.setEmail("sam@163.com,zh@163.com,77777@qq.com");//查询邮箱中的任意一个匹配项
        String q1 = query(f1);
        String q2 = query(f2);
        String q3 = query(f3);

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
    }

    private static String query(Filter f) {
        StringBuilder sb = new StringBuilder();
        //1.获取class
        Class c = f.getClass();
        //2.获取到table的名字
        boolean isExist = c.isAnnotationPresent(Table.class);
        if (!isExist) {
            return null;
        }
        Table table = (Table) c.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");
        //3.遍历所有的值
        Field[] fArray = c.getDeclaredFields();
        for (Field field : fArray) {
            //4.处理每个字段sql
            //拿到字段名，字段值，拼装
            boolean fExist = field.isAnnotationPresent(Column.class);
            if (!fExist) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String coliumnName = column.value();

            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1)
                    .toUpperCase() + fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = getMethod.invoke(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fieldValue == null ||
                    (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
                continue;
            }
            sb.append(" and ").append(fieldName);
            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {
                    sb.append(" in(");
                    String[] values = ((String) fieldValue).split(",");
                    for (String s : values) {
                        sb.append("'").append(s).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                    continue;
                }
                sb.append("=").append("'").append(fieldValue).append("'");
                continue;
            }
            sb.append(" and ").append(fieldName).append(" = ")
                    .append(fieldValue).append("");

        }
        return sb.toString();
    }
}
