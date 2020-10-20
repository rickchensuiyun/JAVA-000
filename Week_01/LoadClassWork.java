package com.mk.stu.demo;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadClassWork {
    public static void main(String[] args) {

        ClassLoader cl = new CustomClassLoader();
        try {
            Class clazz = cl.loadClass("f://Hello.xlass");
//            ReflectionTest.printClassInfo(clazz);
            Method m = clazz.getMethod("hello");
            m.invoke(clazz.newInstance(), null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class clazz = null;
        try {
            byte[] classBytes = loadClassBytes(name);
            clazz = defineClass("Hello", classBytes, 0, classBytes.length);
            if (clazz == null) {
                throw new ClassNotFoundException((name));
            } else {
                System.out.println(">>>>>>>>>>>>>>>>>>>加载成功：" + name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return clazz;
    }

    private byte[] loadClassBytes(String name) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(name));
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return bytes;
    }
}
