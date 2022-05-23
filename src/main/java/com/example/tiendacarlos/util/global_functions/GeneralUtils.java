package com.example.tiendacarlos.util.global_functions;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GeneralUtils {

    public static Object merge(Object original , Object cambios ) throws IllegalAccessException {
        Field[] fields = original.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())){
                continue;
            }
            if(!field.isAccessible() && Modifier.isPrivate(field.getModifiers())){
                field.setAccessible(true);
            }

            if(field.get(original) == null)
                field.set(original, field.get(cambios));

            if(field.get(original) != null){
                if(field.getName().equals("id") && (Integer)field.get(cambios) == 0)
                    continue;

                if(field.get(cambios) != null)
                    field.set(original, field.get(cambios));
            }

        }

        return original;
    }
}
