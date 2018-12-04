package java_in_action.RTTI;

import java.lang.reflect.Field;

/**
 * @Author yuchunwei
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Class class1 = Class.forName("java_in_action.RTTI.User");
        User user = (User)class1.newInstance();
        Field field = class1.getDeclaredField("id");
        field.setAccessible(true);
        field.setInt(user,10);
        user.set(100);
        System.out.println(field.get(user));
    }
}   
