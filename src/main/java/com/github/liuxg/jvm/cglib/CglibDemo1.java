package com.github.liuxg.jvm.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class CglibDemo1 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new CglibProxy());
        UserService proxy = (UserService) enhancer.create();
        proxy.findBy("1");
    }

    static class CglibProxy implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("invoke "+method.getName()+" before");
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("invoke "+method.getName()+" after");
            return result;
        }
    }
}
