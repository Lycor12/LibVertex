package com.libvertex.math.util;

import java.lang.reflect.Method;

public class InterfaceHelper {
    public static void callMethod(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, args.getClass());
        method.invoke(obj, args);
    }
}
