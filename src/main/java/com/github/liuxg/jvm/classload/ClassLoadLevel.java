package com.github.liuxg.jvm.classload;

import sun.awt.HKSCS;
import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @author xinguai.liu
 */
public class ClassLoadLevel {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(HKSCS.class.getClassLoader());
        System.out.println(DNSNameService.class.getClassLoader());
        System.out.println(ClassLoadLevel.class.getClassLoader());

        System.out.println(DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ClassLoadLevel.class.getClassLoader().getClass().getClassLoader());
    }
}
