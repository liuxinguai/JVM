package com.github.liuxg.jvm.classload;

import java.awt.ActiveEvent;

/**
 * @author xinguai.liu
 */
public class CustomActiveEvent implements ActiveEvent {
    @Override
    public void dispatch() {
        System.out.println("customer");
    }
}
