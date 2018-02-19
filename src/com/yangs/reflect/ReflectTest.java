package com.yangs.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ytadpole on 2018/2/18.
 */
public class ReflectTest {
    public static void main(String[] args){
        //获取类类型
        Class clazz = Book.class;
        try {
            //获取实例
            Book book = (Book) clazz.newInstance();
            //获取待执行方法
            Method method = clazz.getDeclaredMethod("print", int.class, int.class);
            //执行
            method.invoke(book, 10, 20);

            System.out.println("----------");

            Method method2 = clazz.getDeclaredMethod("print", String.class, String.class);
            method2.invoke(book, "hello" , "WORD123");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
class Book{

    public static void print(int a, int b){
        System.out.println("printContent(int, int) 执行结果：" + (a +b));
    }

    public static void print(String a, String b){
        System.out.println("printContent(String, String) 执行结果：" + a + "---" +b);
    }
}
