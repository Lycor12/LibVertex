package com.libvertex.math.util;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class InterfaceHelper {
    public static boolean implementsInterface(Class<?> clazz, Class<?> interfaceClass) {
        return interfaceClass.isAssignableFrom(clazz);
    }
    public static List<Class<?>> getImplementingClasses(String packageName, Class<?> interfaceClass) {
        List<Class<?>> classes = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);
            List<File> dirs = new ArrayList<>();
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                dirs.add(new File(resource.getFile()));
            }
            for (File directory : dirs) {
                classes.addAll(findClasses(directory, packageName, interfaceClass));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName, Class<?> interfaceClass) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    classes.addAll(findClasses(file, packageName + "." + file.getName(), interfaceClass));
                } else if (file.getName().endsWith(".class")) {
                    Class<?> clazz = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
                    if (interfaceClass.isAssignableFrom(clazz) && !clazz.isInterface()) {
                        classes.add(clazz);
                    }
                }
            }
        }
        return classes;
    }
    public static <T> T createInstance(Class<T> interfaceClass, Class<?> implementingClass) {
        try {
            return interfaceClass.cast(implementingClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Object invokeMethod(Object instance, String methodName, Class<?>[] parameterTypes, Object... args) {
        try {
            Method method = instance.getClass().getMethod(methodName, parameterTypes);
            return method.invoke(instance, args);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static List<Method> getInterfaceMethods(Class<?> interfaceClass) {
        return Arrays.asList(interfaceClass.getDeclaredMethods());
    }


}
