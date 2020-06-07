package me.amar.trollassistant.api;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionUtil {

    @SneakyThrows
    public static Class getNMSClass(String clazz) {
        return Class.forName("net.minecraft.server." + NMS.getNMSVersion() + "." + clazz);
    }

    @SneakyThrows
    public static Class getOBCClass(String clazz) {
        return Class.forName("org.bukkit.craftbukkit." + NMS.getNMSVersion() + "." + clazz);
    }

    @SneakyThrows
    public static Method getMethod(String method, Class clazz, Class... classes) {
        return clazz.getMethod(method, classes);
    }

    @SneakyThrows
    public static Object invokeMethod(Method method, Object obj, Object... classes) {
        return method.invoke(obj, classes);
    }

    @SneakyThrows
    public static Constructor getConstructor(Class clazz, Class... classes) {
        return clazz.getConstructor(classes);
    }

    @SneakyThrows
    public static Object instantiate(Constructor constructor, Object... objs) {
        return constructor.newInstance(objs);
    }

    @SneakyThrows
    public static Object getField(String field, Class clazz, Object obj) {
        return clazz.getField(field).get(obj);
    }
}
