package de.telran.pro002Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflect2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Template> templateClass = Template.class;

        Constructor<Template> constructor = templateClass.getConstructor();
        Template obj1 = constructor.newInstance();

        Constructor<Template> constructor2 = templateClass.getConstructor(int.class,
                String.class, String.class, int.class);
        @NotNull(name="AAAA")
        Object obj2 = constructor2.newInstance(1,"str1","str1",2);
        System.out.println(obj2);




    }
}
