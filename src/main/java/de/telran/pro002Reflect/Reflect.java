package de.telran.pro002Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Template> templateClass = Template.class;
        Field[] fields = templateClass.getFields();
        //.getDeclaredField;

        for (Field f : fields){
            System.out.println("Filed: " + f);
        }
        fields[0].setAccessible(true);

        Method method = templateClass.getMethod("getInsideNummer");
        System.out.println("Method: " + method);
        System.out.println("Method: " + method.getName());
        System.out.println("Method: " + method.getReturnType());

    }

}
