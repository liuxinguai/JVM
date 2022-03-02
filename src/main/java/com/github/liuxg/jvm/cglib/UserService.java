package com.github.liuxg.jvm.cglib;

public class UserService {

    public UserBean findBy(String id) {
        System.out.println("查找ID："+id);
        return new UserBean(id,"id:"+id);
    }

    public String save(UserBean userBean) {
        System.out.println("save user");
        return userBean.getId();
    }

    public String update(UserBean userBean) {
        System.out.println("update user");
        return userBean.getId();
    }

}
