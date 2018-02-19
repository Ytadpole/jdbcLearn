package com.yangs.reflect;

/**
 * Created by Ytadpole on 2018/2/18.
 */
public class DynamicAndStaticTest {
    public static void main2(String[] args){
        if("child".equals(args[0])){
            Child child = new Child();
            child.sing();
        }else if("start_man".equals(args[0])){
            StarMan starMan = new StarMan();
            starMan.sing();
        }
    }

    public static void main(String[] args){
        try {
            Class clazz = Class.forName("com.yangs.reflect.Child");
            SingAble singAble = (SingAble) clazz.newInstance();
            singAble.sing();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
