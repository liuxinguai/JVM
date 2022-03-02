package com.github.liuxg.jvm.oom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xinguai.liu
 */
public class T15_FullGC_Demo1 {

    private static class CardInfo {
        BigDecimal price = new BigDecimal(0.0);
        String name = "张三";
        int age = 5;
        Date birth = new Date();
        public void m() {}
    }

    private static ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(50,new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException {
        executorService.setMaximumPoolSize(50);
        for (;;) {
            moodelFirst();
            Thread.sleep(100);
        }
    }

    private static void moodelFirst() {
        List<CardInfo> allCardInfo = getAllCardInfo();
        allCardInfo.forEach(cardInfo -> {
            executorService.scheduleWithFixedDelay(()->{
                cardInfo.m();
            },2,3, TimeUnit.SECONDS);
        });
    }

    private static List<CardInfo> getAllCardInfo() {
        List<CardInfo> cardInfos = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            cardInfos.add(new CardInfo());
        }
        return cardInfos;
    }

}
