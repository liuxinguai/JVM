package com.github.liuxg.jvm.classload;

import java.awt.*;
import java.util.ServiceLoader;

/**
 * @author xinguai.liu
 */
public class Demo3 {

    public static void main(String[] args) {
        ServiceLoader<ActiveEvent> events = ServiceLoader.load(ActiveEvent.class);
        events.forEach(activeEvent -> activeEvent.dispatch());
    }

}
