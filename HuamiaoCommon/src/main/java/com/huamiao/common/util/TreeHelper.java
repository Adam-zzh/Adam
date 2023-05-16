package com.huamiao.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈list转tree〉
 *
 * @author ZZH
 * @create 2021/5/21
 * @since 1.0.0
 */
public class TreeHelper<T> {

    /**
     * 默认ID字段
     */
    private static final String DEFAULT_ID = "id";
    /**
     * 默认父级id字段
     */
    private static final String DEFAULT_PARENT_ID = "pid";
    /**
     * 默认子级 集合字段
     */
    private static final String DEFAULT_CHILDREN = "children";
    /**
     * 顶级节点的 父级id
     */
    private static final Object TOP_PARENT_ID = 0;

    public static <T> List<T> createTree(List<T> list) {
        return createTree(list, DEFAULT_ID, DEFAULT_PARENT_ID, DEFAULT_CHILDREN);
    }

    public static <T> List<T> createTree(List<T> list, String idName) {
        return createTree(list, idName, DEFAULT_PARENT_ID, DEFAULT_CHILDREN);
    }

    public static <T> List<T> createTree(List<T> list, String idName, String pIdName, String childName) {
        List<T> result = new ArrayList<T>();
        try {
            for (T t : list) {
                Class<?> aClass = t.getClass();
//                Field parentId = aClass.getDeclaredField(pIdName);
                Field parentId =getField(aClass, pIdName);
                parentId.setAccessible(true);
                Object o = parentId.get(t);
                if (String.valueOf(o).equals(String.valueOf(TOP_PARENT_ID))) {
                    result.add(t);
                }
            }
            for (T parent : result) {
                recursiveTree(parent, list, idName, pIdName, childName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static <T> T recursiveTree(T parent, List<T> list, String idName, String pIdName, String childName) throws Exception {
        List<T> children = new ArrayList<T>();
        Class<?> pClass = parent.getClass();
//        Field id = pClass.getDeclaredField(idName);
        Field id =getField(pClass, idName);
        id.setAccessible(true);
        Object o = id.get(parent);
        for (T t : list) {
            Class<?> aClass = t.getClass();
//            Field parentId = aClass.getDeclaredField(pIdName);
            Field parentId =getField(aClass, pIdName);
            parentId.setAccessible(true);
            Object o1 = parentId.get(t);
            if (String.valueOf(o).equals(String.valueOf(o1))) {
                t = recursiveTree(t, list, idName, pIdName, childName);
                children.add(t);
            }
        }
//        Field child = pClass.getDeclaredField(childName);
        Field child =getField(pClass, childName);
        child.setAccessible(true);
        child.set(parent, children);
        return parent;
    }

    private static Field getField(Class clazz, String fieldName){
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        }catch (NoSuchFieldException e){
            if (clazz.getSuperclass() != null && clazz.getSuperclass() != Object.class){
                return getField(clazz.getSuperclass(), fieldName);
            }
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return field;
    }
}