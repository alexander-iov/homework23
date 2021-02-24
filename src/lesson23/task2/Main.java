package lesson23.task2;

import lesson23.task3.Ignore;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        try {
            info(new Example(100));
        } catch (IllegalAccessException e) {
            e.getStackTrace();
        }
    }

    public static void info(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!declaredField.isAnnotationPresent(Ignore.class)) {
                declaredField.setAccessible(true);
                int modifiers = declaredField.getModifiers();
                System.out.println(Modifier.toString(modifiers) + " " +
                        declaredField.getType() + " " +
                        declaredField.getName() + " " +
                        declaredField.get(object));
            }
        }
    }
}
