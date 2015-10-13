package com.pera.gis.data.dao.impl;

import com.pera.gis.data.model.User;

import java.lang.reflect.Field;

/**
 * Created by csq on 2015/10/10.
 */
public class Test {
    private static final String SPACE = " ";

    public static void main(String args[]) throws IllegalAccessException {
//        Class<User> clz = User.class;
//        System.out.println(clz.getName());
//        String name = clz.getName().substring(clz.getName().lastIndexOf(".") + 1);
//        System.out.println(name);

        User u = new User();
        u.setUsername("test");
        u.setPassword("123");
        createSql(u);

    }

    private static String createSql(Object o) throws IllegalAccessException {
        Class clz = o.getClass();
        String name = clz.getName().substring(clz.getName().lastIndexOf(".") + 1);

        Field[] fields = clz.getDeclaredFields();

        StringBuffer stringBuffer = new StringBuffer("select * from ");
        stringBuffer.append(name).append(SPACE).append("t").append(SPACE).append("where 1 = 1").append(SPACE);

        for(Field field : fields){
            field.setAccessible(true);
            System.out.println(field.getName()+","+field.getType().getName()+","+field.get(o));

            if(field.get(o) != null)
                stringBuffer.append("and").append(SPACE).append("t.").append(field.getName()).append("=").append(field.getName()).append(SPACE);

        }

        System.out.println(stringBuffer.toString());


        return stringBuffer.toString();
    }
}
