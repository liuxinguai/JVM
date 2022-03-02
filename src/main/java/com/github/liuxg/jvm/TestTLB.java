package com.github.liuxg.jvm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xinguai.liu
 */
public class TestTLB {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    private class User {

        private int id;

        private String name;
    }

    public void alloc(int i) {
        new User(i, "liuxg"+i);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TestTLB testTLB = new TestTLB();
        for (int i = 0; i < 1000000; i++) {
            testTLB.alloc(i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}
