package lesson23.task1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws  IllegalAccessException, NoSuchFieldException {
        String s = "Hello";
        System.out.println(s);

        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);

        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);

        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        byte[] value = {'A', 'B', 'C', 'D', 'E'};
        field.set(s, value);

        System.out.println(s);

    }
}