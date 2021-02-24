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
                StringBuilder stringBuilder = new StringBuilder();
                declaredField.setAccessible(true);
                int modifiers = declaredField.getModifiers();
                stringBuilder.append(Modifier.toString(modifiers))
                        .append("|")
                        .append(declaredField.getType())
                        .append("|")
                        .append(declaredField.getName())
                        .append("|")
                        .append(declaredField.get(object));
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
