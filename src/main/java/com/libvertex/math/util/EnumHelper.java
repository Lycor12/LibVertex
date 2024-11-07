package com.libvertex.math.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.function.Function;


public class EnumHelper {
    private static Random random = new Random();

    public static <T extends Enum<?>> T randomEnum(Class<T> enumClass) {
        T[] constants = enumClass.getEnumConstants();
        return constants[random.nextInt(constants.length)];
    }
    public static <T extends Enum<T>> T getEnumByName(Class<T> enumClass, String name) {
        try {
            return Enum.valueOf(enumClass, name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // or handle the error as needed
        }
    }

    public static <T extends Enum<?>> List<T> getEnumValues(Class<T> enumClass) {
        return Arrays.asList(enumClass.getEnumConstants());
    }
    public static <T extends Enum<?>> T getEnumByOrdinal(Class<T> enumClass, int ordinal) {
        T[] constants = enumClass.getEnumConstants();
        if (ordinal < 0 || ordinal >= constants.length) {
            return null;
        }
        return constants[ordinal];
    }
    public static <T extends Enum<?>> boolean enumValueExists(Class<T> enumClass, String name) {
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.name().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    public static <T extends Enum<?>> List<String> enumValuesToStringList(Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
    public static <T extends Enum<?>> Map<String, T> enumValuesToMap(Class<T> enumClass, Function<T, String> keyMapper) {
        return Arrays.stream(enumClass.getEnumConstants())
                .collect(Collectors.toMap(keyMapper, Function.identity()));
    }
}
