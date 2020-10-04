/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xingguo.effective.java.concurrency;

import lombok.extern.slf4j.Slf4j;

/**
 * VisibilityDemo
 *
 * @author guoxing
 * @date 2020/10/4 8:54 PM
 * @since
 */
@Slf4j
public class VisibilityDemo {
    public static void main(String[] args) throws InterruptedException {
        canStop();
    }

    public static boolean flag;

    public static void canStop() throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!flag) {
                i++;
            }
            // 当前代码永远不会被执行到
            log.info("{}:线程结束:{}",Thread.currentThread().getName(),i);
        });
        thread.start();
        Thread.sleep(1000);
        flag = true;
        thread.join();
    }
}
