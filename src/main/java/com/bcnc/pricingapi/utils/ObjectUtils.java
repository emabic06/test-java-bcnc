package com.bcnc.pricingapi.utils;

import java.lang.reflect.Field;

public class ObjectUtils {

    public static boolean areAllFieldsNull(Object obj) {
        if (obj == null) {
            return true;
        }

        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true); // Permite acceder a campos privados

                Object value = field.get(obj);

                if (field.getType().isPrimitive()) {
                    // Verifica si el campo primitivo tiene su valor por defecto
                    if (!isPrimitiveDefaultValue(value, field.getType())) {
                        return false;
                    }
                } else {
                    // Para tipos envolventes u otros objetos
                    if (value != null) {
                        return false;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error al acceder a los campos del objeto", e);
        }

        return true;
    }

    private static boolean isPrimitiveDefaultValue(Object value, Class<?> type) {
        if (type == boolean.class) {
            return Boolean.FALSE.equals(value);
        } else if (type == char.class) {
            return (char) 0 == (char) value;
        } else if (type == byte.class) {
            return (byte) 0 == (byte) value;
        } else if (type == short.class) {
            return (short) 0 == (short) value;
        } else if (type == int.class) {
            return (int) 0 == (int) value;
        } else if (type == long.class) {
            return (long) 0 == (long) value;
        } else if (type == float.class) {
            return (float) 0 == (float) value;
        } else if (type == double.class) {
            return (double) 0 == (double) value;
        }
        return false;
    }
}
