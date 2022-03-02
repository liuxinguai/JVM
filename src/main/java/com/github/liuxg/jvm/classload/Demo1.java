package com.github.liuxg.jvm.classload;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xinguai.liu
 */
public class Demo1 {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.github.liuxg.jvm.classload.User");
            Class<User> userClass = User.class;
            Class<?> customClass = new CustomClassLoader().loadClass("com.github.liuxg.jvm.classload.User");
            Class<?> customClass2 = new CustomClassLoader().loadClass("com.github.liuxg.jvm.classload.User");
            Class<?> customClass3 = new CustomClassLoader2().loadClass("com.github.liuxg.jvm.classload.User");
            System.out.println(userClass == aClass);
            System.out.println(userClass == customClass);
            System.out.println(customClass2 == customClass);
            System.out.println(customClass3 == aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class CustomClassLoader extends ClassLoader {

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.startsWith("com.github.liuxg.jvm.classload")) {
                String classPath = name.replace(".", "/").concat(".class");
                InputStream inputStream = Demo1.class.getClassLoader().getResourceAsStream(classPath);
                try {
                    int length = inputStream.available();
                    byte[] bytes = IOUtils.readFully(inputStream, length);
                    return defineClass(name,bytes,0,bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            return super.loadClass(name);
        }

    }

    static class CustomClassLoader2 extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            String classPath = name.replace(".", "/").concat(".class");
            InputStream inputStream = Demo1.class.getClassLoader().getResourceAsStream(classPath);
            try {
                int length = inputStream.available();
                byte[] bytes = IOUtils.readFully(inputStream, length);
                return defineClass(name,bytes,0,bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
