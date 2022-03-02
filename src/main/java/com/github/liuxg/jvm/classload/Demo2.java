package com.github.liuxg.jvm.classload;

/**
 * @author xinguai.liu
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.security.manager"));
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
