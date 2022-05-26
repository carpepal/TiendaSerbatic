package com.example.tiendacarlos.principal;

import com.example.tiendacarlos.entities.Usuarios;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Test {
    public static void main(String[] args) throws Exception {
        Usuarios usuario = new Usuarios();
        Usuarios usuario1 = new Usuarios();

        usuario.setId(2);
        usuario.setNombre("Juan");

        usuario1.setIdRol(2);
        usuario1.setClave("123");
        usuario1.setNombre("calvo");

        System.out.println(mergeObjects(usuario, usuario1));
    }

    public static Object mergeObjects(Object source, Object target) throws Exception {
        Field[] allFields = source.getClass().getDeclaredFields();
        for (Field field : allFields) {
            if(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())){
                continue;
            }

            if (!field.isAccessible() && Modifier.isPrivate(field.getModifiers()))
                field.setAccessible(true);

            if(field.get(source) == null){
                field.set(source, field.get(target));
            }
            if (field.get(source) != null) {
                if(field.getName().equals("id") && (Integer)field.get(target) == 0)
                    continue;
               if(field.get(target) != null ){
                   field.set(source , field.get(target));
               }

            }
        }

        return source;
    }
}
