package com.github.liuxg.jvm.cglib;

import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author xinguai.liu
 */
public class CglibDemo2 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback((Dispatcher) () -> new UserService() {
            @Override
            public UserBean findBy(String id) {
                return new UserBean(id,"id-"+id);
            }
        });
        UserService userService = (UserService)enhancer.create();
        System.out.println(userService.findBy("liuxg"));
        userService.save(new UserBean("001","sss"));
    }
}
